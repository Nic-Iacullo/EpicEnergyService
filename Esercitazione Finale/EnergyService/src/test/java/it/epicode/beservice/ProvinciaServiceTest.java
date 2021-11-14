package it.epicode.beservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import it.epicode.beservice.service.ProvinciaService;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProvinciaServiceTest {
@Autowired
ProvinciaService provinciaService;
	@Test
	void test() {
		var provincia=provinciaService.getById(5l);
		assertTrue(provincia!=null);
	}

}
