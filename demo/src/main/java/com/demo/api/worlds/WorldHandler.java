package com.demo.api.worlds;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.demo.domain.World;

import io.u2ware.common.data.jpa.repository.query.JpaSpecificationBuilder;
import io.u2ware.common.data.rest.core.annotation.HandleBeforeRead;

@Component
@RepositoryEventHandler
public class WorldHandler {

    @HandleBeforeRead
    public void beforeSearch(World world, Specification<World> spec) {
        System.out.println("[beforeSearch] testtesttesttesttesttesttesttest");

        JpaSpecificationBuilder<World> query = JpaSpecificationBuilder.of(World.class);
        query.where()
                .and().eq("name", world.getKeyword()).build(spec);

    }

}
