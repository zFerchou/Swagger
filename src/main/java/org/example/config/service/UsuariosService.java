package org.example.config.service;

import org.example.config.model.UsuariosRequest;  // Asegúrate de que esta importación sea correcta
import org.example.config.model.UsuariosResponse;

public interface UsuariosService {
    // Método que recibe un UsuariosRequest como parámetro
    UsuariosResponse createUsuario(UsuariosRequest usuariosRequest);
}
