package org.example.config.controller;

import org.example.config.model.Usuario;
import org.example.config.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{clave}")
    public Usuario obtenerUsuario(@PathVariable String clave) {
        return usuarioService.obtenerUsuarioPorClave(clave);
    }

    @PostMapping
    public void crearUsuario(@RequestBody Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/{clave}")
    public void eliminarUsuario(@PathVariable String clave) {
        usuarioService.eliminarUsuarioPorClave(clave);
    }
}
