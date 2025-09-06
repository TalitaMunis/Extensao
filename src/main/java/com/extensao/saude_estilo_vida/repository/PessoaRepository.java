package com.extensao.saude_estilo_vida.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.extensao.saude_estilo_vida.model.PessoaModel;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
  
}
