package org.tg4j.tg4jcore.infrastructure.mapper;

import org.tg4j.tg4jcore.infrastructure.entities.FileFeature;
import org.tg4j.tg4jcore.infrastructure.entities.FileProperty;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.domain.model.Property;

public class PropertyMapper {

    public static Property toDomain(FileProperty fileProperty){
        final var property  = new Property();
        property.setName(fileProperty.getName());
        property.setValue(fileProperty.getValue());
        return property;
    };
}
