package entities;

public class Node {
    private Livro livro;
    private Node esquerdo;
    private Node direito;

    public Node(Livro livro) {
        this.livro = livro;
        this.esquerdo = null;
        this.direito = null;
    }

}