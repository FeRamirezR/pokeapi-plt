package com.pokeapi.poketest.initializer;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.pokeapi.poketest.service.TypeService;

@Component
public class TypeDataInitializer {

    private final TypeService typeService;

    public TypeDataInitializer(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostConstruct
    public void initializeTypeData() {
        int limit = 20; // Número de registros a obtener por solicitud
        int offset = 0; // Punto de inicio
        typeService.saveTypesData(limit, offset);
        System.out.println("Type data initialized successfully!");
    }
}