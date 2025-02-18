package org.example.config.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;  // Cambiado a UUID

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean status;

    @Column(nullable = false, unique = true)
    private String email;

    private String role;

    @Column(nullable = false)
    private String clave;
}
