package com.brunopiovan.Jasperreports.controller;

import com.brunopiovan.Jasperreports.model.Aluno;
import com.brunopiovan.Jasperreports.model.dtos.AlunoDTO;
import com.brunopiovan.Jasperreports.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    
    @Autowired
    private AlunoService service;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno){
        aluno = service.create(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(aluno);
    }

    @GetMapping("/alunos-com-cursos")
    public List<AlunoDTO> getAlunosComCursos() {
        return service.getAlunosComCursos();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Integer id,@RequestBody Aluno aluno){
        aluno = service.update(id,aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
