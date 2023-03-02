
import java.io.*;
import java.util.Scanner; 
public class FileSystem {
    public static void create(String filename) {
        try {
            File newFile = new File(filename+".txt");
            if (newFile.createNewFile()) {
              System.out.println("File created: " + newFile.getName());
            } else {
              System.out.println("File already exists.");
            }
          } catch (IOException e) {
            System.out.println("An error occurred while creating to the file.");
            e.printStackTrace();
          }
    }
    public static void write(String text, String filename) {
        try {
            FileWriter FileWriter = new FileWriter(filename+".txt");
            FileWriter.write(text);
            FileWriter.close();
            System.out.println("Saved");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    public static void read(String filename) {
        try {
            File File = new File(filename+".txt");
            Scanner sc = new Scanner(File);
            while (sc.hasNextLine()) {
              String data = sc.nextLine();
              System.out.println(data);
            }
            sc.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred while read from the file.");
            e.printStackTrace();
          }
    }
    public static void delete(String filename) {
        File File = new File(filename+".txt"); 
        if (File.delete()) { 
            System.out.println("Deleted the file: " + File.getName());
        } else {
            System.out.println("Failed to delete the file.");
        } 
    }
}
