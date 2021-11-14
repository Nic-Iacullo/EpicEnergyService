package it.epicode.beservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import it.epicode.beservice.service.IndirizzoService;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class IndirizzoServiceTest {
@Autowired
IndirizzoService indirizzoService;
	@Test
	void testGetById() {
		var indirizzo=indirizzoService.getByIdIndirizzo(3l);
		assertTrue(indirizzo!=null);
	}

}
