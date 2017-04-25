package br.com.fiap.entity;

import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@IdClass(DependentePK.class)
@Entity
@Table(name = "T_DEPENDENTE")
public class Dependente {

	@Id
	@Column(name = "CD_DEPENDENTE")
	@SequenceGenerator(allocationSize = 1, name = "seqDependente", sequenceName = "SQ_T_DEPENDENTE")
	@GeneratedValue(generator = "seqDependente", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_DEPENDENTE", nullable = false)
	private String nome;
	
	@Id
	@JoinColumn(name = "CD_FUNCIONARIO")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Funcionario funcionario;

	public Dependente(int codigo, String nome, Funcionario funcionario) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.funcionario = funcionario;
	}
	
	public Dependente(String nome, Funcionario funcionario) {
		super();
		this.nome = nome;
		this.funcionario = funcionario;
	}

	public Dependente() {
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
