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
        
        LinkedList<Livro> livro = new LinkedList<>();

        System.out.print("Quantos livros você deseja adicionar? ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i<n; i++){

            System.out.println("--------------------");
            System.out.println("Qual é o título do " + (i + 1) + "o Livro? ");
            String titulo = sc.nextLine();
            System.out.println("--------------------");
            System.out.println("Qual é o Gênero do livro? ");
            String genero = sc.nextLine();



            System.out.println("--------------------");
            System.out.println("Qual é o Autor do livro? ");
            String autor = sc.nextLine();

            System.out.println("--------------------");
            System.out.println("Qual é o ano de publicação do livro? (YYYY) ");
            Date anoPublicacao = sdf.parse(sc.next());
            sc.nextLine();


            Livro livros = new Livro(titulo, genero, autor, anoPublicacao);


            livro.add(livros);

            //{"A rainha vermelha", "victoria aveyard", "fantasia", "2015"}
            //{"O castelo animado", "Dianna Wyne Jones", "romance", "1986"}
            //{"Vidas secas", "Graciliano ramos", "romance", "1938"}

        }
        System.out.println("Livros: ");
        for(Livro l: livro){
            System.out.println(l);
        }

        }
    }
}


// Implementação de fila: Vamos criar uma fila para gerenciar a lista de espera de livros. Em muitas bibliotecas, quando um livro está emprestado, outros usuários podem se inscrever para serem notificados ou receberem o livro assim que ele estiver disponível novamente. Sua tarefa é implementar uma fila que gerencie essa lista de espera de maneira eficiente e justa, usando a estrutura de dados queue do Java.
// implementar um while para o usuario navegar entre menus
// implementar uma nova classe para pilha e fila
// implementar nas filas(ex: um usuario entra na fila para determinado livro se ele já estiver emprestado/prog retorna livro já emprestado. deseja aguardar na fila?)
// pilha conforme ele navega entre os itens ela guarda o histórico
// Implementação de pilha: Paralelamente, desenvolva uma pilha para armazenar o histórico de navegação dos usuários no sistema. Cada vez que um usuário visualiza as informações de um livro, essa ação deve ser registrada. A pilha, implementada usando a estrutura stack do Java, deve permitir que o usuário veja quais livros ele consultou recentemente, com o livro mais recentemente visualizado no topo.