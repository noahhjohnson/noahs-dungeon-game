import java.util.ArrayList;

import java.util.Scanner;

//Make Interact Menu Clockwise



public class BasicCommands{
    static boolean gameBegin = true;
    //Forward: W
    //Left: A
    //Backwards: S
    //Right: D
    //Interact: E
    //Block: X
    //Attack: J
    public static ArrayList<String> itemsNearMe = new ArrayList<>();



    // 1.) Bottom Right Guard: 16,16 | 2.) Bottom Left Guard: 3,16
    public static ArrayList <Integer> interactcounts = new ArrayList<>();
    public static void addinteractcount(){
        interactcounts.add(0);
    }

  /*public static void printItemsNearMe(){
    for(String s: itemsNearMe){
      System.out.print(s);
    }
    System.out.println();
    for(int i=1; i<itemsNearMe.size(); i++){
      if(!itemsNearMe.get(i).equals("")){
        System.out.print(i);
      }
    }
  }*/

    public static String italic(){
        return "\033[3m";

    }

    public static String unitalic(){
        return "\033[0m";

    }

    public static String bold(){
        return"\033[0;1m";

    }

    public static String unbold(){
        return "\033[0m";

    }

    public static void checkItemsNearMe(Player p, String [][] map){
        itemsNearMe.clear();
        for(int i=0; i<4; i++){
            itemsNearMe.add("");
        }
        //Up
        if(!map[p.x][p.y-1].equals("W") && !map[p.x][p.y-1].equals(".") ){
            itemsNearMe.set(0, map[p.x][p.y-1]);

        }
        if(!map[p.x-1][p.y].equals("W") && !map[p.x-1][p.y].equals(".") ){
            itemsNearMe.set(3, map[p.x-1][p.y]);

        }
        if(!map[p.x][p.y+1].equals("W") && !map[p.x][p.y+1].equals(".") ){
            itemsNearMe.set(2, map[p.x][p.y+1]);

        }
        if(!map[p.x+1][p.y].equals("W") && !map[p.x+1][p.y].equals(".") ){
            itemsNearMe.set(1, map[p.x+1][p.y]);

        }
        System.out.println(itemsNearMe);
        System.out.println(" 1  2  3   4 ");
        if(gameBegin)System.out.println(italic()+"Game: This is where you can choose what to interact with." +unitalic());
        System.out.println("---------------------");
        gameBegin = false;

    }

    public static int interactCount = 0;
    public static int interactCount2 = 0;

    public static char interactInput(String i, Player p, Map m){


        int inputInt = -1;
        for (int j = 0; j<itemsNearMe.size();j++){

        }

        char inputChar = '_';
        if(i.equals("W") || i.equals("A") || i.equals("S") || i.equals("D")){
            movement(i, p, m.currentMap);
            m.visual();
            System.out.println("w");
            return '_';
        }
        if(i.equals("1")||i.equals("2")||i.equals("3")||i.equals("4")){
            inputInt = Integer.parseInt(i);
        }

        //getInteractCell(inputInt);
        System.out.println("InteractCell "+ getInteractCell(inputInt, m.currentMap));

        if(itemsNearMe.get(inputInt-1).length()==0){
            return '-';
        }
        inputChar = itemsNearMe.get(inputInt-1).charAt(0);
        String colorinputInmate = Main.colorChar('I',255,255,0);

        //else System.out.println(bold()+"Game: Interact with a plausable object."+unbold());

        if(inputInt == 3 && p.x == 2 && p.y == 3){
            System.out.println(italic()+"Game: This is a door."+unitalic());
            m.createMapTwo(p);
            m.visual();
        }
        if(inputInt == 2 && p.x == 10 && p.y == 1){
            System.out.println(italic()+"Game: This is a sink, you wash your face."+unitalic());
        }
        if(inputInt == 1 && p.x == 11 && p.y == 2){
            System.out.println(italic()+"Game: Ths is a sink, you wash your face."+unitalic());
        }
        if(inputInt == 1 && p.x == 9 && p.y == 2){
            System.out.println(italic()+"Game: This is a bed, you can sleep to regain health."+unitalic());
            p.health +=15;
        }
        if(inputInt == 4 && p.x == 10 && p.y == 1){
            System.out.println(italic()+"Game: This is a bed, you can sleep to regain health."+unitalic());
            p.health +=15;
        }
        if(inputInt == 2 && p.x == 2 && p.y == 1){
            System.out.println(italic()+"Game: This is a sink, you wash your face."+unitalic());
        }
        if(inputInt == 1 && p.x == 3 && p.y == 2){
            System.out.println(italic()+"Game: This is a sink, you wash your face."+unitalic());
        }
        if(inputInt == 1 && p.x == 1 && p.y == 2){
            System.out.println(italic()+"Game: This is a bed, you can sleep to regain health."+unitalic());
            p.health +=15;
        }
        if(inputInt == 4 && p.x == 2 && p.y == 1){
            System.out.println(italic()+"Game: This is a bed, you can sleep to regain health."+unitalic());
            p.health +=15;
        }

        if (inputInt == 3 && p.x == 3 && p.y == 13) {
            System.out.println("Open the door");
            GameGraphics.doorOnOff = false;
            m.currentMap[3][14] = ". ";
        }

        if (inputInt == 4 && p.x == 2 && p.y == 15 || inputInt == 1 && p.x == 1 && p.y == 16) {
            System.out.println("This is a vent.");
            GameGraphics.isInVentMenu = true;
        }





        if((inputInt == 4 && p.x == 5 && p.y == 13) ||
                (inputInt == 4 && p.x == 6 && p.y == 14) ||
                (inputInt == 1 && p.x == 5 && p.y == 15) ||
                (inputInt == 1 && p.x == 4 && p.y == 15) ||
                (inputInt == 2 && p.x == 3 && p.y == 14) ||
                (inputInt == 3 && p.x == 4 && p.y == 13)){
            System.out.println(italic()+"Guard: If you want this key, you'll have to give me something in return.."+unitalic());
        }



    /*
    if(inputInt == 4 && p.x == 5 && p.y == 13){
      System.out.println(italic()+"Guard: If you want this key, you'll have to give me something in return.."+unitalic());
    }
    if(inputInt == 4 && p.x == 6 && p.y == 14){
      System.out.println(italic()+"Guard: If you want this key, you'll have to give me something in return.."+unitalic());
    }
    if(inputInt == 1 && p.x == 5 && p.y == 15){
      System.out.println(italic()+"Guard: If you want this key, you'll have to give me something in return.."+unitalic());
    }
    if(inputInt == 1 && p.x == 4 && p.y == 15){
      System.out.println(italic()+"Guard: If you want this key, you'll have to give me something in return.."+unitalic());
    }
    if(inputInt == 2 && p.x == 3 && p.y == 14){
      System.out.println(italic()+"Guard: If you want this key, you'll have to give me something in return.."+unitalic());
    }
    if(inputInt == 3 && p.x == 4 && p.y == 13){
      System.out.println(italic()+"Guard: If you want this key, you'll have to give me something in return.."+unitalic());
    }
    */
        if(inputInt == 3 && p.x == 4 && p.y == 3){
            System.out.println(italic()+""+unitalic());
        }






        if(p.x == Map.offsetx + 17 && p.y == Map.offsety + 5){
            System.out.println(bold()+"Depressed Guy: Just leave me alone.."+unbold());
        }
        if( p.x == Map.offsetx +  18 && p.y == Map.offsety + 6){
            System.out.println(bold()+"Depressed Guy: Just leave me alone.."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 13 && p.y == Map.offsety + 7){
            System.out.println(bold()+"Inmate: Gimmie your shoes"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 14 && p.y == Map.offsety + 6){
            System.out.println(bold()+"Inmate: Gimmie your shoes"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 15 && p.y == Map.offsety + 7){
            System.out.println(bold()+"Inmate: Gimmie your shoes"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 5 && p.y == Map.offsety + 6){
            System.out.println(bold()+"Inmate: I'm telling you, if they don't bring back the good coffee in the cafeteria, I'm going to organize a protest...just like the French..."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 4 && p.y == Map.offsety + 7){
            System.out.println(bold()+"Inmate: I'm telling you, if they don't bring back the good coffee in the cafeteria, I'm going to organize a protest...just like the French..."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0))&& p.x == Map.offsetx + 15 && p.y == Map.offsety + 11){
            System.out.println(bold()+"Inmate: Hey, if you keep taking my seat at the card table, I'm going to challenge you to a game of 'Monopoly,' and trust me, it's going to be a life sentence. I never lose!"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 14 && p.y == Map.offsety + 10){
            System.out.println(bold()+"Inmate: Hey, if you keep taking my seat at the card table, I'm going to challenge you to a game of 'Monopoly,' and trust me, it's going to be a life sentence. I never lose!"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 13 && p.y == Map.offsety + 11){
            System.out.println(bold()+"Inmate: Hey, if you keep taking my seat at the card table, I'm going to challenge you to a game of 'Monopoly,' and trust me, it's going to be a life sentence. I never lose!"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 13 && p.y == Map.offsety + 13){
            System.out.println(bold()+"Inmate: Whatever he said.."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 15 && p.y == Map.offsety + 13){
            System.out.println(bold()+"Inmate: Whatever he said.."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 14 && p.y == Map.offsety + 14){

            System.out.println(bold()+"Inmate: Whatever he said.."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 5 && p.y == Map.offsety + 14){
            System.out.println(bold()+"Inmate: Huh..?"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 4 && p.y == Map.offsety + 13){
            System.out.println(bold()+"Inmate: Huh..?"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 6 && p.y == Map.offsety + 7){
            System.out.println(bold()+"Inmate: I'm telling you, if they don't bring back the good coffee in the cafeteria, I'm going to organize a protest...just like the French..."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 15 && p.y == Map.offsety + 17){
            System.out.println(bold()+"Inmate: Gimme your shoes"+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 6 && p.y == Map.offsety +13){
            System.out.println(bold()+"Inmate: Huh..?"+unbold());
        }

        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 4 && p.y == Map.offsety + 11){
            System.out.println(bold()+"Inmate: You are not hard."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 6 && p.y == Map.offsety + 11){
            System.out.println(bold()+"Inmate: You are not hard."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 5 && p.y == Map.offsety + 10){
            System.out.println(bold()+"Inmate: You are not hard."+unbold());
        }
        if(colorinputInmate.equals(Main.colorChar('I', 255, 255, 0)) && p.x == Map.offsetx + 5 && p.y == Map.offsety + 10){
            System.out.println(bold()+"Inmate: You are not hard."+unbold());
        }



        if(inputInt == 4 && p.x == 1 && p.y == 10){
            Map.hint1 = "Hint: Check the trashcans for items you can offer to the guard.";
            m.createMapThree(p);
            m.visual();
        }
        if(p.x == Map.offsetx + 16 && p.y == Map.offsety + 16 && interactCount2 == 0){

            interactCount2++;

            System.out.println(bold()+"Guard: You can just drop off the crate right there.\n"+unbold());
            System.out.println(italic()+ "Game: You place the crate."+unitalic());

        }
        return inputChar;
    }

    private static String getInteractCell(int i, String[][] map){
        if(i== 1){
            System.out.println(map[Main.p.x][Main.p.y-1]);
            return map[Main.p.x][Main.p.y-1];
        }
        if(i == 2){
            System.out.println(map[Main.p.x+1][Main.p.y]);
            return map[Main.p.x+1][Main.p.y];
        }
        if(i == 3){
            System.out.println(map[Main.p.x-1][Main.p.y]);
            return map[Main.p.x-1][Main.p.y];
        }
        if(i == 4){
            System.out.println(map[Main.p.x-1][Main.p.y-1]);
            return map[Main.p.x-1][Main.p.y-1];
        }
        return "";
    }

    public static boolean canMove = false;
    public static void movement(String s, Player p, String[][] map){
        System.out.println(map);
        if(!canMove) return;
        if(s.equals("W")||s.equals("w")){
            if(checkUp(p, map)){
                map[p.x][p.y]=". ";
                p.y--;
                map[p.x][p.y]=Main.colorString("P ", 121,251,255);
            }
        }
        else if(s.equals("A")||s.equals("a") ){
            if(checkLeft(p, map)){
                map[p.x][p.y]=". ";
                p.x--;
                map[p.x][p.y]=Main.colorString("P ", 121,251,255);
            }
        }
        else if(s.equals("D")||s.equals("d") ){
            if(checkRight(p, map)){
                map[p.x][p.y]=". ";
                p.x++;
                map[p.x][p.y]=Main.colorString("P ", 121,251,255);
            }
        }
        else if(s.equals("S")||s.equals("s") ){
            if(checkDown(p, map)){
                map[p.x][p.y]=". ";
                p.y++;
                map[p.x][p.y]=Main.colorString("P ", 121,251,251);
            }
        }
        else if(s.length()>1){
            String[] testing = s.split("-");
            if(testing.length != 2) return;
            int steps = Integer.parseInt(testing[1]);
            if(testing[0].equals("W")){
                map[p.x][p.y]=". ";
                int stepP = 0;
                for(int i = p.y; i > p.y-steps; i--, stepP--){
                    if(!map [p.x][i].equals(".")){
                        break;
                    }
                }
                p.y+=stepP+1;
                map[p.x][p.y]=Main.colorString("P ", 121,251,255);
            }
            if(testing[0].equals("A")){
                map[p.x][p.y]=". ";
                int stepP = 0;
                for(int i = p.x; i > p.x-steps; i--, stepP--){
                    if(!map [i][p.y].equals(". ")){
                        break;
                    }
                }
                p.x+=stepP+1;
                map[p.x][p.y]=Main.colorString("P ", 121,251,255);
            }
            if(testing[0].equals("S")){
                map[p.x][p.y]=". ";
                int stepP = 0;
                for(int i = p.y; i < p.y+steps; i++, stepP++){
                    if(!map [p.x][i].equals(". ")){
                        break;
                    }
                }
                p.y+=stepP-1;
                map[p.x][p.y]=Main.colorString("P ", 121,251,255);
            }
            if(testing[0].equals("D") || testing[0].equals("d")){
                map[p.x][p.y]=". ";
                int stepP = 0;
                for(int i = p.x; i < p.x+steps; i++, stepP++){
                    if(!map [i][p.y].equals(". ")){
                        break;
                    }
                }
                p.x+=stepP-1;
                map[p.x][p.y]=Main.colorString("P ", 121,251,255);
            }
        }

    }

    public static void getCommands(String s){
        if(s.equals("Q") || s.equals("q")){
            printCommands();
        }
    }

    public void interact(String s, Character c, boolean b){
        if(s.equals("E") || s.equals("e")){
        }
    }
    public static boolean checkUp(Player p, String [][] map){
        if(map[p.x][p.y-1].equals(". ")){
            return true;
        }
        return false;
    }
    public static boolean checkLeft(Player p, String[][] map){
        if(map[p.x-1][p.y].equals(". ")){
            return true;
        }
        return false;
    }
    public static boolean checkRight(Player p, String[][] map){
        if(map[p.x+1][p.y].equals(". ")){
            return true;
        }
        return false;
    }
    public static boolean checkDown(Player p, String [][] map){
        if(map[p.x][p.y+1].equals(". ")){
            return true;
        }
        return false;
    }
    public static String interactMenu(String input){
        int nInput =Integer.valueOf(input);
        String s = String.valueOf(nInput);
        if(s.length() > 0){

            return itemsNearMe.get(Integer.valueOf(input)-1);
        }

        return "";
    }
    /**public void interact(String s, Item c, boolean b){
     if(s.equals("E")||s.equals("e")){

     }
     }*/

    private static void printCommands(){
        System.out.println("Forward: W");
        System.out.println("Left: A");
        System.out.println("Backwards: S");
        System.out.println("Left: D");
        System.out.println("Interact: E");
        System.out.println("Block: X");
        System.out.println("Attack: J");
        System.out.println("Forward 6 Steps: (W-6)");
    }

}

