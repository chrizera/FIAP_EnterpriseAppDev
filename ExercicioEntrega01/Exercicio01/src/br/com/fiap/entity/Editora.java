package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "editora", sequenceName = "SQ_EDITORA", allocationSize = 1)
public class Editora {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "editora")
	private int id;
	
	@Column(length = 100, nullable = false)
	private String cnpj;
	
	@Column(length = 300, nullable = false)
	private String nome;
	
	@Column(length = 400, nullable = true)
	private String endereco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Editora(int id, String cnpj, String nome, String endereco) {
		super();
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
	}
	public Editora() {
		super();
	}
	
	
}