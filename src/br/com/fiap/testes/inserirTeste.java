package br.com.fiap.testes;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;

public class inserirTeste {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.abrirConexao();

        Filme filme = new Filme();

        filme.setTitulo("Senhor dos Anéis");
        filme.setGenero("Fantasia");
        filme.setProdutora("Warner");

        FilmeDAO filmeDAO = new FilmeDAO(con);
        System.out.println(filmeDAO.inserir(filme));

        ConnectionFactory.fecharConexao(con);

    }
}
