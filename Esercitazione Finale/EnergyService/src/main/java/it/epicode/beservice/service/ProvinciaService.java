package it.epicode.beservice.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Provincia;
import it.epicode.beservice.repository.ProvinciaRepository;

@Service
public class ProvinciaService {
	@Autowired
	ProvinciaRepository provinciaRepository;

	// salva una provincia
	public void saveProvincia(Provincia provincia) {
		provinciaRepository.save(provincia);
	}

	public void deleteProvincia(Long id) {
		provinciaRepository.deleteById(id);
	}
	
	public void modifyProvincia(Provincia provincia) {
		provinciaRepository.save(provincia);
	}
	public Provincia getById(Long id) {
		return provinciaRepository.getById(id);
	}
	public void updateProvincia(Long id,Provincia provincia) {
		var provincia1 = provinciaRepository.getById(id);
		provincia1.setNome(provincia.getNome());
		provincia1.setSigla(provincia.getSigla());
		provinciaRepository.save(provincia1);

	}

	// salva le provincia da file su remoto
	public void saveProvinciaFromFile() {
		final int INDICE_SIGLA = 0;
		final int INDICE_NOME = 1;
		final String FILE = "C:\\Users\\nicol\\OneDrive\\Desktop\\FileEsercitazione\\province-italiane.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			String line = null;// variabile per leggere le righe del file
			int count = 0;
			while ((line = br.readLine()) != null) {
				count++;
				if (count != 1) {
					String[] parti = line.split(";");
					String nome = parti[INDICE_NOME];
					String sigla = parti[INDICE_SIGLA];
					Provincia provincia = new Provincia(nome, sigla);
					provinciaRepository.save(provincia);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
