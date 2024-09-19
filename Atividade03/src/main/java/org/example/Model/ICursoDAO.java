package org.example.Model;

import java.util.List;

public interface ICursoDAO {
    void create(Curso curso);
    void update(Curso curso);
    void delete(Long id);
    List<Curso> findAll();
    Curso findById(Long id);
    List<Curso> findByArea(Curso.Area area);
    Curso findBySigla(String sigla);
}
