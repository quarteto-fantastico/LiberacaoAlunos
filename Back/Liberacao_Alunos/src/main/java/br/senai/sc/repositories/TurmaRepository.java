package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
