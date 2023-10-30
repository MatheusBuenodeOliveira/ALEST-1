import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



/**
 * Esta classe guarda as palavra do indice remissivo em ordem alfabetica.
 * 
 * @author Isabel
 *         H. Manssour
 */
public class ListaOrdenadaDePalavras {

    // Classe interna
    private class Palavra {
        public String s;
        public ListaDeOcorrencias listaOcorrencias;
        public Palavra next;
        

        public Palavra(String str) {
            s = str;
            next = null;
            listaOcorrencias = new ListaDeOcorrencias();
        }

        // Metodos

    }

    // Atributos
    private Palavra head;
    private Palavra tail;
    private int count;

    // Construtor
    public ListaOrdenadaDePalavras() {
        head = null;
        tail = null;
        count = 0;
    }

    
    // Metodos
    //esse eh privado pq so chama aqui dentro
    private void addpalavraord(String palavra) {
        if(count ==0){
            Palavra novaPalavra = new Palavra(palavra);
            head = novaPalavra;
            tail = novaPalavra;
            count++;
        }
        if(!containsElement(palavra)) {
        Palavra novaPalavra = new Palavra(palavra);
        if (palavra.compareTo(head.s)<0) { 
            // se for menor que o primeiro, insere no inicio
            novaPalavra.next = head;
            head = novaPalavra;
            count++;
           
        }else if (palavra.compareTo(tail.s)>0) { 
            // se for maior que o ultimo, insere no final
            tail.next = novaPalavra;
            tail = novaPalavra;
            count++;
        
        }else{
            // senao procura a posicao correta para insercao
            Palavra aux = head.next;
            Palavra ant = head;
            boolean inseriu=false;
            while (ant!=tail && !inseriu) {
                if (palavra.compareTo(aux.s)<0) {
                    inseriu = true;
                    novaPalavra.next = aux;
                    ant.next = novaPalavra;
                    count++; 
                }
                aux = aux.next;
                ant=ant.next;
                
            }
        }
    }
}

//esse eh o q armazena as ocorrencias
public void addOcorrencia(String palavra, int numPag) {
    if (palavra != null && !palavra.trim().isEmpty()) {
        if (!containsElement(palavra)) {
            addpalavraord(palavra); 
        }
        Palavra aux = head;
        while (aux != null) {
            if (aux.s.equals(palavra)) {
                aux.listaOcorrencias.add(numPag);
            }
            aux = aux.next;
        }
    }
}
    
    // atuliza print para printar as ocorrencias
    public void print() throws IOException {
        Palavra aux = head;
        BufferedWriter saida = new BufferedWriter(new FileWriter("output.txt"));
    
        while (aux != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(aux.s).append(": ");
    
            for (int i = 0; i < aux.listaOcorrencias.size(); i++) {
                sb.append(aux.listaOcorrencias.get(i));
                if (i < aux.listaOcorrencias.size() - 1) {
                    sb.append(", ");  // Separando por vírgulas
                }
            }
    
            String linha = sb.toString();
            saida.write(linha);
            saida.newLine();
            System.out.println(linha);  // printa no console
    
            aux = aux.next;
        }
    
        saida.close();
    }
    

    private boolean containsElement(String element) {
        
        if(count != 0){
            Palavra aux = head;
            while (aux != null) {
            if (aux.s.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        }
       
        
        return false;
    }    

    public void ocorrenciasPalavra(String palavra) {
        Palavra aux = head;
        boolean encontrou = false;
    
        while (aux != null) {
            if (aux.s.equals(palavra)) {
                encontrou = true;
                
                StringBuilder sb = new StringBuilder();
                sb.append(palavra).append(": ");
                
                for (int i = 0; i < aux.listaOcorrencias.size(); i++) {
                    sb.append(aux.listaOcorrencias.get(i));
                    if (i < aux.listaOcorrencias.size() - 1) {
                        sb.append(", ");
                    }
                }
                System.out.println(sb.toString());
                break;
            }
            aux = aux.next;
        }
    
        if (!encontrou) {
            System.out.println("Palavra '" + palavra + "' não encontrada.");
        }
    }
    

    public void maiorOcorrencia(){
        Palavra aux = head;
        int maior = 0;
        while(aux != null){
            if(aux.listaOcorrencias.size() > maior){
                maior = aux.listaOcorrencias.size();
            }
            aux = aux.next;
        }
        
        aux = head;
        while(aux != null){
            if(aux.listaOcorrencias.size() == maior){
                System.out.println(aux.s);
            }
            aux = aux.next;
        }
    }

}
    
    // Atributos
    
    // Metodos
