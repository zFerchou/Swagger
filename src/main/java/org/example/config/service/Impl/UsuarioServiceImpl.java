package org.example.config.service.Impl; // Se corrigió 'mpl' a 'impl'

import org.example.config.model.UsuariosRequest;
import org.example.config.model.UsuariosResponse;
import org.example.config.service.EncryptService;
import org.example.config.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuariosService { // Se agregó 'implements UsuariosService'

    @Autowired
    private EncryptService encryptService;

    @Override
    public UsuariosResponse createUsuario(UsuariosRequest usuariosRequest) {
        // Implementación del método
        return new UsuariosResponse(); // Se agregó un retorno para evitar errores de compilación
    }
}
