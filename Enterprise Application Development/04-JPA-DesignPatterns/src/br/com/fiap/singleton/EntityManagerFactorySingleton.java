package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	public static EntityManagerFactory fabrica;
	
	public EntityManagerFactorySingleton() {
		
	}
	
	public static EntityManagerFactory getInstance() {
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return fabrica;
	}
}
