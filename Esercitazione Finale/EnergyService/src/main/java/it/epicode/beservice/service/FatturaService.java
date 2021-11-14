package it.epicode.beservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Fattura;
import it.epicode.beservice.repository.ClienteRepository;
import it.epicode.beservice.repository.FatturaRepository;

@Service
public class FatturaService {
	@Autowired
	FatturaRepository fatturaRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	StatoFatturaService statoFatturaService;

	public Fattura getById(Long id) {
		return fatturaRepository.getById(id);
	}

	public void saveFattura(Fattura fattura) {
		fatturaRepository.save(fattura);
	}

	public void deleteFattura(Long id) {
		fatturaRepository.deleteById(id);
	}

	public void updateFattura(Long id,Fattura fattura) {
		var fattura1 = fatturaRepository.getById(id);
		fattura1.setAnno(fattura.getAnno());
		fattura1.setCliente(fattura.getCliente());
		fattura1.setData(fattura.getData());
		fattura1.setImporto(fattura.getImporto());
		fattura1.setNumero(fattura.getNumero());
		fattura1.setStato(fattura.getStato());
		fatturaRepository.save(fattura1);
	}
	public void saveFattura2(String ragioneSociale, LocalDate data, Integer numero, Integer anno,
			Long importo, String stato) {
		fatturaRepository.save(new Fattura(data,numero,anno,importo,statoFatturaService.findByNome(stato),clienteRepository.findByRagioneSociale(ragioneSociale)));
	}
	public List<Fattura> findByRagioneSociale(String ragioneSociale) {
		return fatturaRepository.findByClienteRagioneSociale(ragioneSociale);
	}
	public Page<Fattura> findByCliente(Long id,Integer page,Integer size){
		Pageable paging = PageRequest.of(page, size);
		return fatturaRepository.findByClienteId(id, paging);
	}
	public Page<Fattura> findByStato(String stato,Integer page,Integer size){
		Pageable paging = PageRequest.of(page, size);
		return fatturaRepository.findByStatoNome(stato, paging);
	}
	
	public Page<Fattura> findByData(LocalDate date,Integer page,Integer size){
		Pageable paging = PageRequest.of(page, size);
		return fatturaRepository.findByData(date, paging);
	}
	
	public Page<Fattura> findByAnno(Integer anno,Integer page,Integer size){
		Pageable paging = PageRequest.of(page, size);
		return fatturaRepository.findByAnno(anno, paging);
	}
	public Page<Fattura> FindByImportoBetween(Long value1,Long value2,Integer page,Integer size){
		Pageable paging = PageRequest.of(page, size);
		return fatturaRepository.findByImportoBetween(value1, value2, paging);
	}
	
	public void updateFattura2(Long id, String ragioneSociale, LocalDate data, Integer numero, Integer anno, Long importo,
			String stato) {
		Fattura fattura1=fatturaRepository.getById(id);
		if(ragioneSociale!=null)
			fattura1.setCliente(clienteRepository.findByRagioneSociale(ragioneSociale));
		if(data!=null)
			fattura1.setData(data);
		if(numero != 0)
			fattura1.setNumero(numero);
		if(anno!=null)
			fattura1.setAnno(anno);
		if(importo!=null)
			fattura1.setImporto(importo);
		if(stato!=null)
			fattura1.setStato(statoFatturaService.findByNome(stato));
		fatturaRepository.save(fattura1);
	}
}
