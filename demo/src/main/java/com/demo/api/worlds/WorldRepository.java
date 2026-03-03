package com.demo.api.worlds;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.domain.World;

public interface WorldRepository extends JpaRepository<World, Long> {

}
