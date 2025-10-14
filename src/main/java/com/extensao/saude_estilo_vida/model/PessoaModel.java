package com.extensao.saude_estilo_vida.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoas")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "nome_pessoa")
    private String nome;

    @Column(nullable = false, name = "idade_pessoa")
    private int idade;

    @Column(nullable = false, name = "peso_pessoa")
    private double peso;

    @Column(nullable = false, name = "altura_pessoa")
    private double altura;

    @Column(nullable = false, name = "sexo_pessoa")
    private String sexo;

    // Relacionamento 1:1 com Usuario
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private UsuarioModel usuario;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private InfoPessoaisModel infoPessoais;

    public PessoaModel(){}

    public PessoaModel(String nome, int idade, double peso, double altura, String sexo) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
