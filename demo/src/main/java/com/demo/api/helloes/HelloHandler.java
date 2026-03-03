package com.demo.api.helloes;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.demo.domain.Hello;

import io.u2ware.common.data.jpa.repository.query.JpaSpecificationBuilder;
import io.u2ware.common.data.rest.core.annotation.HandleBeforeRead;

@Component
@RepositoryEventHandler
public class HelloHandler {

    // 중간을 캐치
    @HandleBeforeCreate
    public void beforeCreate(Hello hello) {

        // 강제로 데이터를 세팅
        // hello.setName("abc");

        // 역할 제한
        // throw new RuntimeException();

        System.out.println("[beforeCreate] testtesttesttesttesttesttesttest");
    }

    @HandleAfterCreate
    public void afterCreate(Hello hello) {
        // Auditing(추적)
        System.out.println("[afterCreate] testtesttesttesttesttesttesttest");
    }

    @HandleBeforeRead
    public void beforeSearch(Hello hello, Specification<Hello> spec) {
        System.out.println("[beforeSearch] testtesttesttesttesttesttesttest");

        JpaSpecificationBuilder<Hello> query = JpaSpecificationBuilder.of(Hello.class);
        query.where()
                .and().eq("name", hello.getKeyword()).build(spec);
    }
}
