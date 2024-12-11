package com.brunopiovan.Jasperreports.service;

import com.brunopiovan.Jasperreports.model.Aluno;
import com.brunopiovan.Jasperreports.model.dtos.AlunoDTO;
import com.brunopiovan.Jasperreports.repositories.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    public Aluno findById(Integer id) {
        Optional<Aluno> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno update(Integer id,Aluno obj){
        try {
            Aluno entity = findById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private void updateData(Aluno entity, Aluno obj) {
        entity.setNome(obj.getNome());
        entity.setCpf(obj.getCpf());
        entity.setCurso(obj.getCurso());
    }

    public void delete(Integer id) {
        if(!repository.existsById(id)){
            throw new RuntimeException();
        }
        repository.deleteById(id);
    }

    public List<AlunoDTO> getAlunosComCursos() {
        return repository.findAlunosWithCursos();
    }
}
