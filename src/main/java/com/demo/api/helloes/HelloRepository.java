package com.demo.api.helloes;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.Hello;

// 2026-03-03 이전
// ApplicationTests 파일의 context1(), context2() 테스트할 때에 주석 풀어야 함.
public interface HelloRepository extends JpaRepository<Hello, Long> {

}
