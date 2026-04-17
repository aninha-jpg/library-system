package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Livro {
    private String titulo;
    private String genero;
    private String autor;
    private final Integer idLivro;
    private Date anoPublicacao;
    private boolean emprestado;
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

    public boolean isEmprestado() {
        return emprestado;
    }


    public void setEmprestado(boolean emprestado) {
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

    public void proximoFila(){
        if(fila.isEmpty()){
            System.out.println("Fila vazia");
        } else {
            Usuario proximo = fila.poll();
            System.out.println("Livro enviado para o próximo da fila: " + proximo.getNome());
            }
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

    @Override
    public String toString(){
        return "\n Título: " + titulo + "\n Gênero: " + genero + "\n Autor: " + autor + "\n Ano de Publicação: " + sdf.format(anoPublicacao);
    }

    // fazer recomendação por título e por autor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // se for o mesmo objeto ele retorna true
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;
        return Objects.equals(titulo, livro.getTitulo()) &&
               Objects.equals(autor, livro.getAutor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
        // faz o hash e retorna um num//se for igual ele retorna o mesmo valor
    }
}

