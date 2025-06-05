

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

    public static String italic(){
        return "\033[3m";

    }

    public static String unitalic(){
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

        /*while(true){
            String expectedInput = "Type Y and press enter to say \"Yes\" \n Type N and press enter to say \"No\" \n Type I and press enter \"Ignore\" ";
            System.out.println(expectedInput);
            //response1 = input.nextLine();
            //BasicCommands.movement(response1, p);
            //if (response1.equals("Y")||response1.equals("y")){
                System.out.println(bold()+" [Doug]: Good! You can start on Monday."+unbold());


                p.likability +=10;
                System.out.println(italic()+ "Game: You gained 10% likability for taking the job!"+unitalic());
                System.out.println(italic()+" Game: Navgiate to your new job shown on the map."+unitalic());
                System.out.println("----------------------------------------");
                clearScreen();
                m.visual();
                break;
            }
            /*else if (response1.equals("N")||response1.equals("n")){
                System.out.println(bold()+"[Doug]: You're never gonna get anywhere in life."+unbold());
                p.likability -=10;
                System.out.println(italic()+ "Game: You lost 10% likability for being bad friend!"+unitalic());
                System.out.println(italic()+"Game: Navgiate to your bed and get some rest."+unitalic());
                System.out.println("----------------------------------------");
                clearScreen();
                m.visual();
                break;


            }
            /*else if (response1.equals("I")||response1.equals("i")){
                System.out.println(bold()+"[Doug]: Givin' me the silent treatment huh?"+unbold());
                p.likability -=10;
                System.out.println(italic()+ "Game: You lost 10% likability for ignoring your friend!" +unitalic());
                System.out.println(italic()+ "Game: Navgiate to your bed and get some rest." +unitalic());
                System.out.println("----------------------------------------");
                clearScreen();
                m.visual();
                break;


            }
            /*else if (response1.equals("s")||response1.equals("S")){
                p.stats();
            }else{

             */
            //}
        //}
        System.out.println("You can press \"Q\" to check game controls anytime during the game.");
        BasicCommands.canMove = true;
        /*while(true){

            response1 = input.nextLine();
            BasicCommands.getCommands(response1);
            BasicCommands.movement(response1, p);
            clearScreen();
            m.visual();
            if(response1.equals("e") || response1.equals("E")){
                while(true){

                    BasicCommands.checkItemsNearMe(p);
                    response1 = input.nextLine();
                    if(!response1.equals("1") && !response1.equals("2") && !response1.equals("3") && !response1.equals("4")){
                        System.out.println("Invalid Input. Type a number between 1 and 4.");
                    }
                    else{
                        break;
                    }
                }
                BasicCommands.interactInput(response1, p, m);
            }


        }*/
    }
    public void Instructions(){
        System.out.println("Use W,A,S,D keys to naviagate around.");
        System.out.println("You have an inventory, move around to find what to do next.");
    }
}
