package com.home.thc.Repository;

import com.home.thc.Model.Interceptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterceptorRepository extends JpaRepository<Interceptor, Long> {

    List<Interceptor> findByUrlDate(String urlDate);
    List<Interceptor> findByUrl(String url);
}
