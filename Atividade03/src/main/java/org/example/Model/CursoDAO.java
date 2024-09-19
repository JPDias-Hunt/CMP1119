package org.example.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO implements ICursoDAO {
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/Curso_db";
    private final String username = "Postgres";
    private final String password = "postgres";

    @Override
    public void create(Curso curso) {
        String query = "INSERT INTO curso (nome, sigla, area) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getSigla());
            stmt.setString(3, curso.getArea().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Curso curso) {
        String query = "UPDATE curso SET nome = ?, sigla = ?, area = ? WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getSigla());
            stmt.setString(3, curso.getArea().name());
            stmt.setLong(4, curso.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM curso WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        String query = "SELECT * FROM curso";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Curso curso = new Curso(rs.getLong("codigo"),
                        rs.getString("nome"),
                        rs.getString("sigla"),
                        Curso.Area.valueOf(rs.getString("area")));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public Curso findById(Long id) {
        Curso curso = null;
        String query = "SELECT * FROM curso WHERE codigo = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                curso = new Curso(rs.getLong("codigo"),
                        rs.getString("nome"),
                        rs.getString("sigla"),
                        Curso.Area.valueOf(rs.getString("area")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public List<Curso> findByArea(Curso.Area area) {
        List<Curso> cursos = new ArrayList<>();
        String query = "SELECT * FROM curso WHERE area = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, area.name());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Curso curso = new Curso(rs.getLong("codigo"),
                        rs.getString("nome"),
                        rs.getString("sigla"),
                        Curso.Area.valueOf(rs.getString("area")));
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    @Override
    public Curso findBySigla(String sigla) {
        Curso curso = null;
        String query = "SELECT * FROM curso WHERE sigla = ?";
        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sigla);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                curso = new Curso(rs.getLong("codigo"),
                        rs.getString("nome"),
                        rs.getString("sigla"),
                        Curso.Area.valueOf(rs.getString("area")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return curso;
    }
}
