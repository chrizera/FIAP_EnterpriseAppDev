package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_POUPANCA")
public class Poupanca extends Conta {

	@Column(name = "VL_RENDIMENTO", nullable = false)
	private float valorRendimento;

	public Poupanca(Agencia agencia, float saldo, float valorRendimento) {
		super(agencia, saldo);
		this.valorRendimento = valorRendimento;
	}

	public Poupanca() {
		super();
	}

	public float getValorRendimento() {
		return valorRendimento;
	}

	public void setValorRendimento(float valorRendimento) {
		this.valorRendimento = valorRendimento;
	}
	
	
}
