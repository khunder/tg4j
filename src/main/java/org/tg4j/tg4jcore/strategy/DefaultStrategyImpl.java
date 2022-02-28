package org.tg4j.tg4jcore.strategy;

import org.springframework.stereotype.Component;
import org.tg4j.tg4jcore.modules.cases.check_feature.dto.Context;
import org.tg4j.tg4jcore.model.ExecutionContext;
import org.tg4j.tg4jcore.modules.domain.model.EntityWithStatus;
import org.tg4j.tg4jcore.modules.domain.model.Feature;

@Component
public class DefaultStrategyImpl implements Strategy {
    @Override
    public String getName() {
        return "default";
    }

    @Override
    public void execute(EntityWithStatus feature, Context context, ExecutionContext executionContext) {
            executionContext.modifyStatus(this.getName(), feature.isStatus());
    }

}
