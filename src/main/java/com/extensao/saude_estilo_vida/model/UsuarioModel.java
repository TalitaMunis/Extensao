package com.extensao.saude_estilo_vida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    //@Column(nullable = false)
    private String senha;

    // Relacionamento 1:1 com Pessoa
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PessoaModel pessoa;

    public UsuarioModel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public PessoaModel getPessoa() { return pessoa; }
    public void setPessoa(PessoaModel pessoa) { this.pessoa = pessoa; }
}
