package org.tg4j.tg4jcore.model;

import java.util.ArrayList;
import java.util.List;

public class ExecutionContext {
    private boolean status;
    List<String> executionLog = new ArrayList<>();
    public ExecutionContext modifyStatus(String strategy, boolean status){
        this.status = status;
        executionLog.add("status was modified by strategy:%s , new value= %s".formatted(strategy,status));
        return this;
    }


    public List<String> getExecutionLog() {
        return executionLog;
    }


    public boolean getStatus() {
        return status;
    }
}
