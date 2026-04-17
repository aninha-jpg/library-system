package entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Relacionamento {
    private HashMap<Livro, Set<Livro>> recomendacoes = new HashMap<>();

    // toda vez que eu crio um livro ele verifica se já existe alguma lista de recomendação para ele, se já existir ele ignora, se não ele cria, isso?
    public void adcLivro(Livro livro){
        recomendacoes.putIfAbsent(livro, new HashSet<>());
    }   

    // novamente verifica se já existe, se existir ele pega o conjunto de recomendacao da origem e adiciona com o destino, fazendo a relação

    // adcRelacionamento(A, B);
    // adcRelacionamento(A, C);
    // ele retorna A -> [B, C]

    public void adcRelacionamento(Livro origem, Livro destino){
        recomendacoes.putIfAbsent(origem, new HashSet<>());
        recomendacoes.get(origem).add(destino);
    }

    // ele retorna A -> [B, C] get default ele só retorna se existir algum valor -- se não existir, retorna Set<Livro> um conjunto vazio(temporário)

    public Set<Livro> recomendar(Livro livro){
        return recomendacoes.getOrDefault(livro, new HashSet<>());
    }

}
