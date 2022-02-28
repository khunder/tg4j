package org.tg4j.tg4jcore.infrastructure.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.tg4j.tg4jcore.infrastructure.mapper.FeatureMapper;
import org.tg4j.tg4jcore.modules.domain.model.Feature;
import org.tg4j.tg4jcore.modules.adapter.FeatureStore;
import org.tg4j.tg4jcore.infrastructure.entities.FileFeature;
import org.tg4j.tg4jcore.infrastructure.entities.FileFeatures;
import org.tg4j.tg4jcore.modules.cases.get_features.dto.FindFeaturesDto;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class FileFeatureStoreImpl implements FeatureStore {

    static Logger LOGGER = LoggerFactory.getLogger(FileFeatureStoreImpl.class);

    final ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    private String fileName;


    public FileFeatureStoreImpl(String fileName) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.fileName = fileName;
        System.out.println("-----------------------> 1");

    }

    @Override
    public Feature addFeature(String name, boolean status) {
        throw new NotImplementedException("");
    }

    @Override
    public Feature deleteFeature(String name) {
        throw new NotImplementedException("");
    }

    @Override
    public void updateFeatureStatus(String name) {
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
    public void attachEnvironment(String name) {
        throw new NotImplementedException("");
    }

    @Override
    public void detachEnvironment(String name) {
        throw new NotImplementedException("");
    }

    @Override
    public Feature getFeature(String name)  {
        FileFeatures feature = null;
        try {
            feature = mapper.readValue(new ClassPathResource("/" + fileName).getFile(), FileFeatures.class);
            Stream<FileFeature> features = Stream.of(feature.getFeatures());
            return features.filter(queryStr -> queryStr.getName().equals(name)).map(FeatureMapper::toDomain).toList().get(0);
        } catch (IOException e) {
            LOGGER.error("cannot read features file", e);
        }
        return null;

    }

    @Override
    public List<Feature> getFeatures(FindFeaturesDto searchCriteria, int page, int size) {
        if (StringUtils.isNotEmpty(fileName)) {
            try {
                FileFeatures feature = mapper.readValue(new ClassPathResource("/" + fileName).getFile(), FileFeatures.class);

                Stream<FileFeature> features = Stream.of(feature.getFeatures());
                if (StringUtils.isNotEmpty(searchCriteria.name)) {
                    features = features.filter(queryStr ->
                            queryStr.getName().matches(searchCriteria.name.replaceAll("\\*", "\\\\w*"))
                    );
                }

                return features.map(FeatureMapper::toDomain).toList();
            } catch (Exception e) {
                LOGGER.error("cannot read features ", e);
            }
        }
        return null;
    }
}
