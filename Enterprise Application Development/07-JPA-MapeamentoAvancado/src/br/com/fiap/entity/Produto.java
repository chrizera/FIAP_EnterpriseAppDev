package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name = "seqProduto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {
	
	@Id
	@Column(name = "CD_PRODUTO")
	@GeneratedValue(generator = "seqProduto", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_PRODUTO")
	private String nome;
	
	@Column(name = "VL_PRODUTO")
	private double valor;
	
	@OneToMany(mappedBy = "produto")
	private List<ItemPedido> itemPedido;

	public Produto() {
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Produto(int codigo, String nome, double valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}
	
	public Produto(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	
}
