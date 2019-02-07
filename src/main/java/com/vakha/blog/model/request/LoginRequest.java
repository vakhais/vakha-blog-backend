package com.vakha.blog.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Created by Vakha.
 * User: Hyun Jin Park
 * Date: 2019-01-27
 */
public class LoginRequest {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
