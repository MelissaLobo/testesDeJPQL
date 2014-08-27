package controller;

import model.Aluno;
import model.Curso;

import org.junit.Test;

import persistence.TestesDAO;

public class Teste {

	public static void main(String[] args) {
		new TestesDAO().listaDeAlunos();
	}

	@Test
	public void selectTableAlunoJPQL(){
		new TestesDAO().listaDeAlunos();
	}
	
	@Test
	public void selectTableCursoJPQL(){
		new TestesDAO().listaDeCursos();
	}
	
	@Test
	public void listaDeAlunoPorNome(){
		new TestesDAO().listaDeAlunoPorNome(new Aluno());
	}
	
	@Test
	public void listaComJoin() {
		new TestesDAO().listaDeAlunosECursos(new Aluno(), new Curso());
	}
	
	@Test
	public void listaDeCursosOrdenada() {
		new TestesDAO().listaDeCursosOrdenada();
	}
	
	@Test
	public void listaDeAlunosOrdenada(){
		new TestesDAO().listaDeAlunosOrdenada();
	}
	
	@Test
	public void listaComWhere(){
		new TestesDAO().listaDeCursosEAlunos(new Aluno(), new Curso());
	}
	
	@Test
	public void somaDasNotasDosAlunos(){
		new TestesDAO().somaNotaAlunos();
	}
	
	@Test
	public void idadeMinEMax(){
		new TestesDAO().calculandoIdadesMinEMax();
	}
	
	@Test
	public void calculandoRegistros(){
		new TestesDAO().calculandoTotalDeRegistros();
	}
	
}
