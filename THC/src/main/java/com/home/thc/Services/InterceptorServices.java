package com.home.thc.Services;

import com.home.thc.Model.Interceptor;
import com.home.thc.Repository.InterceptorRepository;
import com.home.thc.Services.Interface.InterceptorInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class InterceptorServices implements InterceptorInterface {

    InterceptorRepository interceptorRepo;

    public InterceptorServices(InterceptorRepository interceptorRepo){
        this.interceptorRepo = interceptorRepo;
    }

    @Override
    public Interceptor storeInterceptor(Interceptor interceptor) {
        return interceptorRepo.save(interceptor);
    }

    @Override
    public List<Interceptor> getInterceptorByUrl(String url) {
        return interceptorRepo.findByUrl(url);
    }

    @Override
    public List<Interceptor> getInterceptorByDate(String date) {
        return interceptorRepo.findByUrlDate(date);
    }
}
