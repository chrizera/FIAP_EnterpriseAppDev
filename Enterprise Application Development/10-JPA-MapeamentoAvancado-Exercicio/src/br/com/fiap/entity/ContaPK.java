package br.com.fiap.entity;

import java.io.Serializable;

public class ContaPK implements Serializable {

	private int conta;
	
	private int agencia;

	public int getNumero() {
		return conta;
	}

	public void setNumero(int conta) {
		this.conta = conta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	
}
