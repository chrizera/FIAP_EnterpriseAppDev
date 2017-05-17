package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_CONSULTA")
@IdClass(ConsultaPK.class)
public class Consulta {

	@Id
	@Column(name = "DT_CONSULTA")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Id
	@Column(name = "DS_SINTOMA", nullable = false, length = 100)
	private String sintoma;
	
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Paciente paciente;
	
	@JoinColumn(name = "CD_MEDICO")
	@ManyToOne
	private Medica medico;

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getSintoma() {
		return sintoma;
	}

	public void setSintoma(String sintoma) {
		this.sintoma = sintoma;
	}
	
	
}
