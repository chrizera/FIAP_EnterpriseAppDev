package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ContaDAO;
import br.com.fiap.dao.impl.ContaDAOImpl;
import br.com.fiap.entity.Agencia;
import br.com.fiap.entity.Corrente;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ContaDAO dao = new ContaDAOImpl(em);
		Agencia agencia = new Agencia("Rua do cobobo");
		Corrente contaCorrente = new Corrente(agencia, 666, 123, 222);
		
		dao.insert(contaCorrente);
		
		try {
			dao.save();
			System.out.println("Cadastrado");
		}
		catch(CommitException e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			System.exit(0);
		}
		
	}

}
