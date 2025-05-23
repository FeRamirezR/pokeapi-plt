package com.pokeapi.poketest.dto;

import java.util.List;

public class PokemonApiResponseDto {
    private int count;
    private String next;
    private String previous;
    private List<PokemonApiResultDto> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<PokemonApiResultDto> getResults() {
        return results;
    }

    public void setResults(List<PokemonApiResultDto> results) {
        this.results = results;
    }
}