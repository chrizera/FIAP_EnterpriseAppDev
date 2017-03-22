package br.com.fiap.view;

import br.com.fiap.dao.GrupoAmDAO;
import br.com.fiap.dao.impl.GrupoAmDAOImpl;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.GrupoAm;
import br.com.fiap.entity.Professor;
import br.com.fiap.entity.ProjetoAm;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

public class CadastraTudoTeste {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Professor professor = new Professor(0, "Prof", new GregorianCalendar(2044, 11, 23));
		Aluno aluno = new Aluno(0, "Aliu");
		GrupoAm grupo = new GrupoAm(0, "grup");
		ProjetoAm projeto = new ProjetoAm(0, "prj", new GregorianCalendar(2011, 11, 11), 6, "nada", grupo);
		GrupoAmDAO dao = new GrupoAmDAOImpl(em);
		
		
		grupo.addAluno(aluno);
		grupo.setProjeto(projeto);
		projeto.setGrupo(grupo);
		
		List<Professor> professores = new ArrayList<>();
		professores.add(professor);
		
		for (Aluno aluno2 : grupo.getAlunos()) {
			aluno2.setProfessores(professores);
		}

		try {
			dao.insert(grupo);
			dao.save();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
			System.exit(0);
		}
	}

}
