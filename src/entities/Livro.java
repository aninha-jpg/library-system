package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Livro {
    private String titulo;
    private String genero;
    private String autor;
    private Date anoPublicacao;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    public Livro(String titulo, String genero, String autor, Date anoPublicacao){
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getGenero() {
        return genero;
    }


    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getAutor() {
        return autor;
    }


    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getAnoPublicacao() {
        return anoPublicacao;
    }


    public void setAnoPublicacao(Date anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String toString(){
        return "Título: " + titulo + " Gênero: " + genero + " Autor: " + autor + " Ano de Publicação: " + sdf.format(anoPublicacao);
    }


}
