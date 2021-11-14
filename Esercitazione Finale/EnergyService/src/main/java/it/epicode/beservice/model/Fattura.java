package it.epicode.beservice.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="fatture")
public class Fattura {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data;
	private Integer numero;
	private Integer anno;
	private Long importo;
	@OneToOne
	private StatoFattura stato;
	@ManyToOne
	private Cliente cliente;
	public Fattura() {}
	public Fattura(LocalDate data, Integer numero, Integer anno, Long importo, StatoFattura stato, Cliente cliente) {
		this.data = data;
		this.numero = numero;
		this.anno = anno;
		this.importo = importo;
		this.stato = stato;
		this.cliente = cliente;
	}
	


}
