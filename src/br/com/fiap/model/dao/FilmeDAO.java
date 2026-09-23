//Ana Paula Cunha Brum - RM571359
//Gabriella Serni Ponzetta - RM566296
//Julio Cesar Iwata de Oliveira Barros - RM573723
//Rafael Santos Dias - RM574105
//Victor Felipe Silva Alencar - RM574057

package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {

    //atributo
    private Connection con;

    //construtor com passagem de parametro
    public FilmeDAO(Connection con){
        this.con = con;
    }

    //getter
    public Connection getCon() {
        return con;
    }

    //metodo da classe
    public String inserir(Filme filme){
        String sql = "insert into ddd_filme(titulo, genero, produtora) values(?,?,?)";
        //PreparedStatement para proteger contra SQL injection

        try (PreparedStatement ps =  getCon().prepareStatement(sql)){

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            if (ps.executeUpdate() > 0){
                return "Inserido com sucesso";
            }else {

                return "Erro ao inserir";
            }

        }catch (SQLException e){
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String alterar(Filme filme){
        String sql = "update ddd_filme set titulo = ?, genero = ?, produtora = ? where codigo =?";

        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.setInt(4, filme.getCodigo());

            if (ps.executeUpdate() > 0){
                return "Alterado com sucesso";
            }else {

                return "Erro ao alterar";
            }

        }catch (SQLException e){
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public String excluir(Filme filme){
        String sql = "delete from ddd_filme where codigo = ?";
        try (PreparedStatement ps =  getCon().prepareStatement(sql)){
            ps.setInt(1, filme.getCodigo());
            if (ps.executeUpdate() > 0){
                return "Excluido com sucesso";
            }else {

                return "Erro ao excluir";
            }

        }catch (SQLException e){
            return "Erro de SQL:" + e.getMessage();
        }
    }

    public ArrayList<Filme> listarTodos() {
        String sql = "select * from ddd_filme order by codigo";
        ArrayList<Filme> listaFilme = new ArrayList<>();
        try (PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()

        ) {
            if (rs != null) { //se o resultado da query nao for nulo:
                while (rs.next()) {
                    Filme filme = new Filme();
                    filme.setCodigo(rs.getInt(1)); //preenchendo o objeto filme ((1) é a posição do meu banco)
                    filme.setTitulo(rs.getString(2));
                    filme.setGenero(rs.getString(3));
                    filme.setProdutora(rs.getString(4));
                    listaFilme.add(filme); //após a busca, jogamos o que foi preenchido no arraylist
                }
                return listaFilme; //após achar e armazenar todos os filmes com o while, retornamos o valor para o array
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro de SQL " + e.getMessage()); //retornando o erro caso não consiga instanciar o array
            return null;

        }


    }

}
