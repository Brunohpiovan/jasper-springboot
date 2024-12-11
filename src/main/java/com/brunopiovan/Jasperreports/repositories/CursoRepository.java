package com.brunopiovan.Jasperreports.repositories;

import com.brunopiovan.Jasperreports.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
