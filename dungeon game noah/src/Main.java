

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

class Main {

    public static boolean printFirstSeperator = false;
    public static Player p = new Player();
    public static GameGraphics UI;

    static {
        try {
            UI = new GameGraphics();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (FontFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map m = new Map(5, 5); // Assign map as a public field rather than an internal map variable
    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws IOException {
        Inventory.myItems.add("apple");
        m.createMapOne();
        m.currentMap = m.mapRep;
        UI.start();
        levelOne();
    }
    public static String bold(){
        return"\033[0;1m";
    }   

    public static String unbold(){
        return "\033[0m";
    }

    public static String colorString(String text, int red, int green, int blue){
        String rgbEscapeCode = String.format("\u001B[38;2;%d;%d;%dm", red, green, blue);
        String resetColor = "\u001B[0m";
        return rgbEscapeCode + text + resetColor;

    }

    public static String colorChar(char text, int red, int green, int blue){
        String rgbEscapeCode = String.format("\u001B[38;2;%d;%d;%dm", red, green, blue);
        String resetColor = "\u001B[0m";
        return rgbEscapeCode + text + resetColor;
    }


    private static void levelOne() throws IOException {
        String response1;
       // Scanner input = new Scanner(System.in);

        p = new Player();
        String startingMessage = "[Backstory]: You are a thief that has attempted to steal coins and you got caught. You are now serving time in prison. You have a friend, Doug who is a Prison Guard, he wants you to turn your life around. \n"+bold()+"[Doug]: I found a job opportunity for you, It's hauling crates for the Dining Hall. I'm wondering if a theif like you would even consider the position."+unbold()+" \n You have 3 lives, 100 health, and you are 25% liked! \n";
        System.out.println("--------------------------------------------");
        System.out.println(startingMessage);
        System.out.println("You can press \"Q\" to check game controls anytime during the game.");
        BasicCommands.canMove = true;
    }
    public void Instructions(){
        System.out.println("Use W,A,S,D keys to naviagate around.");
        System.out.println("You have an inventory, move around to find what to do next.");
    }
}
