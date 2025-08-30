package com.extensao.saude_estilo_vida.dto;

import com.extensao.saude_estilo_vida.model.UsuarioModel;

public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private int idade; 
    // Construtor vazio
    public UsuarioDTO() {}

    // Construtor com parâmetros
    public UsuarioDTO(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    // Construtor que recebe um UsuarioModel
    public UsuarioDTO(UsuarioModel usuario){
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.idade = usuario.getIdade();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
