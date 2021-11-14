package it.epicode.beservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

import it.epicode.beservice.model.Comune;
import it.epicode.beservice.service.ComuneService;

@RestController
@RequestMapping("/comunecontroller")
public class ComuneController {

	@Autowired
	ComuneService comuneService;
	
	
	@PostMapping("/savecomune")
	public ResponseEntity<String> saveComune(@RequestBody Comune comune) {
		comuneService.saveComune(comune);
		return new ResponseEntity<String>("Comune salvata correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping("/deletecomune")
	public ResponseEntity<String> deleteComune(@RequestBody Long id) {
		comuneService.deleteComune(id);
		return new ResponseEntity<String>("Comune cancellato correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/findallcomuni")
	public Page<Comune> findAllComuni(@RequestParam Integer page,Integer size ){
		Pageable pageable = PageRequest.of(page, size);
		return comuneService.findAllComuni(pageable);
	}
	
	@PostMapping("/updatecomune/{id}")
	public ResponseEntity<String> updateComune(@PathVariable Long id,  @RequestBody Comune comune) {
		comuneService.updateComune(id, comune);
		return new ResponseEntity<String>("Comune modificato correttamente", new HttpHeaders(), HttpStatus.OK);
	}
}
