package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_FUNCIONARIO")
@SecondaryTable(name = "T_DADO_FUNCIONARIO")
@SequenceGenerator(allocationSize = 1, name = "seqFuncionario", sequenceName = "SQ_T_FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(generator = "seqFuncionario", strategy = GenerationType.SEQUENCE)
	@Column(name = "CD_FUNCIONARIO")
	private int codigo;
	
	@Column(name = "NM_FUNCIONARIO")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_ADMISSAO")
	private Calendar dataAdmissao;
	
	@Column(name = "VL_SALARIO", table = "T_DADO_FUNCIONARIO")
	private double salario;
	
	@Column(name = "NR_CONTA", table = "T_DADO_FUNCIONARIO")
	private int numeroConta;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Funcionario(int codigo, String nome, Calendar dataAdmissao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
	}
	
	public Funcionario(String nome, Calendar dataAdmissao) {
		super();
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
	}

	public Funcionario() {
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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
