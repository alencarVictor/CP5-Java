//Ana Paula Cunha Brum - RM571359
//Gabriella Serni Ponzetta - RM566296
//Julio Cesar Iwata de Oliveira Barros - RM573723
//Rafael Santos Dias - RM574105
//Victor Felipe Silva Alencar - RM574057

package br.com.fiap.model.dto;

public class Filme {
    private int codigo;
    private String titulo;
    private String genero;
    private String produtora;

    //construtor vazio
    public Filme (){
    }


    //getters and setters
    public int getCodigo() {return codigo;}
    public void setCodigo(int codigo) {this.codigo = codigo;}

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getProdutora() {return produtora;}
    public void setProdutora(String produtora) {this.produtora = produtora;}

    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}
}
