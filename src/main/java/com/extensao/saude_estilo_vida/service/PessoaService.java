package com.extensao.saude_estilo_vida.service;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import com.extensao.saude_estilo_vida.model.PessoaModel;
import com.extensao.saude_estilo_vida.model.UsuarioModel;
import com.extensao.saude_estilo_vida.repository.PessoaRepository;
import com.extensao.saude_estilo_vida.repository.UsuarioRepository;
import com.extensao.saude_estilo_vida.dto.PessoaDTO;
import java.util.Optional;

@Service
public class PessoaService {
  
  private final PessoaRepository pessoaRepository;
  private final UsuarioRepository usuarioRepository;

  public PessoaService(PessoaRepository pessoaRepository, UsuarioRepository usuarioRepository) {
    this.pessoaRepository = pessoaRepository;
    this.usuarioRepository = usuarioRepository;
  }

  public PessoaDTO verPessoa(Long id){
    return pessoaRepository.findById(id)
      .map(p -> new PessoaDTO(p))
      .orElseThrow(() -> new RuntimeException("Erro ao buscar pessoa"));
  }

  public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDTO){
    PessoaModel pessoa = new PessoaModel();
    System.out.println(pessoaDTO);
    UsuarioModel usuario = usuarioRepository.findById(pessoaDTO.getIdUsuario())
      .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    if(usuario.getPessoa() == null){
      pessoa.setNome(pessoaDTO.getNome());
      pessoa.setIdade(pessoaDTO.getIdade());
      pessoa.setAltura(pessoaDTO.getAltura());
      pessoa.setPeso(pessoaDTO.getPeso());
      pessoa.setSexo(pessoaDTO.getSexo());
      pessoa.setUsuario(usuario);
      usuario.setPessoa(pessoa);

      pessoaRepository.save(pessoa);
      
      return new PessoaDTO(pessoa);
    }else{
      throw new RuntimeException("Usuário já possui uma pessoa cadastrada");
    }
    
  }
}
