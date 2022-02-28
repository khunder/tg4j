package org.tg4j.tg4jcore.infrastructure.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.tg4j.tg4jcore.infrastructure.entities.FileEnvironment;
import org.tg4j.tg4jcore.infrastructure.mapper.EnvironmentMapper;
import org.tg4j.tg4jcore.modules.domain.model.Environment;
import org.tg4j.tg4jcore.modules.domain.model.FeatureConfiguration;
import org.tg4j.tg4jcore.modules.adapter.EnvironmentStore;
import org.tg4j.tg4jcore.infrastructure.entities.FileEnvs;
import org.tg4j.tg4jcore.modules.cases.get_environment.dto.FindEnvironmentsDto;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class FileEnvironmentStoreImpl implements EnvironmentStore {

    static Logger logger = LoggerFactory.getLogger(FileEnvironmentStoreImpl.class);

    final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    private String fileName;


    public FileEnvironmentStoreImpl(String fileName) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.fileName = fileName;
    }


    @Override
    public FeatureConfiguration addEnvironment(String name, String value) {
        throw new NotImplementedException("");
    }

    @Override
    public FeatureConfiguration deleteEnvironment(String name) {
        throw new NotImplementedException("");
    }

    @Override
    public FeatureConfiguration getEnvironment(String name) {
        throw new NotImplementedException("");
    }

    @Override
    public void addProperty(String name, String value) {
        throw new NotImplementedException("");
    }

    @Override
    public void removeProperty(String name) {
        throw new NotImplementedException("");
    }

    @Override
    public List<Environment> getEnvironments(FindEnvironmentsDto searchCriteria, int page, int size) {
        if (StringUtils.isNotEmpty(fileName)) {
            try {

                YAMLParser yamlParser = new YAMLFactory().createParser(new ClassPathResource("/" + fileName).getFile());
                List<FileEnvs> envs = mapper.readValues(yamlParser, FileEnvs.class).readAll()
                        .stream()
                        .filter(f -> f.getEnv() != null)
                        .toList();
                if(envs.size() > 1 ){
                    throw new RuntimeException("more than one section of environment is defined");
                }
                if(envs.size() == 0 ){
                    throw new RuntimeException("environment section is not defined");
                }
                var env = envs.get(0);
                return env.getEnv().stream().map(EnvironmentMapper::toDomain).toList();

            } catch (Exception e) {
                logger.error("cannot read features ", e);
            }
        }
        return null;
    }

    @Override
    public List<Environment> getEnvironmentsByIds(List<String> ids) {
        if (StringUtils.isNotEmpty(fileName)) {
            try {

                YAMLParser yamlParser = new YAMLFactory().createParser(new ClassPathResource("/" + fileName).getFile());
                List<FileEnvironment> envs = mapper.readValues(yamlParser, FileEnvs.class)
                        .readAll().stream().map(FileEnvs::getEnv)
                        .filter(Objects::nonNull)
                        .flatMap(Collection::stream)
                        .toList();

                return envs.stream().map(EnvironmentMapper::toDomain).toList();
            } catch (Exception e) {
                logger.error("cannot read features ", e);
            }
        }
        throw new NotImplementedException("");

    }
}
