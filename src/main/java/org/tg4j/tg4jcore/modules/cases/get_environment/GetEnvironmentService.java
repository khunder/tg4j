package org.tg4j.tg4jcore.modules.cases.get_environment;

import org.springframework.stereotype.Service;
import org.tg4j.tg4jcore.modules.domain.model.Environment;
import org.tg4j.tg4jcore.modules.adapter.EnvironmentStore;
import org.tg4j.tg4jcore.modules.cases.get_environment.dto.FindEnvironmentsDto;

import java.util.List;

@Service
public class GetEnvironmentService {

    private final EnvironmentStore environmentStore;

    public GetEnvironmentService(EnvironmentStore environmentStore) {
        this.environmentStore = environmentStore;
    }

    public List<Environment> getEnvironments(FindEnvironmentsDto searchCriteria){
        return environmentStore.getEnvironments(searchCriteria, 50 , 50);
    }


}
