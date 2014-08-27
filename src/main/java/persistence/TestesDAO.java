package persistence;

import java.util.List;

import javax.persistence.Query;

import model.Aluno;
import model.Curso;

public class TestesDAO extends DaoGenerico<Aluno, Long> {

	@SuppressWarnings("unchecked")
	public List<Aluno> listaDeAlunos() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("from Aluno ");
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Curso> listaDeCursos() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("from Curso ");
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listaDeAlunoPorNome(Aluno aluno) {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select a from Aluno a where a.nome = :nome");
			query.getParameter("Melissa");
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listaDeAlunosECursos(Aluno aluno, Curso curso) {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select a from Aluno a join a.curso");
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listaDeAlunosOrdenada() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("from Aluno order by aluno.nome");
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Curso> listaDeCursosOrdenada() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("from Curso order by curso.nome_curso");
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> listaDeCursosEAlunos(Aluno aluno, Curso curso) {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("select a from Aluno a where a.curso");
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public List<Aluno> somaNotaAlunos() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("SELECT NEW model.Aluno(a.nome,a.idade,sum(n))"+ "FROM Aluno a join curso.nota n " + "GROUP BY a.nome, a.idade");
			
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> calculandoIdadesMinEMax() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("SELECT max(a.idade), min(a.idade) FROM Aluno a");
			
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> calculandoTotalDeRegistros() {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("SELECT COUNT(a) FROM Aluno a");
			
			return query.getResultList();

		} catch (Exception e) {
			if (entityManager.isOpen()) {
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager.isOpen()) {
				entityManager.close();
			}
		}
		return null;
	}
	
}

