package it.epicode.beservice.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.model.TipoCliente;
import it.epicode.beservice.service.ClienteService;

@RestController
@RequestMapping("/clientecontroller")
public class ClienteController {
	@Autowired
	ClienteService clienteService;

	// Per TEMPLATE
	@PostMapping(value = "/menuclienti")
	public ModelAndView menuCliente() {
		return new ModelAndView("clienti");
	}

	@GetMapping(value = "/detail/{id}")
	public ModelAndView getCliente(@PathVariable Long id) {
		return new ModelAndView("clientdetail").addObject("cliente", clienteService.getById(id));
	}
	//Thymeleaf
	@GetMapping(value = "/findbynametemplete", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView findByPartOfNameTemplete(@RequestParam String parte,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByPartOfName(parte, paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/orderbyragionesocialetemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView orderByRagioneSocialeTemplate(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "20") Integer size,
			@RequestParam(defaultValue = "ragioneSociale") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/orderbyfatturatotemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView orderByFatturatoTemplate(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "fatturatoAnnuale") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/orderbydatainserimentotemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView orderByDataInserimentoTemplate(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "dataInserimento") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/orderbydatacontattotemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView orderByDataContattoTemplate(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "dataUltimoContatto") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/orderbysedelegaletemplate")
	public ModelAndView orderBySedeLegaleTemplate(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "indirizzoSedeLegale.comune.provincia.sigla") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/findbyfatturatotemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView findByFatturatoTemplate(@RequestParam Long fatturatoAnnuale,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByFatturato(fatturatoAnnuale, paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/findbydatainserimentotemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView findByDataInserimentoTemplate(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByDataInserimento(date, paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/findbydataultimotemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView findByDataUltimoContattoTemplate(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate date,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByDataContatto(date, paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping(value = "/findbynametemplate", produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView findByPartOfNameTemplate(@RequestParam String parte,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByPartOfName(parte, paging);
		if (pagedResult.hasContent()) {
			return new ModelAndView("ricercaclienti").addObject("clienti", pagedResult.getContent());
		} else {
			return new ModelAndView();
		}
	}
	//Thymeleaf
	@GetMapping("/savenewclientget")
	public ModelAndView saveNewClient(@RequestParam String ragioneSociale, String partitaIva, TipoCliente tipoCliente,
			String email, String pec, String telefono, String nomeContatto, String cognomeContatto,
			String telefonoContatto, String emailContatto, String indirizzoSedeOperativa, String indirizzoSedeLegale,
			@DateTimeFormat(iso = ISO.DATE) LocalDate dataInserimento,
			@DateTimeFormat(iso = ISO.DATE) LocalDate dataUltimoContatto, Long fatturatoAnnuale) {
		clienteService.saveCliente2(ragioneSociale, partitaIva, tipoCliente, email, pec, telefono, nomeContatto,
				cognomeContatto, telefonoContatto, emailContatto, indirizzoSedeOperativa, indirizzoSedeLegale,
				dataInserimento, dataUltimoContatto, fatturatoAnnuale);
		return new ModelAndView("responsecliente", "stato", "SALVATO!");
	}
	//Thymeleaf
	@GetMapping(value = "/modificaclientetemplate/{id}")
	public ModelAndView updateClienteTemplate(@PathVariable Long id, @RequestParam String ragioneSociale,
			String partitaIva, TipoCliente tipoCliente, String email, String pec, String telefono, String nomeContatto,
			String cognomeContatto, String telefonoContatto, String emailContatto, String indirizzoSedeOperativa,
			String indirizzoSedeLegale, @DateTimeFormat(iso = ISO.DATE) LocalDate dataInserimento,
			@DateTimeFormat(iso = ISO.DATE) LocalDate dataUltimoContatto, Long fatturatoAnnuale) {
		clienteService.updateCliente2(id, ragioneSociale, partitaIva, tipoCliente, email, pec, telefono, nomeContatto,
				cognomeContatto, telefonoContatto, emailContatto, indirizzoSedeOperativa, indirizzoSedeLegale,
				dataInserimento, dataUltimoContatto, fatturatoAnnuale);
		return new ModelAndView("responsecliente", "stato", "MODIFICATO!");
	}
	//Thymeleaf
	@GetMapping(value = "/deleteclientetemplate/{id}")
	public ModelAndView deleteClientTemplate(@PathVariable Long id) {
		clienteService.deleteCliente(id);
		return new ModelAndView("responsecliente", "stato", "ELIMINATO!");
	}

	// Postman
	@GetMapping(value = "/orderbyragionesociale", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> orderByRagioneSociale(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "20") Integer size,
			@RequestParam(defaultValue = "ragioneSociale") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}

	// Postman
	@GetMapping(value = "/orderbyfatturato", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> orderByFatturato(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "fatturatoAnnuale") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}
	//Postman
	@GetMapping(value = "/orderbydatainserimento", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> orderByDataInserimento(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "dataInserimento") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}
	//Postman
	@GetMapping(value = "/orderbydatacontatto", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> orderByDataContatto(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "dataUltimoContatto") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}
	//Postman
	@GetMapping(value = "/orderbysedelegale")
	public List<Cliente> orderBySedeLegale(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size,
			@RequestParam(defaultValue = "indirizzoSedeLegale.comune.provincia.sigla") String sort) {
		Pageable paging = PageRequest.of(page, size, Sort.by(sort));
		Page<Cliente> pagedResult = clienteService.findAll(paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}
	//Postman
	@PostMapping(value = "/savecliente")
	public ResponseEntity<String> saveCliente(@RequestBody Cliente client) {
		clienteService.saveCliente(client);
		return new ResponseEntity<String>("Cliente salvato correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	//Postman
	@PostMapping(value = "/modificacliente/{id}")
	public ResponseEntity<String> updateCliente(@PathVariable Long id, @RequestBody Cliente client) {
		clienteService.updateCliente(id, client);
		return new ResponseEntity<String>("Cliente modificato correttamente", new HttpHeaders(), HttpStatus.OK);
	}
	//Postman
	@GetMapping(value = "/deletecliente")
	public ResponseEntity<String> deleteClient(@RequestParam Long id) {
		clienteService.deleteCliente(id);
		return new ResponseEntity<String>("Cliente eliminato correttamente", new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping(value = "/findbyfatturato", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findByFatturato(@RequestParam Long fatturatoAnnuale,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByFatturato(fatturatoAnnuale, paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}

	@GetMapping(value = "/findbydatainserimento", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findByDataInserimento(@RequestParam LocalDate date,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByDataInserimento(date, paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}

	@GetMapping(value = "/findbydataultimo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findByDataUltimoContatto(@RequestParam LocalDate date,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByDataContatto(date, paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}

	@GetMapping(value = "/findbyname", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findByPartOfName(@RequestParam String parte, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "2") Integer size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Cliente> pagedResult = clienteService.findByPartOfName(parte, paging);
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Cliente>();
		}
	}

}
