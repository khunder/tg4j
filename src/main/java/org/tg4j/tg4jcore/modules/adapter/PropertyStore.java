package org.tg4j.tg4jcore.modules.adapter;

import org.tg4j.tg4jcore.modules.domain.model.Property;

import java.util.List;
import java.util.Optional;

public interface PropertyStore {

    public Property addProperty(String name, String value);
    public Property deleteProperty(String name);
    public Property updateProperty(String name, String value);
    public Property getProperty(String name);
    public List<Property> getProperties(Optional<Object> searchCriteria, int page, int size);
}
