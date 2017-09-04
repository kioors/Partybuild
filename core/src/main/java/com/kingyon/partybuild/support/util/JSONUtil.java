package com.kingyon.partybuild.support.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jackson.JacksonUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;

public class JSONUtil {

    private static final ObjectMapper objectMapper = JacksonUtils.newMapper();
    private static final JsonFactory jsonFactory = objectMapper.getFactory();

    public static String getJSON(Object object) {
        StringWriter json = new StringWriter();
        try {

            JsonGenerator jsonGenerator = jsonFactory.createGenerator(json);
            jsonGenerator.writeObject(object);
            return json.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(json);
        }
    }


    public static <T> T parseJson(String json, Class<T> clazz) throws JsonParseException, IOException {


        return objectMapper.readValue(json, clazz);

    }
}
