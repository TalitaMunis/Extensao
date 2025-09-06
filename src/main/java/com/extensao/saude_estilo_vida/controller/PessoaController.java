package com.extensao.saude_estilo_vida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.extensao.saude_estilo_vida.service.PessoaService;
import com.extensao.saude_estilo_vida.dto.PessoaDTO;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
  private final PessoaService pessoaService;

  PessoaController(PessoaService pessoaService){
    this.pessoaService = pessoaService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> verPessoa(@PathVariable Long id){
    try {
      PessoaDTO pessoa = pessoaService.verPessoa(id);
      return ResponseEntity.ok(pessoa);
    } catch (RuntimeException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<?> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO){
    PessoaDTO pessoa = pessoaService.cadastrarPessoa(pessoaDTO);
    return ResponseEntity.ok(pessoa);
  }
}
