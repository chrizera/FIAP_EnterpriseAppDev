package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_CORRENTE")
public class Corrente extends Conta {
	
	@Column(name = "VL_TARIFA", nullable = false)
	private float valorTarifa;
	
	@Column(name = "VL_CHEQUE_ESPECIAL")
	private float valorChequeEspecial;

	public Corrente(Agencia agencia, float saldo, float valorTarifa, float valorChequeEspecial) {
		super(agencia, saldo);
		this.valorTarifa = valorTarifa;
		this.valorChequeEspecial = valorChequeEspecial;
	}

	public Corrente() {
		super();
	}

	public float getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(float valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	public float getValorChequeEspecial() {
		return valorChequeEspecial;
	}

	public void setValorChequeEspecial(float valorChequeEspecial) {
		this.valorChequeEspecial = valorChequeEspecial;
	}
	
	
}
