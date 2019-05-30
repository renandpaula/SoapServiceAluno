package resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import domain.Aluno;
import domain.Materia;
import domain.Turma;

@Path("/materia")
public class MateriaService {
	
	@GET
    @Path("/get")
    @Produces("application/xml")
	public Materia getUserInXML() {
		
		Materia materia = new Materia();
		materia.setNome("Arquiterura de Software");
		
		Turma turma = new Turma();
		turma.setNome("AQS01");
		turma.setSala("B415");
		
		Aluno aluno1 = new Aluno();
		Aluno aluno2 = new Aluno();
		Aluno aluno3 = new Aluno();
		Aluno aluno4 = new Aluno();
		Aluno aluno5 = new Aluno();
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		aluno1.setNome("Renan de Paula");
		aluno2.setNome("Pedro Almeida");
		aluno3.setNome("Thiago Barbosa");
		aluno4.setNome("Amanda dos Santos ");
		aluno5.setNome("Jorge Luiz");
		
		alunos.add(aluno1);
		alunos.add(aluno2);
		alunos.add(aluno3);
		alunos.add(aluno4);
		alunos.add(aluno5);
		
		turma.setAlunos(alunos);
		materia.setTurma(turma);
		
		return materia;
		
	}

}
