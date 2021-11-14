package it.epicode.beservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import it.epicode.beservice.service.StatoFatturaService;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StatoFatturaServiceTest {
@Autowired
StatoFatturaService statoService;
	@Test
	void testFindByNome() {
		var stato=statoService.findByNome("PAGATO");
		assertTrue(stato!=null);
	}

}
