package entities;

import java.util.Stack;

public class Usuario {

    private String nome;
    private Stack<String> historico = new Stack<>();

    public Usuario(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registrar(String acao) {
        historico.push(acao);
    }

    public void mostrar(){
        if(historico.isEmpty()){
        System.out.println("Histórico vazio");

    } else {
        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
        System.out.println("Histórico de Navegação");
        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
        for (int i = historico.size() - 1; i>= 0; i--){
            System.out.println(historico.get(i) + "\n");
        }
    }
    }
    
}
