package com.nguyen.identity_service.dto.request;

import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    private String username;
    @Size(min=8,message = "Password không được ngắn hơn 8 ký tự")
    private String password;
    private String email;
    private String ext;

    private String role_id;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}
