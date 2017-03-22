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
@Table(name = "TB_TIME")
@SequenceGenerator(allocationSize = 1, name = "seqTime", sequenceName = "SQ_TB_TIME")
public class Time {

	@Id
	@Column(name = "CD_TIME", nullable = false)
	@GeneratedValue(generator = "seqTime", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "NM_TIME")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DT_FUNDACAO")
	private Calendar dataFundacao;
	
	@Column(name = "NR_TITULO")
	private int numeroTitulo;
	
	@OneToMany
	private List<Jogador> jogadores;
}
