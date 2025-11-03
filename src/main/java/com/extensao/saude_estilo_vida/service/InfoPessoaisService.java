package com.extensao.saude_estilo_vida.service;

import org.springframework.stereotype.Service;
import com.extensao.saude_estilo_vida.repository.InfoPessoaisRepository;
import com.extensao.saude_estilo_vida.model.InfoPessoaisModel;
import com.extensao.saude_estilo_vida.dto.InfoPessoaisDTO;

@Service
public class InfoPessoaisService {
  private final InfoPessoaisRepository infoPessoaisRepository;
  private final PessoaService pessoaService;

  public InfoPessoaisService(InfoPessoaisRepository infoPessoaisRepository, PessoaService pessoaService) {
    this.infoPessoaisRepository = infoPessoaisRepository;
    this.pessoaService = pessoaService;
  }

  public InfoPessoaisDTO cadastrarInfoPessoais(InfoPessoaisDTO infoPessoaisDTO){
    InfoPessoaisModel dto = new InfoPessoaisModel(infoPessoaisDTO);
    InfoPessoaisModel infoPessoais = infoPessoaisRepository.save(dto);
    return new InfoPessoaisDTO(infoPessoais);
  }

  public InfoPessoaisDTO verInfo(Long pessoaId){
    InfoPessoaisModel info = infoPessoaisRepository.findByPessoaId(pessoaId)
      .orElseThrow(() -> new RuntimeException("Erro ao buscar informações pessoais"));
    return new InfoPessoaisDTO(info);
  }
}
