import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperationsDemo {

    public static void main(String[] args) {
        String fileName = "sample.txt";

        // 1. Create or overwrite the file
        createFile(fileName);

        // 2. Write to the file
        writeToFile(fileName);

        // 3. Read from the file
        readFromFile(fileName);

        // 4. Modify the file (append new content)
        modifyFile(fileName);
    }

    // Creates or overwrites the file
    private static void createFile(String fileName) {
        try {
            Files.write(Paths.get(fileName), "".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File created or overwritten: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    // Writes initial content to the file
    private static void writeToFile(String fileName) {
        List<String> lines = Arrays.asList("Hello, World!", "Java File Operations", "End of File");
        try {
            Files.write(Paths.get(fileName), lines, StandardOpenOption.APPEND);
            System.out.println("Data written to file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Reads and displays the content of the file
    private static void readFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            System.out.println("Reading from file:");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    // Modifies the file by appending new content
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
