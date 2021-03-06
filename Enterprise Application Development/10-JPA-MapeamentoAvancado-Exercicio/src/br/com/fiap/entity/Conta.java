package br.com.fiap.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_CONTA")
@IdClass(ContaPK.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta {

	
	@Id
	@Column(name = "NR_CONTA", nullable = false)
	@SequenceGenerator(allocationSize = 1, name = "seqConta", sequenceName = "SQ_T_CONTA")
	@GeneratedValue(generator = "seqConta", strategy = GenerationType.SEQUENCE)
	private int conta;
	
	@Id
	@JoinColumn(name = "NR_AGENCIA")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Agencia agencia;
	
	@Column(name = "VL_SALDO", nullable = false)
	private float saldo;

	public Conta(Agencia numeroAgencia, float saldo) {
		super();
		this.agencia = numeroAgencia;
		this.saldo = saldo;
	}

	public Conta() {
		super();
	}

	public Agencia getNumeroAgencia() {
		return agencia;
	}

	public void setNumeroAgencia(Agencia numeroAgencia) {
		this.agencia = numeroAgencia;
	}

	public int getNumeroConta() {
		return conta;
	}

	public void setNumeroConta(int numeroConta) {
		this.conta = numeroConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
}
