package com.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.demo.domain.Hello;
import com.demo.domain.World;

import io.u2ware.common.data.jpa.config.EnableRestfulJpaRepositories;

@Configuration
@EnableRestfulJpaRepositories
@EnableJpaRepositories
public class ApplicationApiConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // 초반 경로 설정
        config.setBasePath("/api");

        // 응답에 ID 찍기
        config.exposeIdsFor(Hello.class, World.class);

        cors.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowCredentials(false).maxAge(999999);

    }

}
