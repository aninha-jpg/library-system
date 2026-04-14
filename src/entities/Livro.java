package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Livro {
    private String titulo;
    private String genero;
    private String autor;
    private final Integer idLivro;
    private Date anoPublicacao;
    private boolean  emprestado;
    private Queue<Usuario> fila = new LinkedList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    public Livro(String titulo, String genero, String autor, Date anoPublicacao, boolean emprestado, Integer idLivro){
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.emprestado = emprestado;
        this.idLivro = idLivro;
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

    public char isEmprestado() {
        return emprestado;
    }


    public void setEmprestado(char emprestado) {
        this.emprestado = emprestado;
    }


    public int getIdLivro() {
        return idLivro;
    }

    public void inserirNaFila(Usuario usuario){
        fila.add(usuario);
    }

    public void removerFila(Usuario usuario){
        fila.remove(usuario);
    }

    public void mostrarFilaEspera(){
        if(fila.isEmpty()){
        System.out.println("Fila vazia");
    } else {
        for(Usuario c: fila){
            System.out.println("Aguardando a vez: " + c.getNome());
        }
    }
    }

    public String toString(){
        return "Título: " + titulo + " Gênero: " + genero + " Autor: " + autor + " Ano de Publicação: " + sdf.format(anoPublicacao);
    }


}
