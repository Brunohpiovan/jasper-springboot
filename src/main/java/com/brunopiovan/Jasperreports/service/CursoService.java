package com.brunopiovan.Jasperreports.service;

import com.brunopiovan.Jasperreports.model.Curso;
import com.brunopiovan.Jasperreports.repositories.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;
    public List<Curso> findAll() {
        return repository.findAll();
    }

    public Curso findById(Integer id) {
        Optional<Curso> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Curso create(Curso curso) {
        return repository.save(curso);
    }

    public Curso update(Integer id,Curso obj){
        try {
            Curso entity = findById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private void updateData(Curso entity, Curso obj) {
        entity.setNomeCurso(obj.getNomeCurso());
        entity.setCargaHoraria(obj.getCargaHoraria());
    }

    public void delete(Integer id) {
        if(!repository.existsById(id)){
            throw new RuntimeException();
        }
        repository.deleteById(id);
    }
}
