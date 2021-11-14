package it.epicode.beservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.beservice.model.Indirizzo;

public interface IndirizzoRepository extends JpaRepository<Indirizzo, Long> {

	Indirizzo findByVia(String via);
}
