package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PACIENTE")
@SequenceGenerator(allocationSize = 1, name = "seqPaciente", sequenceName = "SQ_T_PACIENTE")
public class Paciente {

	@Id
	@Column(name = "CD_PACIENTE")
	@GeneratedValue(generator = "seqPaciente", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_PACIENTE", nullable = false, length = 100)
	private String nome;
	
	@JoinColumn(name = "CD_PACIENTE")
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;

	public Paciente(String nome) {
		super();
		this.nome = nome;
	}

	public Paciente() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
