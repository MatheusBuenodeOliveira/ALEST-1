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
    private Palavra primeira;

    // Construtor
    public ListaOrdenadaDePalavras() {
        primeira = null;
    }

    
    // Metodos

}
    
    // Atributos
    
    // Metodos


