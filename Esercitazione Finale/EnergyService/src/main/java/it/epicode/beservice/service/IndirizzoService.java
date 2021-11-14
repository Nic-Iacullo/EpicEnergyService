package it.epicode.beservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Indirizzo;
import it.epicode.beservice.repository.IndirizzoRepository;

@Service
public class IndirizzoService {
	@Autowired
	IndirizzoRepository indirizzoRepository;

	public void saveIndirizzo(Indirizzo indirizzo) {
		indirizzoRepository.save(indirizzo);
	}

	public void deleteIndirizzo(Long id) {
		indirizzoRepository.deleteById(id);
	}

	public Indirizzo getByIdIndirizzo(Long id) {
		return indirizzoRepository.getById(id);
	}

	public void deleteIndirizzoById(Long id) {
		indirizzoRepository.deleteById(id);
	}

	public void updateIndirizzo(Indirizzo indirizzo) {
		Indirizzo indirizzo1 = indirizzoRepository.getById(indirizzo.getId());
		indirizzo1.setCap(indirizzo.getCap());
		indirizzo1.setCivico(indirizzo.getCivico());
		indirizzo1.setComune(indirizzo.getComune());
		indirizzo1.setLocalita(indirizzo.getLocalita());
		indirizzo1.setVia(indirizzo.getVia());
		indirizzoRepository.save(indirizzo1);
		
	}

	public Indirizzo findByVia(String via) {
		return indirizzoRepository.findByVia(via);
	}
}
