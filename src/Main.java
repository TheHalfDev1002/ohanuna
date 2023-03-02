import java.util.Scanner;
public class Main{
    static String[] lol = {"hi", "lol"};
    public static void main(String[] args) throws InterruptedException{
        UI.run();
    } 
    public static String scanLine() {
    
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        return input;
    }
    public static void scanNprint(String pattern){
        System.out.print(pattern+"  ");
        String s = scanLine();
        System.out.print(s);
    }
}
