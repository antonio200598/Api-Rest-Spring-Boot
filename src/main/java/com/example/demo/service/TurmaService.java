package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Turma;
import com.example.demo.model.Aluno;


@Service
public class TurmaService {
	private List<Turma> turmas = new ArrayList<Turma>();
	
	public TurmaService() {
		turmas.addAll(Arrays.asList());
	}
	
	public List<Turma> getTurmas(String disciplina) {
        if(disciplina != null){
            List<Turma> buscaTurmas = new ArrayList<Turma>();
            
            for (Turma turma : turmas) {
                if(turma.getDisciplina().toUpperCase().contains(disciplina.toUpperCase()))
                    buscaTurmas.add(turma);
            }
            return buscaTurmas;
        } else return turmas;
	} 
	
	public void addTurma(Turma newTurma) {
		turmas.add(newTurma);
	}
	
	 public void updateTurma(int codigo, Turma nova) {
	        for (Turma Turma : turmas) {
	            if(Turma.getCodigo() == codigo)
	            {
	                Turma.setDisciplina(nova.getDisciplina());
	                Turma.setSemestre(nova.getSemestre());
	                Turma.setTurmas(nova.getTurmas());
	                return;
	            }
	        }
	    }
	 
	 public void addAluno(int codigo, Aluno novo) {
	        for (Turma turma : turmas) {
	            if(turma.getCodigo() == codigo)
	            {
	                turma.getTurmas().add(novo);
	                return;
	            }
	        }
	    }

	    public Turma deleteTurma(int codigo) {
	        for (int i = 0; i < turmas.size(); i++) {
	            Turma p = turmas.get(i);
	            if(p.getCodigo() == codigo){
	                turmas.remove(p);
	                return p;
	            }
	        }
	        return null;
	    }
	    
	    public Turma getTurma(int codigo) {
	        for (Turma turma : turmas) {
	            if(turma.getCodigo() == codigo)
	                return turma;
	        }
	        return null;
	    }
}
