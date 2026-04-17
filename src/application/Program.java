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

        Livro livro1 = new Livro("A Rainha Vermelha", "Fantasia", "Victoria Aveyard", sdf.parse("2015"), true, 12);

        Livro livro2 = new Livro("O Castelo Animado", "Romance", "Diana Wynne Jones", sdf.parse("1986"), false, 14);

        Livro livro3 = new Livro("A Casa dos Muitos Caminhos", "Romance", "Diana Wynne Jones", sdf.parse("2008"), true, 10);

        Livro livro4 = new Livro("O Castelo no Ar", "Romance", "Diana Wynne Jones", sdf.parse("1990"), true, 9);

        Livro livro5 = new Livro("Harry Potter e a Pedra Filosofal", "Fantasia", "J.K", sdf.parse("1997"), true, 6);

        Livro livro6 = new Livro("Harry Potter e a Câmara Secreta", "Fantasia", "J.K", sdf.parse("1998"), false, 5);

        Livro livro7 = new Livro("A Perdida", "Romance", "Carina Rissi", sdf.parse("2011"), true, 172);

        Livro livro8 = new Livro("Battle Royale", "Terror", "Koushun Takami", sdf.parse("1999"), true, 200);

        Livro livro9 = new Livro("Era uma vez um coração partido", "Fantasia", "Stephanie Garber", sdf.parse("2021"), false, 150);

        Livro livro10 = new Livro("A Divina Comédia", "Epopeia", "Dante Alighieri", sdf.parse("1304"), true, 125);

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);
        livros.add(livro6);
        livros.add(livro7);
        livros.add(livro8);
        livros.add(livro9);
        livros.add(livro10);

        

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
                    System.out.print(" ID: " + l.getIdLivro() + " ");
                    System.out.print(l + " \n");
                    System.out.println();
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
                                    System.out.println("Livro emprestado com sucesso!");
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

            if(escolha == 5){
                Livro result;
                Integer idLivroTemp;

                System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                System.out.println("Qual o ID do livro que deseja devolver?");
                idLivroTemp = sc.nextInt();
                sc.nextLine();
                Integer idLivro = idLivroTemp;
                
                result = livros.stream()
                .filter(livro -> livro.getIdLivro() == idLivro)
                .findFirst().orElse(null);

                if(result == null){
                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("Esse id não existe, tente novamente!");
                } else {
                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("Livro devolvido com sucesso!");
                    result.setEmprestado(false);

                    // notificar próximo da fila
                    result.proximoFila();
                }
                
                usuario.registrar("Devolver Livro");

            }


            } // while
        } // scanner
    } // fecha main
} // fecha program
