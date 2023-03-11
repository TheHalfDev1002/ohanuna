
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

import a.AsciiAni;
import a.AsciiAni.Loading;
//import chatbot.java.src.main.java.com.google.code.chatterbotapi.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class UI{ 
    public static int whatChar(String x){
        // check if ch is a letter
        char ch = x.charAt(0);
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){return -2;}
        // check if ch is a digit
        int y = Integer.parseInt(x);
        if (y >= 0 && y <= 255){return 0;}
        // check if ch is a whitespace
        if ((ch == ' ') || (ch =='\n') || (ch == '\t')){return -1;}
        else{return -100;}
    }
    public static int[] arrownav(String[][] menuItems) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int selInrow = 0;
        int selIncol = 0;
        // Print the menu
        int[] h = new int[menuItems.length];
        for (int i = 0; i < menuItems.length; i++) {
            h[i] = menuItems[i].length;
        }
        int[][] k = new int [menuItems.length][menuItems[0].length];
        
        
        int a=1,b=0,d=0,e=0,f=0,g=0,l=0,n=0,o=0;
        for (int i = 0; i < menuItems.length; i++) {
            for (int j = 0; j < menuItems[i].length; j++) {
                k[i][j] = a;
                a++;
            }
        }a=0;
        
        /*while(true) {
            for (int i = 0; i < menuItems.length; i++) {
                for(int j = 0; j < menuItems[i].length; j++){
                    System.out.print("   ");
                    if(i == selInrow && j == selIncol){
                        if(j > 0 && j != menuItems[i].length && i > 0 && i != menuItems[i].length){
                        System.out.print((char)27 +"[4m"+menuItems[i][j]+"("+((j+1)%(menuItems[i].length+1)+menuItems[i].length)+")"+(char)27+"[0m");
                        }else{
                        System.out.print((char)27 +"[4m"+menuItems[i][j]+"("+((j+1)%(menuItems[i].length+1))+")"+(char)27+"[0m");
                        }    
                    }
                    else{
                        System.out.print(menuItems[i][j]);
                    }
                }
                System.out.println(" ");
            }
            */
            while (true) {
                    for (int i = 0; i < menuItems.length; i++) {
                        for (int j = 0; j < menuItems[i].length; j++) {
                            System.out.print("   ");
                            if (i == selInrow && j == selIncol) {                                
                                System.out.print((char)27 +"[4m"+menuItems[i][j]+"("+(k[i][j])+")"+(char)27+"[0m");
                            } else {
                                System.out.print(menuItems[i][j]);
                            }
                        }
                        System.out.println();
                    }
                
                
                
                // Read user input
                String c = sc.next();
                if(whatChar(c) == -2){int ch = java.awt.event.KeyEvent.getExtendedKeyCodeForChar(c.charAt(0));
                // Handle arrow keys
                if (ch == 65) { // Up arrow
                    if (selIncol > 0) {
                        selIncol--;
                    }
                } else if (ch == 68) { // Down arrow
                    if (selIncol < menuItems[0].length - 1) {
                        selIncol++;
                    }
                } else if (ch == 87) { // Left arrow
                    if (selInrow > 0) {
                        selInrow--;
                    }
                } else if (ch == 83) { // Right arrow
                    if (selInrow < menuItems.length - 1) {
                        selInrow++;
                    }
                }else if (ch == 90) { // Enter key
                    break;
                }
            }
                else if (whatChar(c) == 0){ 
                    b=Integer.parseInt(c);
                    for (int i = 0;i<k.length; i++) {
                        for (int j = 0; j < k[i].length; j++) {
                            if(k[i][j] == b){
                                selInrow = i;
                                selIncol = j;
                            }
                        }
                    }
                }
            }
            
          int[] x = {selInrow,selIncol};
        return x;  
        }
    
        
    
    /*public static void main(String[] args){
        //Creating the Frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
        //Object;
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setLayout(new BorderLayout());
        JLabel[] labels = {new JLabel("Welcome Back",0),new JLabel("Select User",0),new JLabel("<html>Welcome Back<br/>Select user</html>", 0)};

        JButton send = new JButton("Send");
        JButton reset = new JButton("Reset");// Components Added using Flow Layout
        panel.add(send);
        panel.add(reset);
        //panel.add(labels[0]);
        //panel.add(labels[1],BorderLayout.NORTH);
        panel.add(labels[2],BorderLayout.BEFORE_FIRST_LINE);
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);

        frame.setVisible(true);
        
    }
    */
    
       /*  public static int[] arrownav(String[][] menuItems) throws IOException { 
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int selInrow = 0;
            int selIncol = 0;
        
              // Print the menu
              for (int i = 0; i < menuItems.length; i++) {
            
                for(int j = 0; j < menuItems[i].length; j++){
                    System.out.print("   ");
                    if(i == 0 && j == 0){
                        System.out.print((char)27 +"[4m"+menuItems[i][j]+(char)27 +"[0m");
                    }else{
                        System.out.print(menuItems[i][j]);
                    }
                }
                System.out.println(" ");
              }
            
              
    
              
          // Read user input
          int ch = reader.read();
        while(ch!=10){
          // Handle arrow keys
          if (ch == 65) { // Up arrow
            if (selIncol > 0) {
              selIncol--;
            }
          } else if (ch == 66) { // Down arrow
            if (selIncol < menuItems[0].length - 1) {
              selIncol++;
            }
          } else if (ch == 67) { // Left arrow
            if (selInrow < menuItems.length - 1) {
              selInrow++;
            }
          }else if (ch == 68) { // right arrow
            if (selInrow > 0) {
              selInrow--;
            } 
          }for (int i = 0; i < menuItems.length; i++) {
            
            for(int j = 0; j < menuItems[i].length; j++){
                System.out.print("   ");
                if(i == selInrow && j == selIncol){
                    System.out.print((char)27 +"[4m"+menuItems[i][j]+(char)27 +"[0m");
                }else{
                    System.out.print(menuItems[i][j]);
                }
            }
            System.out.println(" ");
          }
          if (ch == 10) { // Enter key
            System.out.println("Off You Go To " + menuItems[selInrow][selIncol]);
          }
        }
        int[] x = {selInrow,selIncol};
        return x;
    }*/
    /*public static void chat()throws Exception {
        Scanner sc = new Scanner(System.in);
        ChatterBotFactory factory = new ChatterBotFactory();
        ChatterBot bot1 = factory.create(ChatterBotType.CLEVERBOT);
        ChatterBotSession botsession = bot1.createSession();
        String name = "Jacq";
        System.out.println("CHATTERBOT JACQ 1.0 BY PIERREDAVIDBELANGER\nVERSION 1.5 BY ORI\nAT ANY MOMENT TYPE 'EXIT' TO EXIT");
        String input;
        System.out.print("You:");
        input = sc.nextLine();
        while(input != "exit"){
            try {
                System.out.println(name+":"+botsession.think(input));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.print("You:");
            input = sc.nextLine();
        }
        System.out.println(name+": Bye Bye!");
    }
    */
    static class PrintWriterStream { //super hacky way of combining a PrintWriter and a PrintStream
        
        private PrintWriter w;
        private PrintStream s;
    
        PrintWriterStream(PrintWriter w) { //support for PrintWriter
            if(w == null)
                throw new NullPointerException();
            this.w = w;
        }
    
        PrintWriterStream(PrintStream s) { //support for PrintStream
            if(s == null)
                throw new NullPointerException();
            this.s = s;
        }
    
        void println() {
            if(w == null && s != null)
                s.println();
            else if(s == null && w != null)
                w.println();
            else
                throw new NullPointerException("No valid output");
        }
    
        void println(String x) {
            if(w == null && s != null)
                s.println(x);
            else if(s == null && w != null)
                w.println(x);
            else
                throw new NullPointerException("No valid output");
        }
    
        public void flush() {
            if(w == null && s != null)
                s.flush();
            else if(s == null && w != null)
                w.flush();
            else
                throw new NullPointerException("No valid output");
        }
    }
    
    class OriEdit extends JFrame implements ActionListener {
        // Text component
        JTextArea t;
     
        // Frame
        JFrame f;
     
        // Constructor
        OriEdit()
        {
            // Create a frame
            f = new JFrame("Ori-Edit 0.1");
     
            try {
                // Set metal look and feel
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
     
                // Set theme to ocean
                MetalLookAndFeel.setCurrentTheme(new OceanTheme());
            }
            catch (Exception e) {
            }
     
            // Text component
            t = new JTextArea();
     
            // Create a menubar
            JMenuBar mb = new JMenuBar();
     
            // Create amenu for menu
            JMenu m1 = new JMenu("File");
     
            // Create menu items
            JMenuItem mi1 = new JMenuItem("New");
            JMenuItem mi2 = new JMenuItem("Open");
            JMenuItem mi3 = new JMenuItem("Save");
            JMenuItem mi9 = new JMenuItem("Print");
     
            // Add action listener
            mi1.addActionListener(this);
            mi2.addActionListener(this);
            mi3.addActionListener(this);
            mi9.addActionListener(this);
     
            m1.add(mi1);
            m1.add(mi2);
            m1.add(mi3);
            m1.add(mi9);
     
            // Create amenu for menu
            JMenu m2 = new JMenu("Edit");
     
            // Create menu items
            JMenuItem mi4 = new JMenuItem("cut");
            JMenuItem mi5 = new JMenuItem("copy");
            JMenuItem mi6 = new JMenuItem("paste");
     
            // Add action listener
            mi4.addActionListener(this);
            mi5.addActionListener(this);
            mi6.addActionListener(this);
     
            m2.add(mi4);
            m2.add(mi5);
            m2.add(mi6);
     
            JMenuItem mc = new JMenuItem("close");
     
            mc.addActionListener(this);
     
            mb.add(m1);
            mb.add(m2);
            mb.add(mc);
     
            f.setJMenuBar(mb);
            f.add(t);
            f.setSize(500, 500);
            f.setVisible(true);
        }
     
        // If a button is pressed
        public void actionPerformed(ActionEvent e)
        {
            String s = e.getActionCommand();
     
            if (s.equals("cut")) {
                t.cut();
            }
            else if (s.equals("copy")) {
                t.copy();
            }
            else if (s.equals("paste")) {
                t.paste();
            }
            else if (s.equals("Save")) {
                // Create an object of JFileChooser class
                JFileChooser j = new JFileChooser("f:");
     
                // Invoke the showsSaveDialog function to show the save dialog
                int r = j.showSaveDialog(null);
     
                if (r == JFileChooser.APPROVE_OPTION) {
     
                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());
     
                    try {
                        // Create a file writer
                        FileWriter wr = new FileWriter(fi, false);
     
                        // Create buffered writer to write
                        BufferedWriter w = new BufferedWriter(wr);
     
                        // Write
                        w.write(t.getText());
     
                        w.flush();
                        w.close();
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // If the user cancelled the operation
                else
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
            }
            else if (s.equals("Print")) {
                try {
                    // print the file
                    t.print();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(f, evt.getMessage());
                }
            }
            else if (s.equals("Open")) {
                // Create an object of JFileChooser class
                JFileChooser j = new JFileChooser("f:");
     
                // Invoke the showsOpenDialog function to show the save dialog
                int r = j.showOpenDialog(null);
     
                // If the user selects a file
                if (r == JFileChooser.APPROVE_OPTION) {
                    // Set the label to the path of the selected directory
                    File fi = new File(j.getSelectedFile().getAbsolutePath());
     
                    try {
                        // String
                        String s1 = "", sl = "";
     
                        // File reader
                        FileReader fr = new FileReader(fi);
     
                        // Buffered reader
                        BufferedReader br = new BufferedReader(fr);
     
                        // Initialize sl
                        sl = br.readLine();
     
                        // Take the input from the file
                        while ((s1 = br.readLine()) != null) {
                            sl = sl + "\n" + s1;
                        }
     
                        // Set the text
                        t.setText(sl);
                    }
                    catch (Exception evt) {
                        JOptionPane.showMessageDialog(f, evt.getMessage());
                    }
                }
                // If the user cancelled the operation
                else
                    JOptionPane.showMessageDialog(f, "the user cancelled the operation");
            }
            else if (s.equals("New")) {
                t.setText("");
            }
            else if (s.equals("close")) {
                f.setVisible(false);
            }
        }
        public static void run() {
            UI e = new UI();
            e.new OriEdit();
        }
    }
    public static String[] usernames = new String[2];
    public static String[] passwords = new String[2];
    public static void run() throws InterruptedException{
        ui();
    }
    private static void ui() throws InterruptedException {
        Console var1 = System.console();
        if (var1 == null) {
            System.out.println("OriOS Doesn't Run On IDE Terminals. Please Run OriOS On The Command Line.");
            System.exit(0);
        }

        Scanner var2 = new Scanner(System.in);
        usernames[0] = "orihanuna";
        passwords[0] = "ori10hanuna";
        double[] z = new double[2];
        z[0]=0;z[1]=0;
        System.out.println("--------------ORI-OS-VERSION-0.1----------------");
        int var3 = 0;
        boolean var4 = false;
        String var5 = null;
        
        for(int sel; var3 < 4; var4 = false) {
            int var7 = 3 - var3;
            z[0]=0;z[1]=0;
            System.out.println("---------------SELECT--USERNAME-----------------\n------------------------------------------------");
            for(int i = 0;i<usernames.length;i++){
                int j = i+1;
                String s = usernames[i].toUpperCase()+"("+j+")";
                int k = (48-s.length())/2;
                for (int h=0;h<k;h++){
                    System.out.print("-");
                }
                k = 48-k-s.length();
                System.out.print(s);
                for (int h=0;h<k;h++){
                    System.out.print("-");
                }
                System.out.println("");
            }
            sel = var2.nextInt()-1;
            if (sel == 2) {
                try {
                    uinavscreen(3);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                
            
            char[] var9 = var1.readPassword("Enter your secret password: ", new Object[0]);
            var5 = new String(var9);
            boolean var10 = true;
            System.out.println("\n");
            if (var5.equals(passwords[sel])) {
                var4 = true;
                Thread.sleep(1000L);
                System.out.println("Welcome, " + usernames[sel]);

                for(int var11 = 10; var11 <= 100; var11 += 10) {
                    System.out.print("\rLoading... " + var11 + "%");
                    Thread.sleep(500L);
                }

                System.out.println("\n");
                try {
                    uinavscreen(sel);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }

            System.out.println("The Username Or Password Was Incorrect. You Have " + var7 + " More Tries");
            ++var3;
        }

        if (var3 == 4 && !var4) {
            System.out.println("You've Reached The Maximum Amount Of Tries(3)");
            System.exit(1);
        }

    }
    private static void uinavscreen(int var0) throws InterruptedException, IOException {
        Scanner var1 = new Scanner(System.in);
        Calendar var2 = Calendar.getInstance();
        int var3 = 0;
        int[] var4 = {0,0};
        int[] quit = {0,3};
        String[][] menu = {{"          Calculator       ","OriEdit 1.5.0","  Login Info"},
                           {"    OpenSource Deceleration   ","    Credits"," Software & Games"},
                           {"Sorting Algorithms (Coming Soon)","Quit OriUI","       More      "}};
        char[][] menuchars = {{'c','e','l'},
                              {'o','d','g'},
                              {'s','q','m'}};
        while(var4!=quit){
            
        
            while(var3 < 48) {
                System.out.print("-");
                Thread.sleep(50L);
                ++var3;
            }

            System.out.println("\n");
            System.out.println(var2.getTime() + " (is right for the second of successful login)");
            var4 = arrownav(menu);
            char choice = menuchars[var4[0]][var4[1]];
            switch(choice) {
            case 'e':
                OriEdit.run();
                break;
            case 'c':
                calc();
                break;
            case 'l':
                Thread.sleep(500L);
                String var10001 = usernames[var0];
                System.out.println("Username: " + var10001);
                Thread.sleep(500L);
                var10001 = passwords[var0];
                System.out.println("Pass: " + var10001);
                break;
            case 'o':
                String s = "NOCopyright (c) 2022, The OHanuna Company and/or its affiliates. All rights NOTreserved."
                +"\nDO NOT ALTER OR REMOVE NOCOPYRIGHT NOTICES OR THIS FILE HEADER."
                +"\nThis code is open source; Whats that? That means that since publication of"
                +"\nthis file, ANYONE can modify a copy of this file to their needs,"
                +"\nAs long this message do appear\n"
                +"\nThis code is distributed in the hope that it will be useful, but WITHOUT"
                +"\nANY COPYRIGHT; this code officially owned by the internet."
                +"\nLater versions could get a price tag.";
                typewriter(s,15); 
                Thread.sleep(1000);
                break;   
            case 'g':
                System.out.println("Choose Game/Software:\n(1)MGC: InvAosian!! By THEOHANUNACOMPANY\n(2)CHATTERBOT AI 1.0 by JIRE Taken from GITHUB\nType 100 to exit.");
                int x = var1.nextInt();
                switch (x) {
                    case 1:
                        MGC.run();
                        break;
                    case 2:
                        try {
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 100:
                        break;         
                    default:
                        System.out.println("There is no software numbered "+x+", try again.");
                        break;

                }
            case 'd': 
                System.out.println();
                
            }
        }
        if (var4 == quit) {
            var1.close();
            AsciiAni e = new AsciiAni(); 
            e.new Loading(100);
            System.out.println("Goodbye!");
            System.exit(0);
        }


    }
    
    private static void calc() throws InterruptedException {
        Scanner var4 = new Scanner(System.in);
        System.out.println("Choose an operator: +, -, *, /, Or ^ (Exponentiation)");
        char var0 = var4.next().charAt(0);
        System.out.println("Enter first number");
        Double var1 = var4.nextDouble();
        System.out.println("Enter second number");
        Double var2 = var4.nextDouble();

        for(int var5 = 10; var5 <= 100; var5 += 10) {
            System.out.print("\rLoading... " + var5 + "%");
            Thread.sleep(100L);
        }

        System.out.println("\n");
        Double var3;
        switch(var0) {
        case '*':
            var3 = var1 * var2;
            System.out.println(var1 + " * " + var2 + " = " + var3);
            break;
        case '+':
            var3 = var1 + var2;
            System.out.println(var1 + " + " + var2 + " = " + var3);
            break;
        case '-':
            var3 = var1 - var2;
            System.out.println(var1 + " - " + var2 + " = " + var3);
            break;
        case '/':
            var3 = var1 / var2;
            System.out.println(var1 + " / " + var2 + " = " + var3);
            break;
        case '^':
            var3 = Math.pow(var1, var2);
            System.out.println(var1 + " ^ " + var2 + " = " + var3);
            break;
        case '$':
            int x;
            var3 = var1-Math.pow(var1*2,var2)+var1;
            System.out.println(var1 + " - (( " + var1 + " *2) ^ " +var2+") +"+var1+" = "+ var3);
            break;
        default:
            System.out.println("Invalid operator!");
        }
        Thread.sleep(500);
    }
    private static void typewriter(String x,long millis) throws InterruptedException{
        char[] c = x.toCharArray();
        for(int i = 0; i <= c.length-1; i++) {
            System.out.print(c[i]);
            Thread.sleep(millis);
        }
    }
    
    
    public class MGC{
        public class Enemy{
            String type,openingSent;
            int hp,level;
            String[] attacks;
            int[] damageByAtt;

            public Enemy(String type, String openingSent, int hp, int level,String[] attacks, int[] damageByAtt) {
                this.type = type;
                this.openingSent = openingSent;
                this.hp = hp;
                this.level = level;
                this.attacks = attacks;
                this.damageByAtt = damageByAtt;
            }
        }
        public class Player{
            
        }
        private static void combatSys(Enemy[] enemies,int plLevel) throws InterruptedException{
            int hp=100+(plLevel*20);
            int points;
            int i;
            int[] enemyHP = new int[enemies.length];
            for (i = 0;i<enemyHP.length;i++) {
                enemyHP[i] = enemies[i].hp;
            }
            for(i=0;i<enemies.length;i++){
                System.out.println("A "+enemies[i].type+" Appeared!");
                System.out.println(enemies[i].type+": "+enemies[i].openingSent);
            }
            boolean leave = false;
            while(!leave){
                System.out.println("You Have "+hp+" HP And "+"ABPoints.\nWhat Are You Gonna Do?\n(0)Try To Escape(40% Failing)\n(1)Slap Him Basic\n(2)Choose \n(3)Choose Between Your Items\n(4)Defend");
            }
        }
        private static void mgc() throws InterruptedException {
            System.out.println("Apply FullScreen To The Command Line For Better Gameplay.");
            AsciiAni a = new AsciiAni();
            a.new Loading(200);
            String x = "                                                                                                                 \n"
            +"                                                  ...                                                                      \n"
            +"                          ^^^^^^^^:            ^~~~                                                        -.              \n"
            +"                         ~!      .~~.        :!^ !:                      .7                               . .              \n"
            +"                        .7         .!^     .~~   7                 .:^^^^77            .:^.            .^!^ :              \n"
            +"                        7:           :7.  :7.   :!              .^~^:.   7   .::^~7JY5B&&#^          :!!:  :7              \n"
            +"                       :7     .       .!^:7     ~~          .^~^^.     ^5YY5G#&&@@@@@@@@@G         ~?~.    :!              \n"
            +"                       7:    :7!        :~.     ~^       .^~:.     .^?P&@@@@@@@@@@@@@@@@@?      .^?7.      :!              \n"
            +"                      :7    :7 ^!          ?!   !^     .!!^    ^^^~?B@@@@@@@@@@@@@@@@@@@Y     :~^.      .  :!              \n"
            +"                      !^    7.  ^~^^:.. .^~7~   ?~  .^7J!  :::^^^^P@@@@@@@@&&########B5~    ~7:        ~7~ :!              \n"
            +"                     ^!    ~~      .::^^^. ~~   ^7~!?7  .:^^^^:: J@@@&Y7~~^::........       .^!.   .:.!^ ? :!              \n"
            +"                    ~!    ~~               ^^:^!!~~^    |~^~.    G@@B^                        .!:   7!   7 :!              \n"
            +"                 .^~:    ~!               ^~~:~~:.  !^     ~~   !@@@!                           7:   7:  ? :!              \n"
            +"             .:^~^. ^~~~!^ .           .~~:. 7~  ....     ^!:   7@@@G?^.          ....          .7.   ~!.7 :!              \n"
            +"            ~^:.    :^^^^:^:7.        !~.       ^^^^^::...      7B@@@@&#GPPPPPPPGB####G^         :7    ~Y^ :!              \n"
            +"           ^~~~~!7?!!7!!!~^!7.        7^            ....::::^^^~^ ?#@@@@@@@@@@@@@@@@@@@J          ^!   :G  :!              \n"
            +"             ^^^^^^:^J....~~           ^77^.   ^~!!~~J!^::.:.      .?B@@@@@@@@@@@@@@@@@J           ^!  .~  :!              \n"
            +"             .     7.         ..        ^~^^^^~7~::^^^!:              ^7YPB&&&@@@@@@@@&!            ^!   ..~?.             \n"
            +"                   7:         !J.  ::    .      :                          .:::^^^^^^::              ~~^~^^!?~~            \n"
            +"                   ^~:        !~7. 7:  Y      :JY7     @@         .^^:                               ^J! ^^:  ~!           \n"
            +"      .:::^^^~~~!!?!^:^^^^   :! :!.7  ??    .5^    Y!       .7!!!!  .^^!J                          .7: :      ^!           \n"
            +"      ^~~~!~^^^^::.....     ^!   !J:   5:  ^Y:      .P @@   Y!                                     ^!       .~!            \n"
            +"                           ~~    .Y    !Y  ^G        5 @@   7?:.       7:   .::::.  J  :^^         .7:..::^~~:             \n"
            +"                          .!      ^     5 ~5         P7@@    ^7?JY7    :5..Y!~.  ~J !G?7^!Y.        .^^::..                \n"
            +"                                         JG~         ~Y@@    ?!~~~^:    Y~ ?7^^  ^J B7.   !Y                               \n"
            +"                                         .:        J!  @@  J~^          7~  :^^^^^: ~     ^5                               \n"
            +"                                           K@O9!//1    @@                           .!    .!                               \n"
            +"                                                         __                                                                \n"
            +"                                                        /  \\                                                              \n"
            +"                                                       |   |                                                               \n"
            +"                                         Created By The \\__/hanuna Company 2022                                           \n";
            typewriter(x, 15);
        }
        public static void run() throws InterruptedException {
            mgc();
        }
    } 
}