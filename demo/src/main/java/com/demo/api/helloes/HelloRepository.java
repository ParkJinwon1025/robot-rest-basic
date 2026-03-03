package com.demo.api.helloes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Hello;

import io.u2ware.common.data.jpa.repository.RestfulJpaRepository;

// 2026-03-03 이전
// context1(), context2() 실행할 때에 주석 풀어야 함.
// public interface HelloRepository extends JpaRepository<Hello, Long> {

// }

// 2026-03-03 이후
// context3() 수정할 때 주석 풀어야 함. 
public interface HelloRepository extends RestfulJpaRepository<Hello, Long> {

}
