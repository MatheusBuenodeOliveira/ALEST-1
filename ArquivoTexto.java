/**
 * Classe responsável pela leitura do arquivo texto.
 * @author Isabel H. Manssour
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArquivoTexto {
    private BufferedReader reader;
    
    /*
    * Abre o arquivo que contém o texto
    */
    public void open(String nomeArquivo) throws IOException{
        Path path1 = Paths.get(nomeArquivo);
        try {
           reader = Files.newBufferedReader(path1, Charset.defaultCharset());
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }    
    }
    
    /**
     * Retorna a próxima linha do arquivo. Caso o arquivo tenha acabado, 
     * retorna uma string vazia.
     * @return a proxima linha do arquivo.
     */
    public String getNextLine() throws IOException {
        try {
            String line = null;
            if( (line = reader.readLine()) != null) 
                return line;
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
        return null;
    }   
    
    /**
     * Fecha o arquivo.
     */
    public void close() throws IOException {
        try {
            reader.close();
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }          
    }
}
