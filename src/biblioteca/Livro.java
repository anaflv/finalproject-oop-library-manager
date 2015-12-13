

package biblioteca;
import java.util.concurrent.BlockingQueue;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author anaflv  2015 2014
 */
public class Livro {
    
    //Refere-se à obra, não à copia específica do livro
    
    static int count = 0;
            
    String autor;
    String nome;
    int ano;
    int n;
    int ncopias;
    
    BlockingQueue alunosreserv;
    ArrayList<Copia> copias = new ArrayList<Copia>();
    
    
    public Livro(String nome, String autor, int ano){
       
       this.nome = nome;
       this.autor = autor;
       this.ano = ano;
       n = ++count;
       Random r = new Random();
       ncopias = r.nextInt(8) + 1;
       Copia.count = 0;
       for(int i = 0; i<ncopias; i++){
           Copia c = new Copia(this);
           copias.add(c);
       }
       
    }
    
    public void pegarLivro(){
    }
    
    public void reservarLivro(){
    }
    
    
    
    public void imprimirInfos(){
        System.out.println("Livro num: " + n + " ");
        System.out.println("Autor: " + autor);
        System.out.println("Titulo: " + nome);
        System.out.println("Ano: " + ano);
        System.out.println("Copias: " + ncopias + "\n");
        
        
    }
    
    public void imprimirDetalhes(){
        
        imprimirInfos();
        for(Copia c : copias){
            System.out.print ("Copia " + c.n + " - " );
            if(c.disp){
                System.out.print(" disponível");
            } else if (c.disp == false){
                System.out.print(" emprestado para aluno " + c.aluno.RA);
            }
            System.out.println();
            
        }
        
    }
    
   
    
    
    


}
