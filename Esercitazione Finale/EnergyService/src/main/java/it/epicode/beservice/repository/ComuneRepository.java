package it.epicode.beservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.beservice.model.Comune;

public interface ComuneRepository extends JpaRepository<Comune, Long> {

}
