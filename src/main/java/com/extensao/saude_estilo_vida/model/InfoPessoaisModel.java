package com.extensao.saude_estilo_vida.model;

import java.lang.ProcessHandle.Info;

import com.extensao.saude_estilo_vida.dto.InfoPessoaisDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_info_pessoais")
public class InfoPessoaisModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = true, name = "duracao_sono")
  private Double duracaoSono;

  @Column(nullable = true, name = "pressao_arterial")
  private String pressaoArterial;

  @Column(nullable = true, name = "frequencia_cardiaca")
  private Double frequenciaCardiaca;

  @Column(nullable = true, name = "nivel_atividade_fisica")
  private String nivelAtividadeFisica;

  @Column(nullable = true, name = "nivel_estresse")
  private String nivelEstresse;

  @Column(nullable = true, name = "disturbio")
  private String disturbio;

  @OneToOne
  @JoinColumn(name = "pessoa_id", unique = true)
  private PessoaModel pessoa;

  public InfoPessoaisModel() {
  }

  public InfoPessoaisModel(InfoPessoaisDTO dto) {

    this.duracaoSono = dto.getDuracaoSono();
    this.pressaoArterial = dto.getPressaoArterial();
    this.frequenciaCardiaca = dto.getFrequenciaCardiaca();
    this.nivelAtividadeFisica = dto.getNivelAtividadeFisica();
    this.nivelEstresse = dto.getNivelEstresse();
    this.disturbio = dto.getDisturbio();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getDuracaoSono() {
    return duracaoSono;
  }

  public void setDuracaoSono(Double duracaoSono) {
    this.duracaoSono = duracaoSono;
  }

  public String getPressaoArterial() {
    return pressaoArterial;
  }

  public void setPressaoArterial(String pressaoArterial) {
    this.pressaoArterial = pressaoArterial;
  }

  public Double getFrequenciaCardiaca() {
    return frequenciaCardiaca;
  }

  public void setFrequenciaCardiaca(Double frequenciaCardiaca) {
    this.frequenciaCardiaca = frequenciaCardiaca;
  }

  public String getNivelAtividadeFisica() {
    return nivelAtividadeFisica;
  }

  public void setNivelAtividadeFisica(String nivelAtividadeFisica) {
    this.nivelAtividadeFisica = nivelAtividadeFisica;
  }

  public String getNivelEstresse() {
    return nivelEstresse;
  }

  public void setNivelEstresse(String nivelEstresse) {
    this.nivelEstresse = nivelEstresse;
  }

  public String getDisturbio() {
    return disturbio;
  }

  public void setDisturbio(String disturbio) {
    this.disturbio = disturbio;
  }

  public PessoaModel getPessoa() {
    return pessoa;
  }

  public void setPessoa(PessoaModel pessoa) {
    this.pessoa = pessoa;
  }
  
}
