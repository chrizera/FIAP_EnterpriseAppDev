package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_GRUPO_AM")
@SequenceGenerator(allocationSize = 1, name = "seqGrupo", sequenceName = "SQ_TB_GRUPO_AM")
public class GrupoAm {
	
	@Id
	@Column(name = "CD_GRUPO", nullable = false)
	@GeneratedValue(generator = "seqGrupo", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_GRUPO", length = 50, nullable = false)
	private String nome;

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

	public GrupoAm(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}

	public GrupoAm() {
		super();
	}
	
}