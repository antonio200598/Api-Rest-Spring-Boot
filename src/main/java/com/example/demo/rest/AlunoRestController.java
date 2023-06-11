package com.example.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import com.example.demo.service.TurmaService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoRestController 
{
    @Autowired
    public AlunoService alunoService;
    public TurmaService turmaService;

    @GetMapping
    List<Aluno> getAlunos(@RequestParam Map<String, String> params){
        String buscaNome = null;
        if(params.get("nome") != null){
            buscaNome = params.get("nome");
        }
        return alunoService.getAlunos(buscaNome);
    }

    @GetMapping(path = "/{id}")
    Aluno getAluno(@PathVariable String id){
        return alunoService.getAluno(Integer.parseInt(id));
    }

    @PostMapping
    void addAluno(@RequestBody Aluno Aluno){
    	alunoService.addAluno(Aluno);
    }

    @PutMapping(path = "/{id}")
    void updateAluno(@PathVariable String id, @RequestBody Aluno Aluno){
    	alunoService.updateAluno(Integer.parseInt(id), Aluno);
    }

    @DeleteMapping(path = "/{id}")
    Aluno deleteAluno(@PathVariable String id){
        return alunoService.deleteAluno(Integer.parseInt(id));
    }
}
