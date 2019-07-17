package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.RegistroEntrada;

@Repository
public interface RegistroEntradaRepository extends JpaRepository<RegistroEntrada, Integer>{

}
