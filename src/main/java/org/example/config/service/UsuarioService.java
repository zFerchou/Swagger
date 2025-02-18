package org.example.config.service;

import org.example.config.model.Usuario;

public interface UsuarioService {

    void guardarUsuario(Usuario usuario);

    void eliminarUsuarioPorClave(String clave);

    Usuario obtenerUsuarioPorClave(String clave);
}
