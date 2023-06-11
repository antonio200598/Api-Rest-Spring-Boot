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

import com.example.demo.model.Turma;
import com.example.demo.model.Aluno;

import com.example.demo.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaRestController {
    @Autowired
    public TurmaService turmaService;

    @GetMapping
    List<Turma> getTurmas(@RequestParam Map<String, String> params){
        String buscaNome = null;
        if(params.get("nome") != null){
            buscaNome = params.get("nome");
        }
        return turmaService.getTurmas(buscaNome);
    }

    @GetMapping(path = "/{codigo}")
    Turma getTurma(@PathVariable String codigo){
        return turmaService.getTurma(Integer.parseInt(codigo));
    }

    @PostMapping
    void addTurma(@RequestBody Turma Turma){
    	turmaService.addTurma(Turma);
    }

    @PutMapping(path = "/{codigo}")
    void updateTurma(@PathVariable String codigo, @RequestBody Turma Turma){
    	turmaService.updateTurma(Integer.parseInt(codigo), Turma);
    }
    
    @PostMapping(path = "/{codigo}")
    void addAlunoInTurma(@PathVariable String codigo, @RequestBody Aluno aluno){
    	turmaService.addAluno(Integer.parseInt(codigo), aluno);
    }

    @DeleteMapping(path = "/{codigo}")
    Turma deleteTurma(@PathVariable String codigo){
        return turmaService.deleteTurma(Integer.parseInt(codigo));
    }
}
