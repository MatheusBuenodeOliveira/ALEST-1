import java.io.IOException;

/**
 * Classe que inicializa a execução da aplicacao.
 * @author Isabel H. Manssour
 */


public class Main {
    public static void main(String[] args) throws IOException {
       
        do{
            
        try {
          new Aplicacao().executa();
           
        }catch (Exception e){
                     System.out.println("Arquivo não encontrado!");  
        }
        
        }while (true);
            
        
    }   
}
