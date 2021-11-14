package it.epicode.beservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="comuni")
public class Comune {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ManyToOne
	private Provincia provincia;
	public Comune() {}
	public Comune(String nome, Provincia provincia) {
		super();
		this.nome = nome;
		this.provincia = provincia;
	}
	
	
}
