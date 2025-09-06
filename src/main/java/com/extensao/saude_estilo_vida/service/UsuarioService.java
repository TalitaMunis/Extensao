package com.extensao.saude_estilo_vida.service;

import org.springframework.stereotype.Service;
import com.extensao.saude_estilo_vida.repository.UsuarioRepository;
import com.extensao.saude_estilo_vida.model.UsuarioModel;
import com.extensao.saude_estilo_vida.dto.UsuarioDTO;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO verUsuario(Long id){
      return usuarioRepository.findById(id)
        .map(u -> new UsuarioDTO(u))
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    
    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) {
      UsuarioModel usuario = new UsuarioModel();
      usuario.setEmail(usuarioDTO.getEmail());
      usuario.setSenha(usuarioDTO.getSenha());
      
      UsuarioModel usuarioSalvo = usuarioRepository.save(usuario);
      
      return new UsuarioDTO(usuarioSalvo);
    }


}
