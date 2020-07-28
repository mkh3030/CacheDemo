package com.example.cacheh2.domain;

public class CacheDomain {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CacheDomain [id=" + id + ", name=" + name + "]";
    }

    
    
}