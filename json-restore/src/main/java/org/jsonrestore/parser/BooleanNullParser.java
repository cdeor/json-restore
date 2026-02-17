package org.jsonrestore.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ValueNode;

import static org.jsonrestore.Constants.END;
import static org.jsonrestore.Json.FACTORY;

public class BooleanNullParser implements NodeParser {

    private enum BooleanValue {

        TrueVal("true", FACTORY.booleanNode(true)),
        FalseVal("false", FACTORY.booleanNode(false)),
        NullVal("null", FACTORY.nullNode());

        private final String value;
        private final ValueNode node;

        BooleanValue(String value, ValueNode node) {
            this.value = value;
            this.node = node;
        }
    }

    @Override
    public JsonNode parse(JSONParser parser) {
        // <boolean> is one of the literal strings 'true', 'false', or 'null' (unquoted)
        int startIndex = parser.getIndex();
        char ch = Character.toLowerCase(parser.getCharAt());

        for (BooleanValue boolVal : BooleanValue.values()) {

            int i = 0;
            while (ch != END && i < boolVal.value.length() && ch == boolVal.value.charAt(i)) {
                i += 1;
                parser.shift();
                ch = Character.toLowerCase(parser.getCharAt());
            }

            if (i == boolVal.value.length()) {
                return boolVal.node;
            }
        }

        // If nothing works reset the index before returning
        parser.setIndex(startIndex);
        return FACTORY.missingNode();
    }
}