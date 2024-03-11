import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        validatePhoneNumbers("file.txt");
    }

    public static void validatePhoneNumbers(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}");
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            //     e.printStackTrace(); не могу подругому сделать просто уберите коммент
        }
    }
}
