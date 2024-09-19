package org.example;

import org.example.Model.Curso;

public class Aluno {
    private Long matricula;   // Matrícula (auto-incremento)
    private String nome;      // Nome do aluno
    private String sexo;      // Sexo do aluno
    private Curso curso;      // Curso do aluno (referência à classe Curso)

    // Construtor
    public Aluno (Long matricula, String nome, String sexo, Curso curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.sexo = sexo;
        this.curso = curso;
    }

    // Getters e Setters
    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", curso='" + curso.getSigla() + '\'' +
                '}';
    }
}
