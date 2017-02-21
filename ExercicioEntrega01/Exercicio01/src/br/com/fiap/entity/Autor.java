package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.enums.Sexo;

@Entity
@SequenceGenerator(allocationSize = 1, name = "autor", sequenceName = "SQ_AUTOR")
public class Autor {
	
	@Id
	@GeneratedValue(generator = "autor", strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(length = 300, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Sexo sexo;
	
	@Column(length = 300, nullable = false)
	private String sobrenome;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Autor(int id, String nome, Sexo sexo, String sobrenome, Calendar dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
	}

	public Autor() {
		super();
	}
}
