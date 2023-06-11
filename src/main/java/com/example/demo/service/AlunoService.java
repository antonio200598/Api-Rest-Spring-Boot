package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Aluno;

@Service
public class AlunoService {
	 	
		private List<Aluno> alunos = new ArrayList<Aluno>();
		public AlunoService() {
			alunos.addAll(Arrays.asList(new Aluno(1, "Andre", "andre@gmail.com")));
		}
		
		public List<Aluno> getAlunos(String nome) {
	        if(nome != null){
	            List<Aluno> buscaAlunos = new ArrayList<Aluno>();
	            
	            for (Aluno aluno : alunos) {
	                if(aluno.getNome().toUpperCase().contains(nome.toUpperCase()))
	                    buscaAlunos.add(aluno);
	            }
	            return buscaAlunos;
	        } else return alunos;
		} 
		
		public void addAluno( Aluno newAluno) {
			alunos.add(newAluno);
		}
		
		 public void updateAluno(int matricula, Aluno novo) {
		        for (Aluno aluno : alunos) {
		            if(aluno.getMatricula() == matricula)
		            {
		                aluno.setNome(novo.getNome());
		                aluno.setEmail(novo.getEmail());
		                return;
		            }
		        }
		    }

		    public Aluno deleteAluno(int matricula) {
		        for (int i = 0; i < alunos.size(); i++) {
		            Aluno p = alunos.get(i);
		            if(p.getMatricula() == matricula){
		                alunos.remove(p);
		                return p;
		            }
		        }
		        return null;
		    }
		    
		    public Aluno getAluno(int id) {
		        for (Aluno Aluno : alunos) {
		            if(Aluno.getMatricula() == id)
		                return Aluno;
		        }
		        return null;
		    }
		
}
