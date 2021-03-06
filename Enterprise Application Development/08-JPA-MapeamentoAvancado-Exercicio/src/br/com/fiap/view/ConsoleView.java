package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.dao.DependenteDAO;
import br.com.fiap.dao.impl.DependenteDAOImpl;
import br.com.fiap.entity.Dependente;
import br.com.fiap.entity.Funcionario;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class ConsoleView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		DependenteDAO dao = new DependenteDAOImpl(em);
		
		Funcionario funcionario = new Funcionario("Joyce", new GregorianCalendar(2017, Calendar.APRIL, 24));
		funcionario.setSalario(20000);
		funcionario.setNumeroConta(1231);
		Dependente dependente = new Dependente("Julia", funcionario);
		
		try {
			dao.insert(dependente);
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
