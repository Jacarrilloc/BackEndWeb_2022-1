package com.backend.projectodesarrolloweb.laesquinadigital.dtos;

public class RolesDato {
    
    protected Long id;

    protected String name;

    public RolesDato() {
    }

    public RolesDato(Long id, String name) {
        this.id = id;
        this.name = name;
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

    
}
