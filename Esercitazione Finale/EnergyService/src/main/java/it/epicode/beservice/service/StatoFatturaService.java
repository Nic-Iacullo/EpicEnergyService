package it.epicode.beservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.StatoFattura;
import it.epicode.beservice.repository.StatoFatturaRepository;

@Service
public class StatoFatturaService {
	@Autowired
	StatoFatturaRepository statoFatturaRepository;

	public void saveStatoFattura(StatoFattura stato) {
		statoFatturaRepository.save(stato);
	}

	public void deleteStatoFattura(Long id) {
		statoFatturaRepository.deleteById(id);
	}

	public void updateStatoFattura(Long id, StatoFattura stato) {
		var statoFromDb = statoFatturaRepository.getById(id);
		statoFromDb.setNome(stato.getNome());
		statoFatturaRepository.save(statoFromDb);
	}
	
	public StatoFattura findByNome(String nome) {
		return statoFatturaRepository.findByNome(nome);
	}
}
