package com.extensao.saude_estilo_vida.repository;

import com.extensao.saude_estilo_vida.model.InfoPessoaisModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface InfoPessoaisRepository extends JpaRepository<InfoPessoaisModel, Long> {
  @Query("SELECT i FROM InfoPessoaisModel i WHERE i.pessoa.id = :pessoaId")
  Optional<InfoPessoaisModel> findByPessoaId(@Param("pessoaId") Long pessoaId);
}
