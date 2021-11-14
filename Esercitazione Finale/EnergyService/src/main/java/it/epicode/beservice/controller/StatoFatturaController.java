package it.epicode.beservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.beservice.model.StatoFattura;
import it.epicode.beservice.service.StatoFatturaService;
@RestController
@RequestMapping("/statocontroller")
public class StatoFatturaController {
	@Autowired
	StatoFatturaService statoService;
	@PostMapping(value = "/save")
	public ResponseEntity<String> save(@RequestBody StatoFattura stato) {
		statoService.saveStatoFattura(stato);
		return new ResponseEntity<String>("Stato fattura salvata correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/delete")
	public ResponseEntity<String> delete(@RequestParam Long id) {
		statoService.deleteStatoFattura(id);
		return new ResponseEntity<String>("Stato fattura eliminata correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping(value = "/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id ,@RequestBody StatoFattura stato) {
		statoService.updateStatoFattura(id, stato);
		return new ResponseEntity<String>("Stato fattura eliminata correttamente", new HttpHeaders(), HttpStatus.OK);
	}
}
