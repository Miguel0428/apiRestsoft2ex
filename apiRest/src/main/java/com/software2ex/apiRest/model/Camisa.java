package com.software2ex.apiRest.model;

public class Camisa {

    private Long id;
    private String name;
    private float value;

    public Camisa() {
    }

    public Camisa(Long id, String name, float value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    
}
