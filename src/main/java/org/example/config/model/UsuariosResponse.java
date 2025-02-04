package org.example.config.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuariosResponse {
    private String username;
    private String password;
    private boolean status;
}