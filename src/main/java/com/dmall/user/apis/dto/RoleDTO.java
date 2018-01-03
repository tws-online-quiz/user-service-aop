package com.dmall.user.apis.dto;


import com.dmall.user.domain.model.Role;

public class RoleDTO {

    private final String name;

    public RoleDTO(Role role) {
        this.name = role.getName();
    }

    public String getName() {
        return name;
    }
}
