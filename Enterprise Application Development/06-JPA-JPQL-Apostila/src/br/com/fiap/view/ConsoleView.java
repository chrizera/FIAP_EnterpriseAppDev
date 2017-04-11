package br.com.fiap.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
			System.out.println("---DESCRICAO EX LISTAR PACOTE: " + pacote.getDescricao());
		}
		
		pacotes = dao.buscarPorPreco(1000);
		
		for (Pacote pacote : pacotes) {
			System.out.println("---DESCRICAO EX BUSCA PRECO" + pacote.getDescricao() + " - R$" + pacote.getPreco() + "-" + pacote.getTransporte().getEmpresa());
		}
		ClienteDAO clienteDAO = new ClienteDAOImpl(em);
		
		List<Cliente> clientes = clienteDAO.listar();
				
		for (Cliente cliente : clientes) {
			System.out.println("---DESCRICAO LISTAR CLIENTE"+cliente.getNome());
		}
		
		TransporteDAO transporteDAO = new TransporteDAOImpl(em);
		
		Transporte transporte = transporteDAO.buscar(1);
		
		pacotes = dao.buscarPorTransporte(transporte);
		
		for (Pacote pacote : pacotes) {
			System.out.println("---EXEMPLO BUSCAR POR TRANSPORTE: "+pacote.getTransporte().getEmpresa());
		}
		
		clientes = clienteDAO.listarPorEstado("SP");
		
		for (Cliente cliente : clientes) {
			System.out.println("---EXEMPLO LISTAR POR ESTADO: "+cliente.getNome());
		}
		
		clientes = clienteDAO.buscarPorDiaReserva(15);
		
		for (Cliente cliente : clientes) {
			System.out.println("---EXEMPLO BUSCAR POR DIA DA RESERVA: "+cliente.getNome());
		}
		
		pacotes = dao.buscarPorDatas(new GregorianCalendar(2017, Calendar.JANUARY, 1), new GregorianCalendar(2017, Calendar.DECEMBER, 30));
		
		for (Pacote pacote : pacotes) {
			System.out.println("---EXEMPLO BUSCAR POR DATA: " + pacote.getDescricao());
		}
		
		clientes = clienteDAO.buscar("a", "a");
		
		for (Cliente cliente : clientes) {
			System.out.println("---EXEMPLO BUSCAR NOME CIDADE: " + cliente.getNome() + " - " + cliente.getEndereco().getCidade().getNome());
		}
		
		List<String> estados = new ArrayList<String>();
		estados.add("SP");
		estados.add("RJ");
		
		clientes = clienteDAO.buscarPorEstado(estados);
		
		for (Cliente cliente : clientes) {
			System.out.println("---EXEMPLO BUSCA POR ESTADO: " + cliente.getNome() + " - " + cliente.getEndereco().getCidade().getUf());
		}
		
		int quantidadeTotal = clienteDAO.quantidadeDeClientes();
		System.out.println("---QUANTIDADE DE CLIENTES: " + quantidadeTotal);
		
		double precoMedio = dao.precoMedio();
		System.out.println("---PRECO MEDIO DE PACOTES: " + precoMedio);
		
		int quantidadePacotesData = dao.pacotesCadastradosEntreDatas(new GregorianCalendar(2017, Calendar.JANUARY, 1), new GregorianCalendar(2017, Calendar.DECEMBER, 30));
		System.out.println("---QUANTIDADE PRECOS POR DATA"+quantidadePacotesData);
		
		Pacote pacoteComMaiorPreco = dao.pacoteMaiorPreco();
		System.out.println("---PACOTE COM MAIOR PRECO: " + pacoteComMaiorPreco.getDescricao());
		
		em.close();
	}

}