package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_AGENCIA")
@SequenceGenerator(allocationSize = 1, name = "seqAgencia", sequenceName = "SQ_T_AGENCIA")
public class Agencia {

	@Id
	@Column(name = "NR_AGENCIA", nullable = false)
	@GeneratedValue(generator = "seqAgencia", strategy = GenerationType.SEQUENCE)
	private int agencia;
	
	@Column(name = "DS_ENDERECO")
	private String endereco;

	public Agencia(String endereco) {
		super();
		this.endereco = endereco;
	}

	public Agencia() {
		super();
	}

	public int getNumero() {
		return agencia;
	}

	public void setNumero(int numero) {
		this.agencia = numero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
