package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView {

	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("CLIENTE_ORACLE").createEntityManager();
		PacoteDAO dao = new PacoteDAOImpl(em);
		
		List<Pacote> pacotes = dao.listar();
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao());
		}
		
		pacotes = dao.buscarPorPreco(1000);
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getDescricao() + " - R$" + pacote.getPreco() + "-" + pacote.getTransporte().getEmpresa());
		}
		ClienteDAO clienteDAO = new ClienteDAOImpl(em);
		
		List<Cliente> clientes = clienteDAO.listar();
				
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		TransporteDAO transporteDAO = new TransporteDAOImpl(em);
		
		Transporte transporte = transporteDAO.buscar(1);
		
		pacotes = dao.buscarPorTransporte(transporte);
		
		for (Pacote pacote : pacotes) {
			System.out.println(pacote.getTransporte().getEmpresa());
		}
		
		clientes = clienteDAO.listarPorEstado("SP");
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		clientes = clienteDAO.buscarPorDiaReserva(15);
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		em.close();
	}

}
