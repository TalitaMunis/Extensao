package com.extensao.saude_estilo_vida.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.extensao.saude_estilo_vida.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
  @Query("SELECT p FROM PessoaModel p WHERE p.usuario.id = :usuarioId")
  java.util.Optional<PessoaModel> findByUsuarioId(@org.springframework.data.repository.query.Param("usuarioId") Long usuarioId);
}
