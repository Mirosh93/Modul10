import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String[] args) {
        countWordFrequency("words.txt");
    }

    public static void countWordFrequency(String filename) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                while (tokenizer.hasMoreTokens()) {
                    String word = tokenizer.nextToken();
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e)  {
            e.printStackTrace();
        }

        wordFrequencyMap.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
