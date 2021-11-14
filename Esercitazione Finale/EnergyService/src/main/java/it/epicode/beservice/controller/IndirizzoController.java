package it.epicode.beservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.beservice.model.Indirizzo;
import it.epicode.beservice.service.IndirizzoService;
@RestController
@RequestMapping("/indirizzocontroller")
public class IndirizzoController {

	@Autowired
	IndirizzoService indirizzoService;
	
	@PostMapping("/saveindirizzo")
	public ResponseEntity<String> saveIndirizzo(@RequestBody Indirizzo indirizzo) {
		indirizzoService.saveIndirizzo(indirizzo);
		return new ResponseEntity<String>("Indirizzo salvata correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/deleteindirizzo")
	public ResponseEntity<String> deleteIndirizzo(@RequestParam Long id) {
		indirizzoService.deleteIndirizzoById(id);
		return new ResponseEntity<String>("Indirizzo eliminato correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/updateindirizzo")
	public ResponseEntity<String> updateIndirizzo(@RequestBody Indirizzo indirizzo) {
		indirizzoService.updateIndirizzo(indirizzo);
		return new ResponseEntity<String>("Indirizzo modificato correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	
}
