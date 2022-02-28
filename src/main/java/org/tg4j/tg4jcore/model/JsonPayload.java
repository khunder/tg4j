package org.tg4j.tg4jcore.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Map;

public class JsonPayload extends ObjectNode {

    public JsonPayload() {
        this(JsonNodeFactory.instance);
    }

    public JsonPayload(JsonNodeFactory nc) {
        super(nc);
    }

    public JsonPayload(JsonNodeFactory nc, Map<String, JsonNode> kids) {
        super(nc, kids);
    }
}
