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

    public UsuarioDTO verUsuario(Long id) {
        UsuarioDTO usuario = usuarioRepository.findById(id)
                            .map(u -> new UsuarioDTO(u.getNome(),u.getEmail(),u.getIdade()))
                            .orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        return new UsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getIdade());
    }
    
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setIdade(usuarioDTO.getIdade());
        
        UsuarioModel usuarioSalvo = usuarioRepository.save(usuario);
        
        return new UsuarioDTO(usuarioSalvo);
    }


}
