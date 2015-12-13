

package biblioteca;

/**
 *
 * @author anaflv  2015 2014
 */
public class Copia  {

    //Refere-se à cópia do livro
    
    Livro livro;
    static int count = 0;
    Aluno aluno;
    boolean disp = true;
    int n;
    
    public Copia(Livro livro){
        this.livro = livro;
        n = ++count;
    }
    
    public void emprestarLivro(Aluno a){
        
        this.aluno = a;
        disp = false;
    }
    
    public void livroDevolvido(Aluno a){
        this.aluno.copias.remove(this);
        this.aluno = null;
        disp = true;
       
    }

}
