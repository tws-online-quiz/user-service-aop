package com.dmall.user.apis.dto;


import com.dmall.user.domain.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String contacts;
    private List<RoleDTO> roles;
    private String name;
    public UserDTO(User user){
        this.name = user.getName();
        this.roles = user.getRoles().stream().map(RoleDTO::new).collect(Collectors.toList());
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}
