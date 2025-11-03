package com.extensao.saude_estilo_vida.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.extensao.saude_estilo_vida.dto.InfoPessoaisDTO;
import com.extensao.saude_estilo_vida.service.InfoPessoaisService;

@RestController
@RequestMapping("/info-pessoais")
public class InfoPessoaisController {
  
  private final InfoPessoaisService infoPessoaisService;

  public InfoPessoaisController(InfoPessoaisService infoPessoaisService) {
    this.infoPessoaisService = infoPessoaisService;
  }
  
  @PostMapping("cadastrar")
  public ResponseEntity<InfoPessoaisDTO> cadastrar(@RequestBody InfoPessoaisDTO infoPessoaisDTO){
    InfoPessoaisDTO dto = infoPessoaisService.cadastrarInfoPessoais(infoPessoaisDTO);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(dto);
  }

  @GetMapping("/{pessoaId}")
  public ResponseEntity<InfoPessoaisDTO> verInfo(@PathVariable Long pessoaId){
    InfoPessoaisDTO dto = infoPessoaisService.verInfo(pessoaId);
    return ResponseEntity.ok(dto);
  }
}
