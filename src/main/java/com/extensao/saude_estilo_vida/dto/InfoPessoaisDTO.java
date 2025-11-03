package com.extensao.saude_estilo_vida.dto;

import java.lang.ProcessHandle.Info;
import com.extensao.saude_estilo_vida.model.InfoPessoaisModel;

public class InfoPessoaisDTO {
  private Double duracaoSono;
  private String pressaoArterial;
  private Double frequenciaCardiaca;
  private String nivelAtividadeFisica;
  private String nivelEstresse;
  private String disturbio;
  private Long pessoaId;

  public InfoPessoaisDTO() {
  }

  public InfoPessoaisDTO(InfoPessoaisModel model) {
    this.duracaoSono = model.getDuracaoSono();
    this.pressaoArterial = model.getPressaoArterial();
    this.frequenciaCardiaca = model.getFrequenciaCardiaca();
    this.nivelAtividadeFisica = model.getNivelAtividadeFisica();
    this.nivelEstresse = model.getNivelEstresse();
    this.disturbio = model.getDisturbio();
    //this.pessoaId = model.getPessoaId();
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

  public Long getPessoaId() {
    return pessoaId;
  }

  public void setPessoaId(Long pessoaId) {
    this.pessoaId = pessoaId;
  }
}
