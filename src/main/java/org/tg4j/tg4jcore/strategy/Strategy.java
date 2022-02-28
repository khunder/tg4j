package org.tg4j.tg4jcore.strategy;

import org.tg4j.tg4jcore.modules.cases.check_feature.dto.Context;
import org.tg4j.tg4jcore.model.ExecutionContext;
import org.tg4j.tg4jcore.modules.domain.model.EntityWithStatus;
import org.tg4j.tg4jcore.modules.domain.model.Feature;

public interface Strategy {

    String getName();
    public void execute(EntityWithStatus entity, Context context , ExecutionContext executionContext );
}
