package br.com.fiap.testes;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Autor;
import br.com.fiap.entity.Editora;
import br.com.fiap.entity.Livro;
import br.com.fiap.enums.Sexo;

public class TestPersist {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Editora editora = new Editora(0, "12345", "Chris", "Rua da fiap");
		em.persist(editora);
		
		Livro livro = new Livro(0, "Harry Potter", 666, new GregorianCalendar(1988, 11, 22), null);
		em.persist(livro);
		
		Autor autor = new Autor(0, "JK Rowling", Sexo.FEMININO, "Rowling", new GregorianCalendar(1577, 11, 14));
		em.persist(autor);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
	}

}
