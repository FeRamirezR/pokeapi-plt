package com.pokeapi.poketest.dto;

public class NamedAPIResource {
    private String name;
    private String url;

    // Constructor vacío (necesario para el mapeo)
    public NamedAPIResource() {
    }

    public NamedAPIResource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
