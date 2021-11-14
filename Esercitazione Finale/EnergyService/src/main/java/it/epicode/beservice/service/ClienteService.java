package it.epicode.beservice.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.beservice.model.Cliente;
import it.epicode.beservice.model.TipoCliente;
import it.epicode.beservice.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	IndirizzoService indirizzoService;
	
	public void saveCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void updateCliente2(Long id,String ragioneSociale, String partitaIva, TipoCliente tipoCliente,
			String email, String pec, String telefono, String nomeContatto, String cognomeContatto, String telefonoContatto,
			String emailContatto, String indirizzoSedeOperativa,String indirizzoSedeLegale, LocalDate dataInserimento,
			LocalDate dataUltimoContatto,Long fatturatoAnnuale) {
		Cliente clientFromDb = clienteRepository.getById(id);
		if(cognomeContatto!=null)
		clientFromDb.setCognomeContatto(cognomeContatto);
		if(dataInserimento!=null)
		clientFromDb.setDataInserimento(dataInserimento);
		if(dataUltimoContatto!=null)
		clientFromDb.setDataUltimoContatto(dataUltimoContatto);
		if(email!=null)
		clientFromDb.setEmail(email);
		if(emailContatto!=null)
		clientFromDb.setEmailContatto(emailContatto);
		if(fatturatoAnnuale!=null)
		clientFromDb.setFatturatoAnnuale(fatturatoAnnuale);
		if(indirizzoSedeLegale!=null)
		clientFromDb.setIndirizzoSedeLegale(indirizzoService.findByVia(indirizzoSedeLegale));
		if(indirizzoSedeOperativa!=null)
		clientFromDb.setIndirizzoSedeOperativa(indirizzoService.findByVia(indirizzoSedeOperativa));
		if(nomeContatto!=null)
		clientFromDb.setNomeContatto(nomeContatto);
		if(partitaIva!=null)
		clientFromDb.setPartitaIva(partitaIva);
		if(pec!=null)
		clientFromDb.setPec(pec);
		if(ragioneSociale!=null)
		clientFromDb.setRagioneSociale(ragioneSociale);
		if(telefono!=null)
		clientFromDb.setTelefono(telefono);
		if(telefonoContatto!=null)
		clientFromDb.setTelefonoContatto(telefonoContatto);
		if(tipoCliente!=null)
		clientFromDb.setTipoCliente(tipoCliente);
		clienteRepository.save(clientFromDb);
	}
	
	public void updateCliente(Long id,Cliente client) {
		Cliente clientFromDb = clienteRepository.getById(id);
		clientFromDb.setCognomeContatto(client.getCognomeContatto());
		clientFromDb.setDataInserimento(client.getDataInserimento());
		clientFromDb.setDataUltimoContatto(client.getDataUltimoContatto());
		clientFromDb.setEmail(client.getEmail());
		clientFromDb.setEmailContatto(client.getEmailContatto());
		clientFromDb.setFatturatoAnnuale(client.getFatturatoAnnuale());
		clientFromDb.setIndirizzoSedeLegale(client.getIndirizzoSedeLegale());
		clientFromDb.setIndirizzoSedeOperativa(client.getIndirizzoSedeOperativa());
		clientFromDb.setNomeContatto(client.getNomeContatto());
		clientFromDb.setPartitaIva(client.getPartitaIva());
		clientFromDb.setPec(client.getPec());
		clientFromDb.setRagioneSociale(client.getRagioneSociale());
		clientFromDb.setTelefono(client.getTelefono());
		clientFromDb.setTelefonoContatto(client.getTelefonoContatto());
		clientFromDb.setTipoCliente(client.getTipoCliente());
		clienteRepository.save(clientFromDb);
	}
	public void saveCliente2(String ragioneSociale, String partitaIva, TipoCliente tipoCliente,
			String email, String pec, String telefono, String nomeContatto, String cognomeContatto, String telefonoContatto,
			String emailContatto, String indirizzoSedeOperativa,String indirizzoSedeLegale, LocalDate sataInserimento,
			LocalDate dataUltimoContatto,Long fatturatoAnnuale) {
		clienteRepository.save(new Cliente(ragioneSociale, partitaIva, tipoCliente, email, pec, telefono, nomeContatto,
				cognomeContatto, telefonoContatto, emailContatto,indirizzoService.findByVia(indirizzoSedeOperativa),
				indirizzoService.findByVia(indirizzoSedeLegale), sataInserimento, dataUltimoContatto, fatturatoAnnuale));
		
	}

	public void deleteCliente(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Cliente getById(Long id) {
		return clienteRepository.getById(id);
	}

	public Page<Cliente> findByFatturato(Long fatturatoAnnuale,Pageable pageble) {
		return clienteRepository.findByFatturatoAnnuale(fatturatoAnnuale,pageble);
	}

	public Page<Cliente> findByDataInserimento(LocalDate dataInserimento,Pageable pageble) {
		return clienteRepository.findByDataInserimento(dataInserimento,pageble);
	}

	public Page<Cliente> findByDataContatto(LocalDate dataContatto,Pageable pageble) {
		return clienteRepository.findByDataUltimoContatto(dataContatto,pageble);
	}

	public Page<Cliente> findByPartOfName(String ragioneSociale,Pageable pageble) {
		return clienteRepository.findByRagioneSocialeContains(ragioneSociale, pageble);
	}
	
	public Page<Cliente> findAll(Pageable pageble){
		return clienteRepository.findAll(pageble);
	}
	
}
