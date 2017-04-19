package br.com.fiap.view;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemPedidoDAO;
import br.com.fiap.dao.impl.ItemPedidoImpl;
import br.com.fiap.entity.ItemPedido;
import br.com.fiap.entity.Pedido;
import br.com.fiap.entity.Produto;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ItemPedidoDAO dao = new ItemPedidoImpl(em);
		
		Pedido pedido = new Pedido("Christian", Calendar.getInstance());
		Produto produto = new Produto("Pastel", 5);
		ItemPedido item = new ItemPedido(produto, pedido, 2);
		
		try {
			dao.insert(item);
			dao.save();
			
		}
		catch(CommitException e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Cadastrado");
			em.close();
		}
		
	}

}
