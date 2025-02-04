package org.example.config.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosRequest {
    @NotNull(message = "el campo no puede ser null")
    private String username;

    @NotNull(message = "el campo no puede ser null")
    private String password;

    @NotNull(message = "el campo no puede ser null")
    private String nombre; // Se corrigió "nome" a "nombre"
}
