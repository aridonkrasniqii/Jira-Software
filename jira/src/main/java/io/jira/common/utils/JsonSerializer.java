package io.jira.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonSerializer {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectNode createObjectNode() {
        return objectMapper.createObjectNode();
    }
}
