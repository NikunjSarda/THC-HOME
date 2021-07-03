package com.home.thc.Services.Interface;

import com.home.thc.Model.Interceptor;

import java.util.List;

public interface InterceptorInterface {

    Interceptor storeInterceptor(Interceptor interceptor);
    List<Interceptor> getInterceptorByUrl(String url);
    List<Interceptor> getInterceptorByDate(String date);
}
