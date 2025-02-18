package org.example.config.service.Impl;

import org.example.config.model.Usuario;
import org.example.config.repository.UsuarioRepository;
import org.example.config.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuarioPorClave(String clave) {
        Usuario usuario = usuarioRepository.findByClave(clave); // Busca el usuario por clave
        if (usuario != null) {
            usuarioRepository.delete(usuario); // Elimina el usuario encontrado
        }
    }

    @Override
    public Usuario obtenerUsuarioPorClave(String clave) {
        return usuarioRepository.findByClave(clave); // Obtiene el usuario por clave
    }
}
