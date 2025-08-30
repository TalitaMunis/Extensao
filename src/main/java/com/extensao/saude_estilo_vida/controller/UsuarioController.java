package com.extensao.saude_estilo_vida.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import com.extensao.saude_estilo_vida.dto.UsuarioDTO;
import com.extensao.saude_estilo_vida.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    public final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obterUsuario(@PathVariable Long id) {
        UsuarioDTO dto = usuarioService.verUsuario(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cadastrar-usuario")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO dto = usuarioService.criarUsuario(usuarioDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dto);
    }
}
