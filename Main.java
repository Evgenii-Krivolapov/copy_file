import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Пример ввода: C:/Users/Софья/Desktop/...");
        System.out.println("Введите путь до папки которую хотите скопировать: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        System.out.println("Введите путь до папки в которую хотите скопировать: ");
        Scanner scanner1 = new Scanner(System.in);
        String target = scanner1.nextLine();
        copyFolder(path, target);

    }

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        try {
            Files.walk(Paths.get(sourceDirectory))
                    .forEach(source -> {
                        Path destination = Paths.get(destinationDirectory, source.toString()
                                .substring(sourceDirectory.length()));
                        try {
                            Files.copy(source, destination);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}