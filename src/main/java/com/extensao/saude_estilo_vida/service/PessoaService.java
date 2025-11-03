package com.extensao.saude_estilo_vida.service;

// ...existing imports...
import org.springframework.stereotype.Service;

import com.extensao.saude_estilo_vida.model.InfoPessoaisModel;
import com.extensao.saude_estilo_vida.model.PessoaModel;
import com.extensao.saude_estilo_vida.model.UsuarioModel;
import com.extensao.saude_estilo_vida.repository.InfoPessoaisRepository;
import com.extensao.saude_estilo_vida.repository.PessoaRepository;
import com.extensao.saude_estilo_vida.repository.UsuarioRepository;
import com.extensao.saude_estilo_vida.dto.InfoPessoaisDTO;
import com.extensao.saude_estilo_vida.dto.PessoaDTO;
import java.util.Optional;

@Service
public class PessoaService {
  
  private final PessoaRepository pessoaRepository;
  private final UsuarioRepository usuarioRepository;
  private final InfoPessoaisRepository infoPessoaisRepository;

  public PessoaService(PessoaRepository pessoaRepository, UsuarioRepository usuarioRepository, InfoPessoaisRepository infoPessoaisRepository) {
    this.pessoaRepository = pessoaRepository;
    this.usuarioRepository = usuarioRepository;
    this.infoPessoaisRepository = infoPessoaisRepository;
  }

  // Busca Pessoa pelo usuarioId (FK)
  public PessoaDTO verPessoaPorUsuarioId(Long usuarioId){
    return pessoaRepository.findByUsuarioId(usuarioId)
      .map(p -> new PessoaDTO(p))
      .orElseThrow(() -> new RuntimeException("Pessoa não encontrada para usuário"));
  }

  public PessoaDTO verPessoa(Long id){
    return pessoaRepository.findById(id)
      .map(p -> new PessoaDTO(p))
      .orElseThrow(() -> new RuntimeException("Erro ao buscar pessoa"));
  }

  public PessoaDTO cadastrarPessoa(PessoaDTO pessoaDTO){
    PessoaModel pessoa = new PessoaModel();
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

  // Atualiza informações pessoais a partir do usuarioId (FK)
  public InfoPessoaisDTO atualizarInfoPessoais(Long usuarioId, InfoPessoaisDTO infoPessoaisDTO) throws Exception {
    PessoaModel pessoa = pessoaRepository.findByUsuarioId(usuarioId)
          .orElseThrow(() -> new Exception("Pessoa não encontrada para o usuário informado"));

  Optional<InfoPessoaisModel> infoExistente = infoPessoaisRepository.findByPessoaId(pessoa.getId());
    InfoPessoaisModel model;
    if (infoExistente.isPresent()) {

      model = infoExistente.get();
      model.setDuracaoSono(infoPessoaisDTO.getDuracaoSono());
      model.setPressaoArterial(infoPessoaisDTO.getPressaoArterial());
      model.setFrequenciaCardiaca(infoPessoaisDTO.getFrequenciaCardiaca());
      model.setNivelAtividadeFisica(infoPessoaisDTO.getNivelAtividadeFisica());
      model.setNivelEstresse(infoPessoaisDTO.getNivelEstresse());
      model.setDisturbio(infoPessoaisDTO.getDisturbio());
    } else {
      // Cria novo se não existir
      model = new InfoPessoaisModel(infoPessoaisDTO);
      model.setPessoa(pessoa);
    }

    InfoPessoaisModel salvo = infoPessoaisRepository.save(model);
    return new InfoPessoaisDTO(salvo);
  }

  public InfoPessoaisDTO verInfoPessoais(Long pessoaId) throws Exception {
    InfoPessoaisModel info = infoPessoaisRepository.findByPessoaId(pessoaId)
      .orElseThrow(() -> new Exception("Informações pessoais não encontradas"));
    return new InfoPessoaisDTO(info);
  }
}
