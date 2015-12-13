package biblioteca;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.Scanner;

/**
 *
 * @author anaflv 2015 2014
 */
public class Aluno {

    ArrayList<Copia> copias = new ArrayList<Copia>();
    int RA;
    String nome;

    boolean bloqueado;

    public Aluno(int RA) {

        this.RA = RA;
    }

    public void emprestarLivro(Livro l) {

        for (Copia c : l.copias) {
            if (c.aluno == null) {
                c.emprestarLivro(this);
                copias.add(c);
                //System.out.println("Livro " + l.nome + " emprestado com sucesso!");
                break;
            }
        }
    }

    public void imprimirInfos() {

        System.out.println("\tRA - " + RA);
        if (copias.size() > 0) {
            System.out.println("Está os livros:");
            for (Copia c : copias) {
                System.out.println("livro #" + c.livro.n + " - " + c.livro.nome);
            }
        } else {
            System.out.println("Não está com livros");
        }
        System.out.println();

    }

}
