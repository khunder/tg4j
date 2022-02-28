package org.tg4j.tg4jcore.infrastructure.mapper;

import org.tg4j.tg4jcore.infrastructure.entities.FileEnvironment;
import org.tg4j.tg4jcore.modules.domain.model.Environment;

public class EnvironmentMapper {

    /**
     *
     * @param fileEnvironment
     * @return
     */
    public static Environment toDomain(FileEnvironment fileEnvironment){
        final var environment  = new Environment();
        environment.setName(fileEnvironment.getName());
        environment.setGlobalStrategy(fileEnvironment.getGlobalStrategy());
        if(fileEnvironment.getProperties() != null){
            environment.setProperties(fileEnvironment.getProperties().stream().map(PropertyMapper::toDomain).toList());
        }
        return environment;
    };
}
