package com.home.thc.Interceptor;

import com.home.thc.Model.Interceptor;
import com.home.thc.Services.InterceptorServices;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Log4j2
public class ExecutionTimeInterceptor implements HandlerInterceptor {

    InterceptorServices interceptorServices;

    public ExecutionTimeInterceptor(InterceptorServices interceptorServices){
        this.interceptorServices = interceptorServices;
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request,
                                @NotNull HttpServletResponse response, @NotNull Object object, Exception arg3) {

        try {
            long startTime = (Long) request.getAttribute("startTime");
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            log.info("Request URL: {}", request.getRequestURL());
            log.info("Total Time Taken: {}", (endTime - startTime));

            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
            Date resultDate = new Date(endTime);

            Interceptor interceptor = new Interceptor();

            interceptor.setUrlDate(sdf.format(resultDate));
            interceptor.setExecutionTime(executionTime);
            interceptor.setUrl(request.getRequestURL().toString());

            Interceptor _interceptor = interceptorServices.storeInterceptor(interceptor);

            if(_interceptor == null) {
                log.error("Error while saving interceptor to DB! {}",new Throwable().getStackTrace()[0].getMethodName());
            }
        }catch(Exception e) {
            log.error("Error at the interceptor level! {}",new Throwable().getStackTrace()[0].getMethodName());
        }

    }


    @Override
    public boolean preHandle(HttpServletRequest request,
                             @NotNull HttpServletResponse response, @NotNull Object object) {

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        return true;
    }
}
