package br.senai.sp.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.sp.api.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
