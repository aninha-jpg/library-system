package entities;

import java.util.LinkedList;
import java.util.Queue;

public class Arvore {
    private Node raiz;


    public Arvore(){
        
    }

    public void removerLivro(int idLivroRemover){
        raiz = removerLivroRecursivo(raiz, idLivroRemover);
    }

    public Node removerLivroRecursivo(Node raizAtual, int idLivroRemover){
        if(raizAtual == null){
            return null;
        }

        if(idLivroRemover < raizAtual.getLivro().getIdLivro()){
            raizAtual.setEsquerdo(removerLivroRecursivo(raizAtual.getEsquerdo(), idLivroRemover));
        } else if(idLivroRemover > raizAtual.getLivro().getIdLivro()){
            raizAtual.setDireito(removerLivroRecursivo(raizAtual.getDireito(), idLivroRemover));
        }
        else {

            if(raizAtual.getDireito() == null && raizAtual.getEsquerdo() == null){
                return null;
            }

            if(raizAtual.getDireito() == null){
                return raizAtual.getDireito();
            }

            if(raizAtual.getEsquerdo() == null){
                return raizAtual.getEsquerdo();
            }

            Node sucessor = encontrarMinimo(raizAtual.getDireito());
            raizAtual.setLivro(sucessor.getLivro());
            raizAtual.setDireito(removerLivroRecursivo(raizAtual.getDireito(), sucessor.getLivro().getIdLivro()));


        }
        return raizAtual;
    }

    private Node encontrarMinimo(Node raiz){
        while(raiz.getEsquerdo() != null){
            raiz = raiz.getEsquerdo();
        }
        return raiz;
    }

    // adc livros
    public void adicionar(Livro novoLivro) {
        raiz = adicionarRecursivo(raiz, novoLivro);
    }

    private Node adicionarRecursivo(Node raizAtual, Livro novoLivro) {
        if (raizAtual == null) {
            return new Node(novoLivro);
        }

        int comparacao = novoLivro.getTitulo().compareToIgnoreCase(raizAtual.getLivro().getTitulo());

        if (comparacao < 0) {
            raizAtual.setEsquerdo(adicionarRecursivo(raizAtual.getEsquerdo(), novoLivro));
        } else if (comparacao > 0) {
            raizAtual.setDireito(adicionarRecursivo(raizAtual.getDireito(), novoLivro));
        }

        return raizAtual;
    }

    public Node getRaiz() {
        return raiz;
    }

    public boolean buscarDFS(Node raizAtual, String tituloAlvo) {
        if (raizAtual == null) return false;

        System.out.println("Visitando (Profundidade): " + raizAtual.getLivro().getTitulo());

        if (raizAtual.getLivro().getTitulo().equalsIgnoreCase(tituloAlvo)) {
            return true;
        }

        return buscarDFS(raizAtual.getEsquerdo(), tituloAlvo) || buscarDFS(raizAtual.getDireito(), tituloAlvo);
    }


    public void buscarBFS(String tituloAlvo) {
        if (raiz == null) return;

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Node node = fila.poll();

            System.out.println("Visitando (Largura): " + node.getLivro().getTitulo());

            if (node.getLivro().getTitulo().equalsIgnoreCase(tituloAlvo)) {
                System.out.println("Livro encontrado!");
                return;
            }

            if (node.getEsquerdo() != null) fila.add(node.getEsquerdo());
            if (node.getDireito() != null) fila.add(node.getDireito());
        }
        System.out.println("Livro não encontrado...");
    }

    public void exibirEmOrdem(Node raizAtual) {
    if (raizAtual != null) {

        System.out.println("\n[Nó Atual]: " + raizAtual.getLivro().getTitulo());

        if (raizAtual.getEsquerdo() != null) {
            System.out.println("   └── Esq: " + raizAtual.getEsquerdo().getLivro().getTitulo());
        } else {
            System.out.println("   └── Esq: [Vazio]");
        }


        if (raizAtual.getDireito() != null) {
            System.out.println("   └── Dir: " + raizAtual.getDireito().getLivro().getTitulo());
        } else {
            System.out.println("   └── Dir: [Vazio]");
        }

        exibirEmOrdem(raizAtual.getEsquerdo());
        exibirEmOrdem(raizAtual.getDireito());
    }
}
}


    