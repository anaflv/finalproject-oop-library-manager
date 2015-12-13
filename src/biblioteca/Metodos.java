package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anaflv 2015 2014
 */
public class Metodos {

    static void imprimirOpcoes() {

        System.out.println("_____________________\n");
        System.out.println("0 - Parar execução"
                + "\n1 - Cadastrar novo aluno"
                + "\n2 - Mostrar livros da biblioteca"
                + "\n3 - Mostrar detalhes de um livro"
                + "\n4 - Mostrar alunos"
                + "\n5 - Devolver livro"
                + "\n6 - Emprestar livro");

        System.out.print("\nSeu numero: ");

    }

    public static void mostrarAlunos(ArrayList<Aluno> alunos) {

        System.out.println("ALUNOS\n");
        for (Aluno a : alunos) {
            a.imprimirInfos();
        }
    }

    public static void Emprestar(ArrayList<Aluno> alunos, ArrayList<Livro> livros) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("EMPRESTAR LIVRO\n");
        System.out.println("Digite o RA do aluno:");
        System.out.print("RA: ");
        int r = scanner.nextInt();
        Aluno al = null;
        boolean existe = false;
        for (Aluno a : alunos) {
            if (a.RA == r) {
                al = a;
                existe = true;
                break;
            }
        }
        System.out.println("Digite o numero do livro:");
        System.out.print("Numero: ");
        int j = scanner.nextInt();
        if (j <= livros.size()) {
            Livro ll = livros.get(j-1);
            al.emprestarLivro(ll);
            System.out.println("Livro " + ll.nome + " emprestado para " + al.RA + "!");
        } else if (al == null || j > livros.size()) {
            System.out.println("Número do livro ou RA não encontrado!");
        }

    }

    public static void Devolver(ArrayList<Aluno> alunos, ArrayList<Livro> livros) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DEVOLVER LIVRO\n");
        System.out.println("Digite o numero do livro");
        System.out.print("Numero: ");
        int l = scanner.nextInt();
        System.out.println();
        livros.get(l - 1).imprimirDetalhes();
        System.out.println("\nDigite RA do aluno que vai devolver o livro");
        System.out.print("RA: ");
        int rra = scanner.nextInt();
        boolean achou = false;
        for (Aluno a : alunos) {
            if (a.RA == rra) {
                for (Copia c : livros.get(l - 1).copias) {
                    if (c.aluno == a) {
                        achou = true;
                        c.livroDevolvido(a);
                        System.out.println("Livro " + c.livro.nome + " devolvido "
                                + "pelo aluno " + rra);

                        break;
                    }
                }
                break;
            }
        }
        if (achou == false) {
            System.out.println("Livro ou RA não encontrado!");
        }
    }
    
    public static void MensagemInicial(){
        
        System.out.println("Seja bem-vindo ao programa da Biblioteca! " + 
                "\n\nJá existem alunos e livros cadastrados.\n");
    }
}
