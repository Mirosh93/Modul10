//import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
}

public class Task2 {
    public static void main(String[] args) {
        convertToJSON("file.txt", "user.json");
    }

    public static void convertToJSON(String inputFilename, String outputFilename) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            boolean firstLine = true;
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip header line
                }
                String[] parts = line.split(" ");
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                users.add(new User(name, age));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       // try (FileWriter writer = new FileWriter(outputFilename)) {
           // new Gson().toJson(users, writer);
        } //catch (IOException e) {
           // e.printStackTrace();
        }
 //   }
//}
