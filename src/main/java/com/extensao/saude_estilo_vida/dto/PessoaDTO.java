package com.extensao.saude_estilo_vida.dto;

import com.extensao.saude_estilo_vida.model.PessoaModel;

public class PessoaDTO {
  String nome;
  int idade;
  double peso;
  double altura;
  String sexo;

  public PessoaDTO(){}

  public PessoaDTO(PessoaModel pessoa) {
      this.nome = pessoa.getNome();
      this.idade = pessoa.getIdade();
      this.peso = pessoa.getPeso();
      this.altura = pessoa.getAltura();
      this.sexo = pessoa.getSexo();
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public double getAltura() {
    return altura;
  }

  public void setAltura(double altura) {
    this.altura = altura;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
}
