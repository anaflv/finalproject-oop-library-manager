package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author anaflv 2015 2014
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("***    BIBLIOTECA       **\n");
        

        Livro l1 = new Livro("A convenção dos algorismos", "Coutinho, Lázaro", 2009);
        Livro l2 = new Livro("A evolução da física", "Einstein, Albert", 2008);
        Livro l3 = new Livro("A estrutura da matéria", "Guinier, André", 1996);
        Livro l4 = new Livro("A history of chemistry", "Bensaude-Vicent, Bernadette", 1949);
        Livro l5 = new Livro("Cinética química básica y mecanismos de reacción", "AVERY, H.E.", 2002);
        livros.add(l1);
        livros.add(l2);
        livros.add(l3);
        livros.add(l4);
        livros.add(l5);

        Aluno a1 = new Aluno(11074512);
        alunos.add(a1);
        a1.emprestarLivro(livros.get(4));
        a1.emprestarLivro(livros.get(1));
        Aluno a2 = new Aluno(11404611);
        alunos.add(a2);
        a2.emprestarLivro(livros.get(3));
        Aluno a3 = new Aluno(10784415);
        alunos.add(a3);

        Metodos.MensagemInicial();
        System.out.println("Digite o número correspondente ao seu pedido: ");

        
        int xx = 1;
        while (xx != 0) {
            Metodos.imprimirOpcoes();
            xx = scanner.nextInt();
            System.out.println("\n_____________________\n");
            switch (xx) {
                case 0:
                    break;
                case 1:
                    System.out.println("* NOVO ALUNO *");
                    System.out.println("Digite o RA do aluno");
                    int RA = scanner.nextInt();
                    Aluno ax = new Aluno(RA);
                    alunos.add(ax);
                    break;
                case 2:
                    System.out.println("**     LIVROS     ***\n");
                    for (Livro l : livros) {
                        l.imprimirInfos();
                    }
                    break;
                case 3:
                    System.out.println("DETALHES DE UM LIVRO\n");
                    System.out.println("Digite o numero do livro, ou 0 para parar");
                    System.out.print("Livro: ");
                    int lv = scanner.nextInt();
                    if (lv == 0) {
                        break;
                    } else {
                        livros.get(lv - 1).imprimirDetalhes();
                    }
                    break;

                case 4:
                    Metodos.mostrarAlunos(alunos);
                    break;
                case 5:
                    Metodos.Devolver(alunos, livros);

                    break;
                case 6:
                    Metodos.Emprestar(alunos, livros);
                    break;

                default:
                    System.out.println("Numero invalido!");
                    break;
            }

        }

    }

}
