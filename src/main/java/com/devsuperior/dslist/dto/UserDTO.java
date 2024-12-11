package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.UserEntity;

public class UserDTO {

    private String username;
    private String password;

    public UserDTO(){

    }

    public UserDTO(UserEntity user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
