package br.com.fiap.teste;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.entity.PessoaFisica;
import br.com.fiap.entity.PessoaJuridica;
import br.com.fiap.entity.Sexo;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {

		PessoaJuridica pessoaJuridica = new PessoaJuridica("Christo", "Rua da mata", "3434343", "Agiota");
		//PessoaFisica pessoaFisica = new PessoaFisica("christian", "Rua do bobo", "1231231", Sexo.MASCULINO);
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		try {
			dao.insert(pessoaJuridica);
			//dao.insert(pessoaFisica);
			dao.save();
			System.out.println("Cadastrado");
		}
		catch(CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		System.exit(0);
	}

}
