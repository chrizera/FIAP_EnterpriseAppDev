package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@SequenceGenerator(name = "seqPedido", allocationSize = 1, sequenceName = "SQ_TB_PEDIDO")
public class Pedido {

	@Id
	@Column(name = "CD_PEDIDO")
	@GeneratedValue(generator = "seqPedido", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_CLIENTE")
	private String nomeCliente;
	
	@Column(name = "DT_PEDIDO")
	@Temporal(TemporalType.DATE)
	private Calendar dataPedido;
	
	public Pedido() {
		super();
	}

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedido;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Calendar getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Pedido(int codigo, String nomeCliente, Calendar dataPedido) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.dataPedido = dataPedido;
	}
	
	public Pedido(String nomeCliente, Calendar dataPedido) {
		super();
		this.nomeCliente = nomeCliente;
		this.dataPedido = dataPedido;
	}
	
	
}
