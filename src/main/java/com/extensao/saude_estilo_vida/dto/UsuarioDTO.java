package com.extensao.saude_estilo_vida.dto;
import com.extensao.saude_estilo_vida.model.UsuarioModel;

public class UsuarioDTO {
    private String email;
    private String senha;
    
    public UsuarioDTO() {}

    public UsuarioDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public UsuarioDTO(UsuarioModel usuario){
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
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
