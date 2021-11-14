package it.epicode.beservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.beservice.model.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
	Provincia findByNomeContains(String nome);
}
