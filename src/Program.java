import entities.Historico;
import entities.Livro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException{
        try(Scanner sc = new Scanner(System.in)){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        
        LinkedList<Livro> livros = new LinkedList<>();
        
        Historico historicoNavegacao = new Historico();

        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
        System.out.println("   Seja bem vindo!");
        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");

        System.out.println();

        int escolha = 0;

        while(escolha != 4){

            System.out.println(" 1. Verificar Disponibilidade. \n 2. Adicionar um Livro. \n 3. Verificar histórico. \n 4. Finalizar");
            escolha = sc.nextInt();

            sc.nextLine();

            if(escolha == 1){
                System.out.println("Livros: ");
                for(Livro l: livros){
                    System.out.println(l);
                }

                historicoNavegacao.registrar("1. Verificar Disponibilidade.");

            }

            if(escolha == 2){

            System.out.print("Quantos livros você deseja adicionar? ");
            int n = sc.nextInt();
            sc.nextLine();

            for(int i = 0; i<n; i++){

            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
            System.out.println("Qual é o título do " + (i + 1) + "o Livro? ");
            String titulo = sc.nextLine();
            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
            System.out.println("Qual é o Gênero do livro? ");
            String genero = sc.nextLine();



            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
            System.out.println("Qual é o Autor do livro? ");
            String autor = sc.nextLine();

            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
            System.out.println("Qual é o ano de publicação do livro? (YYYY) ");
            Date anoPublicacao = sdf.parse(sc.next());
            sc.nextLine();

            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
            System.out.println("Ele está disponível para empréstimo (true/false)?");
            boolean emprestado = sc.nextBoolean();

            Livro livro = new Livro(titulo, genero, autor, anoPublicacao, emprestado);

            livros.add(livro);
            historicoNavegacao.registrar("2. Adicionar um Livro.");
            
            }

            if(escolha == 3){
                historicoNavegacao.registrar("3. Verificar histórico.");
                historicoNavegacao.mostrar();
            }

            }
        }

        }
    }
}


//{"A rainha vermelha", "victoria aveyard", "fantasia", "2015"}
//{"O castelo animado", "Dianna Wyne Jones", "romance", "1986"}
//{"Vidas secas", "Graciliano ramos", "romance", "1938"}


// Implementação de fila: Vamos criar uma fila para gerenciar a lista de espera de livros. Em muitas bibliotecas, quando um livro está emprestado, outros usuários podem se inscrever para serem notificados ou receberem o livro assim que ele estiver disponível novamente. Sua tarefa é implementar uma fila que gerencie essa lista de espera de maneira eficiente e justa, usando a estrutura de dados queue do Java.
// implementar a classe cliente, para pegar emprestado os livros.
// implementar um while para o usuario navegar entre menus
// implementar uma nova classe para pilha e fila
// implementar nas filas(ex: um usuario entra na fila para determinado livro se ele já estiver emprestado/prog retorna livro já emprestado. deseja aguardar na fila?)
// pilha conforme ele navega entre os itens ela guarda o histórico
// Implementação de pilha: Paralelamente, desenvolva uma pilha para armazenar o histórico de navegação dos usuários no sistema. Cada vez que um usuário visualiza as informações de um livro, essa ação deve ser registrada. A pilha, implementada usando a estrutura stack do Java, deve permitir que o usuário veja quais livros ele consultou recentemente, com o livro mais recentemente visualizado no topo.