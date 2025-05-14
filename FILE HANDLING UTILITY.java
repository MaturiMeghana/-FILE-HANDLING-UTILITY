import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperationsDemo {
    public static void main(String[] args) {
        String fileName = "sample.txt";

        createFile(fileName);

        writeToFile(fileName);

        readFromFile(fileName);

       modifyFile(fileName);
    }

   private static void createFile(String fileName) {
        try {
            Files.write(Paths.get(fileName), "".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File created or overwritten: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    private static void writeToFile(String fileName) {
        List<String> lines = Arrays.asList("Hello, World!", "Java File Operations", "End of File");
        try {
            Files.write(Paths.get(fileName), lines, StandardOpenOption.APPEND);
            System.out.println("Data written to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("Reading from file:");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    private static void modifyFile(String fileName) {
        List<String> newLines = Arrays.asList("New line added.", "Appending content to file.");
        try {
            Files.write(Paths.get(fileName), newLines, StandardOpenOption.APPEND);
            System.out.println("File modified: " + fileName);
        } catch (IOException e) {
            System.err.println("Error modifying file: " + e.getMessage());
        }
    }
}
