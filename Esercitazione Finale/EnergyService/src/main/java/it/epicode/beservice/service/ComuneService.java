package it.epicode.beservice.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Comune;
import it.epicode.beservice.repository.ComuneRepository;
import it.epicode.beservice.repository.ProvinciaRepository;

@Service
public class ComuneService {
	@Autowired
	ComuneRepository comuneRepository;
	@Autowired
	ProvinciaRepository provinciaRepository;

	public void saveComuneFromFile() {
		final int INDICE_PROVINCIA = 3;
		final int INDICE_NOME = 2;
		final String FILE = "C:\\Users\\nicol\\OneDrive\\Desktop\\FileEsercitazione\\comuni-italiani.csv";
		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE));
			String line = null;// variabile per leggere le righe del file
			int count = 0;
			while ((line = br.readLine()) != null) {
				count++;
				if (count != 1) {//riga di intestazione
					String[] parti = line.split(";");
					String nome = parti[INDICE_NOME];
					Comune comune = new Comune(nome, provinciaRepository.findByNomeContains(parti[INDICE_PROVINCIA]));
					comuneRepository.save(comune);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteComune(Long id) {
		comuneRepository.deleteById(id);
	}

	public void modifyComune(Comune comune) {
		comuneRepository.save(comune);
	}
	
	public Comune getById(Long id) {
		return comuneRepository.getById(id);
	}

	public Page<Comune> findAllComuni(Pageable pageable) {
		return comuneRepository.findAll(pageable);
	}

	public void saveComune(Comune comune) {
		comuneRepository.save(comune);
	}
	
	public void updateComune(Long id,Comune comune) {
		var common=comuneRepository.getById(id);
		common.setNome(comune.getNome());
		common.setProvincia(comune.getProvincia());
		comuneRepository.save(common);
	}
}
