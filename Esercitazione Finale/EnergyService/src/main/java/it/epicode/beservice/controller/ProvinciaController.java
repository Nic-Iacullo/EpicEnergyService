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

import it.epicode.beservice.model.Provincia;
import it.epicode.beservice.service.ProvinciaService;

@RestController
@RequestMapping("/provinciacontroller")
public class ProvinciaController {

	@Autowired
	ProvinciaService provinciaService;
	
	@PostMapping("/saveprovincia")
	public ResponseEntity<String> saveProvincia(@RequestBody Provincia provincia) {
		provinciaService.saveProvincia(provincia);
		return new ResponseEntity<String>("Provincia salvata correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/deleteprovincia")
	public ResponseEntity<String> deleteProvincia (@RequestParam Long id) {
		provinciaService.deleteProvincia(id);
		return new ResponseEntity<String>("Provincia cancellata correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/updateprovincia/{id}")
	public ResponseEntity<String> updateProvincia (@PathVariable Long id,@RequestBody Provincia provincia) {
		provinciaService.updateProvincia(id,provincia);
		return new ResponseEntity<String>("Provincia modificata correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	
}