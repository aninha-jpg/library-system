package entities;

import java.util.Stack;

public class Historico {
    private Stack<String> recentes = new Stack<>();

    public Historico(){

    }

    public void registrar(String acao) {
        recentes.push(acao);
    }

    public void mostrar(){
        if(recentes.isEmpty()){
        System.out.println("Histórico vazio");

    } else {
        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
        System.out.println("Histórico de Navegação");
        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");

        for (int i = recentes.size() -1; i>=0; i++){
            System.out.println(recentes.get(i));
        }
    }
    }
}
