import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacao {
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

    public Aplicacao(){
        arquivo.open();
    
        do  // laco que passa em cada linha do arquivo
        {
            l = arquivo.getNextLine();
            if (l==null) // acabou o arquivo?
               break;
            nLinha++; // conta mais uma linha lida do arquivo
            if (nLinha == 40) // chegou ao fim da pagina?
            {
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
        
        arquivo.close();        
    }

    public void executa(){
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n ------------------ MENU ------------------\n");
            System.out.println("1. Exibir todo o índice remissivo;");
            System.out.println("2. Exibir o percentual de stopwords do texto;");
            System.out.println("3. Encontrar a palavra mais frequente;");
            System.out.println("4. Pesquisar palavras;");
            System.out.println("5. Exibir pagina com maior número de palavras indexadas.");
            System.out.println("6. Encerrar o programa.");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    exibirIndiceRemissivo();
                    break;
                case 2:
                    exibirPercentualStopwords();
                    break;
                case 3:
                    encontrarPalavraMaisFrequente();
                    break;
                case 4:
                    pesquisarPalavras();
                    break;
                case 5:
                    System.out.println("Pagina com maior número de palavras indexadas: "+paginamax+" com "+countindex+" palavras.");
                    break;
                case 6:
                    System.out.println("Programa encerrado.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }

    private void exibirIndiceRemissivo(){
        try {
            listaOrdenada.print();
        } catch (Exception e) {
            System.out.println("Erro de path de arquivo");
        }
    }

    private void exibirPercentualStopwords(){
        System.out.println("Porcentagem de StopWords: "+((swcount*100)/totalpalavras)+"%");
    }

    private void encontrarPalavraMaisFrequente(){
        listaOrdenada.maiorOcorrencia(); 
    }

    private void pesquisarPalavras(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a palavra a ser pesquisada: ");
        String palavra = scanner.nextLine();
        listaOrdenada.ocorrenciasPalavra(palavra);
    }
}


