package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		
		return query.getResultList();
	}

	@Override
	public List<Cliente> listarPorEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade.uf = : est", Cliente.class);
		query.setParameter("est", estado);

		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiaReserva(int quantidade) {
		TypedQuery<Cliente> query = em.createQuery("select r.cliente from Reserva r where r.numeroDias = :num", Cliente.class);
		query.setParameter("num", quantidade);
		query.setMaxResults(50);
		return query.getResultList();
	}

}
