package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;

public class TesteBusca {

	public static void main(String[] args) {
		//Instanciar o EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar o funcionario com id 1
		Funcionario funcionario = em.find(Funcionario.class, 1);
		
		System.out.println("Funcionario: " + funcionario.getNome());
		System.exit(0); //Parar a aplicacao
	}

}
