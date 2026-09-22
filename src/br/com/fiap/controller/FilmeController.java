package br.com.fiap.controller;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeController {

    public String inserirCarro(String titulo, String genero , String produtora) throws
            ClassNotFoundException, SQLException{
        String resultado;

        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();

        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserirFilme(filme);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero , String produtora) throws
         ClassNotFoundException, SQLException{
        String resultado;

        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();

        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);

        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterarFilme(filme);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }


    public String excluirFilme(int codigo) throws
            ClassNotFoundException, SQLException{
        String resultado;

        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();

        filme.setCodigo(codigo);

        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluirFilme(filme);

        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String listarTodosOsFilmes () throws
            ClassNotFoundException, SQLException{

        String resultado ="";

       Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        ArrayList<Filme> filmes = filmeDAO.listarTodosFilmes();

        if (filmes != null){
            for (Filme filme: filmes){
                resultado += "Codigo: "+ filme.getCodigo()+"\n";
                resultado += "Titulo: "+ filme.getTitulo()+"\n";
                resultado += "Genero: "+ filme.getGenero()+"\n";
                resultado += "Produtora: "+ filme.getProdutora()+"\n";
            }

        }else{
            resultado = "Nenhum filme econtrado";
        }
        ConnectionFactory.fecharConexao(con);
       return  resultado;
   }
}

