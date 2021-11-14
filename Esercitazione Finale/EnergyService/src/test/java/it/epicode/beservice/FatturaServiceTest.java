package it.epicode.beservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.domain.Page;

import it.epicode.beservice.model.Fattura;
import it.epicode.beservice.service.FatturaService;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FatturaServiceTest {
@Autowired
FatturaService fatturaService;
	@Test
	void testFindByAnno() {
		Page<Fattura> result=fatturaService.findByAnno(2021, 0, 2);
		assertTrue(result.hasContent());
	}

}
