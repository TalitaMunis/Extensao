package com.extensao.saude_estilo_vida.dto;
import com.extensao.saude_estilo_vida.model.UsuarioModel;

public class UsuarioDTO {
    private Long idUsuario;
    private String email;
    private String senha;
    
    public UsuarioDTO() {}

    public UsuarioDTO(UsuarioModel usuario){
        this.idUsuario = usuario.getId();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return idUsuario;
    }

    public void setId(Long id) {
        this.idUsuario = id;
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
}
