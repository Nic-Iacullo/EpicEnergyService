package it.epicode.beservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import it.epicode.beservice.model.ERole;
import it.epicode.beservice.model.Role;
import it.epicode.beservice.model.StatoFattura;
import it.epicode.beservice.repository.RoleRepository;
import it.epicode.beservice.service.ComuneService;
import it.epicode.beservice.service.ProvinciaService;
import it.epicode.beservice.service.StatoFatturaService;
@Component
public class CaricamentoComuniDaFile implements CommandLineRunner {
	@Autowired
	ProvinciaService provinciaService;
	@Autowired
	ComuneService comuneService;
	@Autowired
	StatoFatturaService statoFatturaService;
	@Autowired
	RoleRepository roleRepository;
	@Override
	public void run(String... args) throws Exception {
	//provinciaService.saveProvinciaFromFile();
	//comuneService.saveComuneFromFile();
	//statoFatturaService.saveStatoFattura(new StatoFattura("PAGATO"));
	//statoFatturaService.saveStatoFattura(new StatoFattura("NON_PAGATO"));
	//roleRepository.save(new Role(ERole.ROLE_ADMIN));
	//roleRepository.save(new Role(ERole.ROLE_USER));
	}

}
