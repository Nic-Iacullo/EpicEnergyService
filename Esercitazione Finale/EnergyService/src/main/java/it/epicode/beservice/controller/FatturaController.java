package it.epicode.beservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
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
import org.springframework.web.servlet.ModelAndView;

import it.epicode.beservice.model.Fattura;
import it.epicode.beservice.service.FatturaService;

@RestController
@RequestMapping("/fatturacontroller")
public class FatturaController {
	@Autowired
	FatturaService fatturaService;
	
	@PostMapping(value="/menufatture")
	 public ModelAndView menuCliente() {
		 return new ModelAndView("fatture");
	 }
	//Thymleaf
	@GetMapping("/saveget")
	public ResponseEntity<String> save(@RequestParam String ragioneSociale, @DateTimeFormat(iso=ISO.DATE) LocalDate data, int numero, Integer anno,
			Long importo, String stato) {
		fatturaService.saveFattura2(ragioneSociale,data,numero,anno,importo,stato);
		return new ResponseEntity<String>("Fattura salvato correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	//Thymleaf
	@GetMapping(value="/detail/{id}")
	 public ModelAndView getFattura(@PathVariable Long id) {
		 return new ModelAndView("dettagliofattura").addObject("fattura", fatturaService.getById(id));
	 }
	//Thymleaf
	@GetMapping(value = "/deletefatturatetemplate/{id}")
	public ModelAndView deleteClientTemplate(@PathVariable Long id) {
		fatturaService.deleteFattura(id);
		return new ModelAndView("responseclient","stato","ELIMINATO!");
	}
	//Thymleaf
	@GetMapping(value = "/modificafatturatemplate/{id}")
	public ModelAndView updateClienteTemplate(@PathVariable Long id,@RequestParam String ragioneSociale, @DateTimeFormat(iso=ISO.DATE) LocalDate data, Integer numero, Integer anno,
			Long importo, String stato) {
		fatturaService.updateFattura2(id, ragioneSociale, data,numero,anno,importo,stato);
		return new ModelAndView("responseclient","stato","MODIFICATO!");
	}
	
	//Thymleaf
	@GetMapping("/findbyclienttemplate")
	public ModelAndView findByClientTemplate(@RequestParam String ragioneSociale){
		List<Fattura>list=fatturaService.findByRagioneSociale(ragioneSociale);
		return new ModelAndView("listafatture").addObject("fatture",list);
	}
	//Thymeleaf
	@GetMapping("/findbystatofatturatemplate")
	public ModelAndView findByStatoTemplate(@RequestParam String stato,  @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return new ModelAndView("listafatture").addObject("fatture",fatturaService.findByStato(stato, page, size).hasContent());
	}
	//Thymeleaf
	@GetMapping("/findbydatatemplate")
	public ModelAndView findByDataTemplate(@RequestParam @DateTimeFormat(iso=ISO.DATE) LocalDate date, @RequestParam(defaultValue ="0") Integer page, @RequestParam(defaultValue ="2")Integer size){
		return new ModelAndView("listafatture").addObject("fatture",fatturaService.findByData(date, page, size));
	}
	
	//Thymeleaf
	@GetMapping("/findbyannotemplate")
	public ModelAndView findByAnnoTemplate(@RequestParam Integer anno,  @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return new ModelAndView("listafatture").addObject("fatture",fatturaService.findByAnno(anno, page, size));
	}
	
	//Thymeleaf
	@GetMapping("/findbyrangeimporttemplate")
	public ModelAndView findByImportobetweenTemplate(@RequestParam Long value1,Long value2,  @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return new ModelAndView("listafatture").addObject("fatture",fatturaService.FindByImportoBetween(value1, value2, page, size));
	}
	
	
	//----------------------------PER POST MAN-----------------------------------------------------------------//
	@PostMapping(value = "/save")
	public ResponseEntity<String> save(@RequestBody Fattura fattura) {
		fatturaService.saveFattura(fattura);
		return new ResponseEntity<String>("Fattura salvata correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/delete")
	public ResponseEntity<String> delete(@RequestParam Long id) {
		fatturaService.deleteFattura(id);
		return new ResponseEntity<String>("Fattura eliminata correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping(value = "/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id ,@RequestBody Fattura fattura) {
		fatturaService.updateFattura(id,fattura);
		return new ResponseEntity<String>("Fattura eliminata correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(value="/findbyclient")
	public Page<Fattura> findByCliente(@RequestParam Long id,@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return fatturaService.findByCliente(id, page, size);
	}
	
	@GetMapping(value="/findbystato")
	public Page<Fattura> findByStato(@RequestParam String stato,@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return fatturaService.findByStato(stato, page, size);
	}
	
	@GetMapping(value="/findbydata")
	public Page<Fattura> findByData(@RequestParam  @DateTimeFormat(iso = ISO.DATE) LocalDate date,@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return fatturaService.findByData(date, page, size);
	}
	@GetMapping(value="/findbyanno")
	public Page<Fattura> findByAnno(@RequestParam Integer anno,@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return fatturaService.findByAnno(anno, page, size);
	}
	
	@GetMapping(value="/findbyimporto")
	public Page<Fattura> FindByImporto(@RequestParam Long value1,Long value2,@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size){
		return fatturaService.FindByImportoBetween(value1, value2, page, size);
	}
}
