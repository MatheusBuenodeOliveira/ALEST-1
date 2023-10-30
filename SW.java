import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SW{
    public static LinkedListOfString stopWords(){
        String filePath = "C:\\.dev\\trab\\ALEST-1\\StopWords-EN.txt";
        LinkedListOfString stopWords = new LinkedListOfString();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String word;
            while ((word = br.readLine()) != null) {
                String[] lineWords = word.split(" ");
                for (String w : lineWords) {
                    stopWords.orderedAdd(w);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    return stopWords;
}
}