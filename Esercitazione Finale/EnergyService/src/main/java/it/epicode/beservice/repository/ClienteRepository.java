package it.epicode.beservice.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.model.Indirizzo;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	Page<Cliente> findAll(Pageable pageble);
	
	Page<Cliente> findByFatturatoAnnuale(Long fatturatoAnnuale,Pageable pageble);
	
	Page<Cliente> findByDataInserimento(LocalDate dataInserimento,Pageable pageble);
	
	Page<Cliente> findByDataUltimoContatto(LocalDate dataUltimoContatto,Pageable pageble);
	
	Page<Cliente> findByRagioneSocialeContains(String string,Pageable pageble);

	Cliente findByRagioneSociale(String ragioneSociale);
}
