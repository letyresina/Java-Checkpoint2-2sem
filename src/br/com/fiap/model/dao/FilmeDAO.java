package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FilmeDAO {

    private Connection con;
    private Filme filme;

    public FilmeDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    // Inserção
    public String inserir(Object object) {
        filme = (Filme) object;
        String sql = "insert into ddd_filme(titulo, genero, produtora) values(?,?,?)";
        try (PreparedStatement ps = getCon().prepareStatement(sql);) {
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            if (ps.executeUpdate() > 0) {
                return "Inserido com sucesso.";
            } else {
                return "Erro ao inserir";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    // Alteração

}
