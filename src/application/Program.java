package application;
import entities.Arvore;
import entities.Livro;
import entities.Relacionamento;
import entities.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException {
        try(Scanner sc = new Scanner(System.in)){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        
        LinkedList<Livro> livros = new LinkedList<>();

        Relacionamento recomendacoes = new Relacionamento();

        Arvore arvoreBinaria = new Arvore();

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


        // livros para testar o algoritmo Dijkstra

        Livro livro11 = new Livro("Vida Encantada", "Fantasia", "Diana Wynne Jones", sdf.parse("1977"), true, 130);


        Livro livro12 = new Livro("IT a coisa", "Terror", "Stephen King", sdf.parse("1986"), true, 1);


        Livro livro13 = new Livro("Sob a Redoma", "Romance", "Stephen King", sdf.parse("2009"), false, 1200);


        Livro livro14 = new Livro("Doutor Sono", "Suspense", "Stephen King", sdf.parse("2013"), true, 12512);

        Livro livro15 = new Livro("Persuasão", "Romance", "Jane Austen", sdf.parse("1817"), true, 300);

        Livro livro16 = new Livro("Orgulho e Preconceito", "Romance", "Jane Austen", sdf.parse("1813"), true, 301);

        Livro livro17 = new Livro("Outlander: A Viajante do Tempo", "Romance", "Diana Gabaldon", sdf.parse("1991"), true, 302);

        Livro livro18 = new Livro("Outlander: A Libélula no Âmbar", "Fantasia", "Diana Gabaldon", sdf.parse("1992"), true, 303);

        cadastrarLivroNoSistema(livro1, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro2, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro3, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro4, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro5, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro6, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro7, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro8, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro9, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro10, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro11, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro12, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro13, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro14, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro15, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro16, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro17, recomendacoes, livros, arvoreBinaria);
        cadastrarLivroNoSistema(livro18, recomendacoes, livros, arvoreBinaria);


        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
        System.out.println("   Seja bem vindo!");
        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");

        System.out.println("Qual seu nome? ");
        String nome = sc.nextLine();

        Usuario usuario = new Usuario(nome);

        int escolha = 0;

        while(escolha != 7){
            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
            System.out.println(" 1. Verificar Livros. \n 2. Adicionar um Livro. \n 3. Verificar Fila de Espera. \n 4. Verificar histórico. \n 5. Devolução de Livros. \n 6. Ver Árvore de Livros \n 7. Finalizar");
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
                    
                    result = arvoreBinaria.buscarPorId(idLivroTemp);

                    if(result != null){
                        System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                        System.out.println("Esse id já existe, tente novamente!");
                    }
                
                } while (result != null);

                if(result == null){
                    Livro livro = new Livro(titulo, genero, autor, anoPublicacao, emprestado, idLivroTemp);
                    cadastrarLivroNoSistema(livro, recomendacoes, livros, arvoreBinaria);
                }

                usuario.registrar("Adicionar um Livro.");
                }
            }
                

            if(escolha == 3){

                System.out.println("Digite o id do livro desejado: ");
                int idLivroDesejado = sc.nextInt();

                Livro result = arvoreBinaria.buscarPorId(idLivroDesejado);

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

                            System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                            System.out.println("Se você gostou de: " + result.getTitulo());
                            System.out.println("Que tal dar uma chance para: \n");
                            Map<Livro, Integer> caminhos = recomendacoes.djikstraSimples(result);

                                if (caminhos.size() <= 1) {
                                    System.out.println("Ainda não temos recomendações para este livro.");
                                } else {
                                    caminhos.entrySet().stream()
                                        .filter(entry -> !entry.getKey().equals(result))
                                        .sorted(Map.Entry.comparingByValue())
                                        .forEach(entry -> {
                                        System.out.println("Distância: " + entry.getValue() + " | " + entry.getKey().getTitulo());
                                        });
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
                                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                                    System.out.println("Se você gostou de: " + result.getTitulo());
                                    System.out.println("Que tal dar uma chance para: \n");
                                    Map<Livro, Integer> caminhos = recomendacoes.djikstraSimples(result);

                                    if (caminhos.size() <= 1) {
                                        System.out.println("Ainda não temos recomendações para este livro.");
                                    } else {
                                        caminhos.entrySet().stream()
                                            .filter(entry -> !entry.getKey().equals(result))
                                            .sorted(Map.Entry.comparingByValue())
                                            .forEach(entry -> {
                                            System.out.println("Distância: " + entry.getValue() + " | " + entry.getKey().getTitulo());
                                            });
                                    }
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
                
                result = arvoreBinaria.buscarPorId(idLivroTemp);

                if(result == null){
                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("Esse id não existe, tente novamente!");
                } else {
                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("Livro devolvido com sucesso!");
                    result.setEmprestado(false);

                    System.out.println("Fila de empréstimo: ");
                    result.proximoFila();

                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("Se você gostou de: " + result.getTitulo());
                    System.out.println("Que tal dar uma chance para: \n");
                    Map<Livro, Integer> caminhos = recomendacoes.djikstraSimples(result);

                        if (caminhos.size() <= 1) {
                            System.out.println("Ainda não temos recomendações para este livro.");
                        } else {
                            caminhos.entrySet().stream()
                                .filter(entry -> !entry.getKey().equals(result))
                                .sorted(Map.Entry.comparingByValue())
                                .forEach(entry -> {
                                System.out.println("Distância: " + entry.getValue() + " | " + entry.getKey().getTitulo());
                                });
                        }
                    // notificar próximo da fila
                }
                
                usuario.registrar("Devolver Livro");

            }

            if(escolha == 6){
                while(escolha != 4){
                    System.out.println("•━─────━❪ʚĭɞ❫━─────━•");
                    System.out.println("\n 1. Visualizar Hierarquia (Em Ordem)\n 2. Buscar por Título (DFS - Profundidade\n 3. Buscar por Título (BFS - Largura)\n 4. Voltar ao Menu Principal.");
                    escolha = sc.nextInt();
                    sc.nextLine();

                    if(escolha == 1){
                        arvoreBinaria.exibirEmOrdem(arvoreBinaria.getRaiz());
                    }
                    if(escolha == 2){
                            System.out.println("Qual título quer buscar (Profundidade)?");
                            String t = sc.nextLine();
                            
                            arvoreBinaria.buscarDFS(arvoreBinaria.getRaiz(), t);
                    }
                    if(escolha == 3){
                        System.out.println("Qual título quer buscar (Largura)?");
                            String t = sc.nextLine();
                            
                            arvoreBinaria.buscarBFS(t);
                    }
                }
            }


            } // while
        } // scanner
    } // fecha main

    public static void cadastrarLivroNoSistema(Livro novoLivro, Relacionamento r1, LinkedList<Livro> lista, Arvore arvoreBinaria) {
    
        // 1. Adiciona na lista geral de livros
        lista.add(novoLivro);

        // 2. Chama o método do objeto r1 que você criou
        r1.adcLivro(novoLivro);

        arvoreBinaria.adicionar(novoLivro);

        // 3. Faz a conexão de recomendações
        r1.adcLivrocomRecomendacao(novoLivro, lista);

    }
} // fecha program
