package com.demo.api.worlds;

import com.demo.domain.World;

import io.u2ware.common.data.jpa.repository.RestfulJpaRepository;

public interface WorldRepository extends RestfulJpaRepository<World, Long> {

}
