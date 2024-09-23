// João Pedro Oliveira Chambrone - RM 97857
// Vitor Hugo Gonçalves Rodrigues - RM 97758
// Gabriel Machado - RM 99880
// Leticia Resina - RM 98069

package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeController {

    public String inserirFilme(String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserir(filme);

        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);

        ConnectionFactory.fecharConexao(con);

        return resultado;
    }


    public String excluirFilme(int codigo) throws ClassNotFoundException, SQLException
    {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();

        Filme filme = new Filme();
        filme.setCodigo(codigo);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(filme);

        ConnectionFactory.fecharConexao(con);

        return resultado;
    }


    public String listarTodosFilmes() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();

        FilmeDAO filmeDAO = new FilmeDAO(con);
        ArrayList<Filme> catalogo = filmeDAO.listarTodos();
        String resultado = "";

        if (catalogo.size() > 0) {
            for (Filme filme : catalogo) {
                resultado += "ID: " + filme.getCodigo() +
                        "\nTítulo: " + filme.getTitulo() +
                        "\nGênero: " + filme.getGenero() +
                        "\nProdutora: " + filme.getProdutora() +
                        "\n\n";
            }
        }
        else {
            resultado = "Nenhum filme encontrado.";
        }


        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

}
