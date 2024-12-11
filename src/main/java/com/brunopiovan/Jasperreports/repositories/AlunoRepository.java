package com.brunopiovan.Jasperreports.repositories;

import com.brunopiovan.Jasperreports.model.Aluno;
import com.brunopiovan.Jasperreports.model.AlunoDTO;
import com.brunopiovan.Jasperreports.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query("SELECT new com.brunopiovan.Jasperreports.model.AlunoDTO(a.nome, a.cpf, c.nomeCurso, c.cargaHoraria) " +
            "FROM Aluno a " +
            "INNER JOIN a.curso c")
    List<AlunoDTO> findAlunosWithCursos();
}
