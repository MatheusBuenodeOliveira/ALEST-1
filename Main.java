import java.util.ArrayList;

/**
 * Classe que inicializa a execução da aplicacao.
 * @author Isabel H. Manssour
 */


public class Main {
    public static void main(String[] args) {
    int totalpalavras  =0;
    int swcount = 0;
    int nLinha = 0;
    int nPagina = 1;
    int paginamax = 0; 
    int countindex = 0;
    
    ArrayList<String> listamaior = new ArrayList<String>();
    ListaOrdenadaDePalavras listaOrdenada = new ListaOrdenadaDePalavras();
    
    LinkedListOfString lista =  SW.stopWords(); // lista com as stopwords
    
    ArquivoTexto arquivo = new ArquivoTexto(); // objeto que gerencia o arquivo
    
    LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
    
    String l;


    arquivo.open();
    
    do  // laco que passa em cada linha do arquivo
    {
        l = arquivo.getNextLine();
        if (l==null) // acabou o arquivo?
           break;
        nLinha++; // conta mais uma linha lida do arquivo
        if (nLinha == 40) // chegou ao fim da pagina?
        {
            System.out.println("pagina:"+nPagina+" lista:"+listamaior.size());
            nLinha = 0;
            nPagina++;
            listamaior= new ArrayList<>(); //reseta a lista para a proxima pagina
        }
        //System.out.println("Linha " + nLinha + ":"+"Pagina " + nPagina + ":");
     
        linha.setLine(l); // define o texto da linha
        do // laco que passa em cada palavra de uma linha
        {
            String palavra = linha.getNextWord(); // obtem a proxima palavra da linha
            if (palavra == null)// acabou a linha
            {
                break;//ele sai da linha quando a palavra for nula
            }
            
            
            if (!lista.contains(palavra)) // verifica se a palavra esta na lista de stopwords
            {
                listaOrdenada.addOcorrencia(palavra, nPagina);
                if(!listamaior.contains(palavra)){
                    listamaior.add(palavra); 
                }
                
                // adiciona a palavra na lista ordenada se ela for uma palavra aceita!!!
            }else{
                swcount++;
            }
            
           if(listamaior.size()>countindex){//se a lista tiver um size maior que a maior lista ja vista ela armazena a pagina e o maior tamanho dnv!!!
               paginamax = nPagina;
               countindex = listamaior.size();
           }
           totalpalavras++;
           
         } while (true);
         
        
        

    } while (true);
    
    
    try {
        listaOrdenada.print();
    } catch (Exception e) {
        System.out.println("Erro de path de arquivo");
    }
    arquivo.close();        
    System.out.println("mais indexada:"+paginamax+" tamanho:"+countindex);
    System.out.println("porcentagem sw:"+((swcount*100)/totalpalavras)+"%");
    
    }
}
