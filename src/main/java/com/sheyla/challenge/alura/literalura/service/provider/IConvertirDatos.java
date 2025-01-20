package com.sheyla.challenge.alura.literalura.service.provider;

public interface IConvertirDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
