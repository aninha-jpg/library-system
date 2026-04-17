package entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Relacionamento {
    private HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();

    public void adcLivro(Livro livro){
        recomendacoes.putIfAbsent(livro, new HashSet<>());
    }   


    public void adcRelacionamento(Livro origem, Livro destino){
        recomendacoes.putIfAbsent(origem, new HashSet<>());
        recomendacoes.get(origem).add(destino);
    }

    public Set<Livro> recomendar(Livro livro){
        return recomendacoes.getOrDefault(livro, new HashSet<>());
    }

}
