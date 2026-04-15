package application;
import entities.Livro;
import entities.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        try(Scanner sc = new Scanner(System.in)){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        
        LinkedList<Livro> livros = new LinkedList<>();

        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
        System.out.println("   Seja bem vindo!");
        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");

        System.out.println("Qual seu nome? ");
        String nome = sc.nextLine();

        Usuario usuario = new Usuario(nome);

        int escolha = 0;

        while(escolha != 6){

            System.out.println(" 1. Verificar Livros. \n 2. Adicionar um Livro. \n 3. Verificar Fila de Espera .\n 4. Verificar histórico. \n 5. Devolução de Livros. \n 6. Finalizar");
            escolha = sc.nextInt();

            sc.nextLine();

            if(escolha == 1){
                System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                System.out.println("Livros Adicionados: \n");

                if(!livros.isEmpty()){
                    for(Livro l: livros){
                    System.out.print("ID: " + l.getIdLivro() + " \n");
                    System.out.print(l);
                } 
                } else {
                    System.out.println("Lista vazia! \n");
                }
                usuario.registrar("Verificar Livros.");

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
                System.out.println("Ele está emprestado (s/n)?");
                char emprestadoChar = sc.next().charAt(0);
                boolean emprestado = emprestadoChar == 's';

                Livro result;
                Integer idLivroTemp;

                do {
                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("Dê um ID a este livro: ");
                    idLivroTemp = sc.nextInt();
                    sc.nextLine();
                    Integer idLivro = idLivroTemp;
                    
                    result = livros.stream()
                    .filter(livro -> livro.getIdLivro() == idLivro)
                    .findFirst().orElse(null);

                    if(result != null){
                        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                        System.out.println("Esse id já existe, tente novamente!");
                    }
                
                } while (result != null);

                if(result == null){
                    Livro livro = new Livro(titulo, genero, autor, anoPublicacao, emprestado, idLivroTemp);
                    livros.add(livro);
                }

                usuario.registrar("Adicionar um Livro.");
                }
            }
                

            if(escolha == 3){

                System.out.println("Digite o id do livro desejado: ");
                int idLivroDesejado = sc.nextInt();

                Livro result = livros.stream()
                .filter(Livro -> Livro.getIdLivro() == idLivroDesejado)
                .findFirst().orElse(null);

                    if(result == null){
                        System.out.println("Esse id não existe. Tente novamente!");
                    } else {
                        if(result.isEmprestado() == true){
                            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                            result.mostrarFilaEspera();
                            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                            System.out.println("Este livro não está disponível no momento!");

                            System.out.println("Deseja aguardar na fila de espera? (s/n)");
                            char aguardarFila = sc.next().charAt(0);

                                if(aguardarFila == 's'){
                                    result.inserirNaFila(usuario);
                                } else {
                                    System.out.println("Voltando ao menu...");
                                }
                            

                        } else {
                            System.out.println(result);
                            System.out.println("Este livro está disponível. Deseja emprestar? (s/n)");
                            char emprestarLivro = sc.next().charAt(0);

                                if(emprestarLivro == 's'){
                                    result.setEmprestado(true);
                                    System.out.println("Você está aguardando. Assim que o Livro estiver disponível te avisaremos!");
                                    System.out.println("Voltando ao menu...");
                                } else {
                                    System.out.println("Voltando ao menu...");
                                }

                        }
                        
                    }
                    usuario.registrar("Verificar Fila de Espera");
                }

            if(escolha == 4){
                usuario.registrar("Verificar histórico");
                usuario.mostrar();
            }


            } // while
        } // scanner
    } // fecha main
} // fecha program


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