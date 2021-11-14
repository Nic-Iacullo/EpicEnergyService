package it.epicode.beservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.epicode.beservice.model.Fattura;


public interface FatturaRepository extends JpaRepository<Fattura, Long> {
	
	Page<Fattura> findByClienteId(Long id,Pageable pageable);
	
	Page<Fattura> findByStatoNome(String stato,Pageable pageable);
	
	Page<Fattura> findByData(LocalDate date,Pageable pageable);
	
	Page<Fattura> findByAnno(Integer anno,Pageable pageable);
	
	Page<Fattura> findByImportoBetween(Long importo1, Long importo2,Pageable pageble);

	List<Fattura> findByClienteRagioneSociale(String ragioneSociale);
	
}
