package it.epicode.beservice;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.service.ClienteService;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ClienteServiceTest {
	@Autowired
	ClienteService clienteService;
	@Test
	void testClienteFindAll() {
		Pageable paging = PageRequest.of(0, 2);
		Page<Cliente> result=clienteService.findAll(paging);
		assertTrue(result.hasContent());
	}

}
