package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> buscarPorNumeroDeDias(int dias) {
		// TODO Auto-generated method stub
		return em.createNativeQuery("select * from RESERVAS where NUMERO_DIAS = :dias", Reserva.class).setParameter("dias", dias).getResultList();
	}

}
