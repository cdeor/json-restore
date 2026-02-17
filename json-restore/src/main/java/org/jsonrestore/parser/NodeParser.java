package org.jsonrestore.parser;

import com.fasterxml.jackson.databind.JsonNode;

public interface NodeParser {
    JsonNode parse(JSONParser jsonParser);
}
