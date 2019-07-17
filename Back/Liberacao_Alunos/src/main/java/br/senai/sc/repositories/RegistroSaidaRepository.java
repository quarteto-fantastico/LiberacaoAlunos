package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.RegistroSaida;

@Repository
public interface RegistroSaidaRepository extends JpaRepository<RegistroSaida, Integer>{

}
