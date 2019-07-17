package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
