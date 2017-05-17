package br.com.fiap.view;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.fiap.bo.CursoBO;

public class View {

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		try {
			Context context = new InitialContext(prop);
			CursoBO cursoBO = (CursoBO) context.lookup("ejb:/17-EJB/CursoBOImpl!br.com.fiap.bo.CursoBO");
			System.out.println(cursoBO.calcularMedia(10, 7, 10, 8));
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}

}
