package entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
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

    public Map<Livro, Integer> djikstraSimples(Livro origem) {
        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        distancias.put(origem, 0);
        fila.add(origem);

        while (!fila.isEmpty()) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            for (Livro vizinho : recomendacoes.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1);
                    fila.add(vizinho);
                }
            }
        }
        return distancias;
}

    public void exibirCaminhosCurtos(Livro origem) {
        Map<Livro, Integer> caminhos = djikstraSimples(origem);

        caminhos.entrySet().stream()
            .filter(entry -> !entry.getKey().equals(origem))
            .sorted(Map.Entry.comparingByValue())
            .forEach(entry -> {
                System.out.println("Distância: " + entry.getValue() + " | Livro: " + entry.getKey().getTitulo());
            });
    }

}
