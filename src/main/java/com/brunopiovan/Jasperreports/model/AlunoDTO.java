package com.brunopiovan.Jasperreports.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlunoDTO {

    private String nome;
    private String cpf;
    private String nome_curso;
    private Integer carga_horaria;

    public AlunoDTO(String nome, String cpf, String nomeCurso, Integer cargaHoraria) {
        this.nome = nome;
        this.cpf = cpf;
        this.nome_curso = nomeCurso;
        this.carga_horaria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }
}
