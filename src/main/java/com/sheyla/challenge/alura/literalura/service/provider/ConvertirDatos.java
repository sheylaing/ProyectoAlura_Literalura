package com.sheyla.challenge.alura.literalura.service.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ConvertirDatos implements IConvertirDatos {

    private static ConvertirDatos instance;
    private ObjectMapper objectMapper = new ObjectMapper();

    private ConvertirDatos() {}
    public static synchronized ConvertirDatos getInstance() {
        if (instance == null) {
            instance = new ConvertirDatos();
        }
        return instance;
    }
    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
