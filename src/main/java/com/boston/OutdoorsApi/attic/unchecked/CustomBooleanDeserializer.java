package com.boston.OutdoorsApi.attic.unchecked;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import java.io.IOException;


public class CustomBooleanDeserializer extends JsonDeserializer<Boolean> {
    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        if(value != null && !value.equals("true") && !value.equals("false")) {
            throw new InvalidFormatException(p, "not boolean value (must be true or false only)", value, Boolean.class);
        }
        return Boolean.valueOf(value);
    }
}
