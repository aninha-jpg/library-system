package entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Relacionamento {
    
    private final HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();

    public void adcLivro(Livro livro){
        recomendacoes.putIfAbsent(livro, new HashSet<>());
    }   

    public void adcLivrocomRecomendacao(Livro novo, LinkedList<Livro> livros){
        for(Livro l: livros){
            if(l.getIdLivro() != novo.getIdLivro()){
                if(novo.getAutor().equals(l.getAutor()) || novo.getGenero().equals(l.getGenero())){
                    adcRelacionamento(l, novo);
                    adcRelacionamento(novo, l);
                }
            }
        }
    }

    public void adcRelacionamento(Livro origem, Livro destino){
        recomendacoes.putIfAbsent(origem, new HashSet<>());
        recomendacoes.get(origem).add(destino);
    }

    public Set<Livro> recomendar(Livro livro){
        return recomendacoes.getOrDefault(livro, new HashSet<>());
    }

}
