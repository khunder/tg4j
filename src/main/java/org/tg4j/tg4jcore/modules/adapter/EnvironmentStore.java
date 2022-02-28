package org.tg4j.tg4jcore.modules.adapter;

import org.tg4j.tg4jcore.modules.domain.model.Environment;
import org.tg4j.tg4jcore.modules.domain.model.FeatureConfiguration;
import org.tg4j.tg4jcore.modules.cases.get_environment.dto.FindEnvironmentsDto;

import java.util.List;
import java.util.stream.Stream;

public interface EnvironmentStore {

    public FeatureConfiguration addEnvironment(String name, String value);
    public FeatureConfiguration deleteEnvironment(String name);
    public FeatureConfiguration getEnvironment(String name);
    public void addProperty(String name, String value);
    public void removeProperty(String name);
    public List<Environment> getEnvironments(FindEnvironmentsDto searchCriteria, int page, int size);
    public List<Environment> getEnvironmentsByIds(List<String> ids);

}
