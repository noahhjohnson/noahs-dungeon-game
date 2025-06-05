import java.io.IOException;

public class Map{

    public static String [][] mapRep;
    public static String[][] areaTwo;
    public static String[][] currentMap = mapRep;
    public String day;
    public int hour;
    public static int map = 1;
    public static int offsetx;
    public static int offsety;

    public static Box btopRight;
    public static Box btopLeft;
    public static Box bbottomRight;

    public static String hint1 = "Hint: Check the trashcans for items you can offer to the guard.";


    public Map (int x, int y){
        offsetx = offsety = 0;
        mapRep = new String [x][y];
        day = "Sunday";
        hour = 21;
    }
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
    public static int getWidth(){
        return mapRep[0].length;
    }

    public static int getLength(){
        return mapRep.length;
    }

    public void visual(){
        //if(Main.printFirstSeperator)System.out.println("----------------------");
        Main.clearScreen();
        for(int y = 0; y<= getLength()-1;y++){
            for(int x = 0; x<=getWidth()-1;x++){
                System.out.print(mapRep[x][y]);

            }
            if(y==0)System.out.print("  "+Main.p.x+" "+Main.p.y);
            if(y==1)System.out.print("  S = Sink");
            if(y==2)System.out.print("  B = Bed");
            if(y==3)System.out.print("  D = Door");
            if(y==4)System.out.print("  W = Wall");
            if(y==5)System.out.print("  P = Player");
            if(y==6)System.out.print("  T = Table");
            if(y==7)System.out.print("  G = Guard");
            if(y==8)System.out.print("  I = Inmate");
            if(y==9)System.out.print("  ");
            if(y==10)System.out.print("  " + Main.p.colorHealth());
            if(y==11)System.out.print("  " + Main.p.colorLives());
            if(y==16)System.out.print("  "+hint1);
            if(y==20)System.out.print("  Inventory:");



            System.out.println();

        }
        System.out.println("---------------");
        Main.printFirstSeperator = true;
    }

    public void createMapOne() throws IOException {
        for(int y = 0; y<=getLength()-1;y++){
            for(int x = 0; x<=getWidth()-1;x++){
                if(x==0||y==0|| x==getWidth()-1|| y==getLength()-1){
                    mapRep[x][y]="W ";
                    if(x==2 && y==4){
                        mapRep[x][y]=Main.colorString("D", 255,255,0);
                    }
                }
                else if(x==2 && y==2){
                    mapRep[x][y]=Main.colorString("P ", 121,251,255);
                }
                else mapRep[x][y]=". ";
            }
        }
        emojiPlacerOne();


    }
    public void createMapTwo(Player p){
        map++;
        p.x+=8;
        mapRep = new String[20][20];
        currentMap = mapRep;
        for(int y = 0; y<=getWidth()-1;y++){
            for(int x = 0; x<=getLength()-1;x++){
                if(x==0+8||x==12||y==0|| x==getWidth()-1|| y==4){
                    if(y<=4){
                        mapRep[x][y]="W ";
                    }
                    else{
                        mapRep[x][y] = ". ";
                    }
                    if(x==2+8 && y==4){
                        mapRep[x][y]="D";
                    }

                }
                else if(x==1+8 && y==1){
                    mapRep[x][y]="\ud83d\udecf\ufe0f";
                }
                else if(x==3+8 && y==1){
                    mapRep[x][y]=Main.colorString("S", 255,255,0);
                }
                else mapRep[x][y]=". ";
                mapRep[10][4]=". ";
                mapRep[p.x][p.y] =Main.colorString("P", 121,251,255);
                for(int i=0; i<20; i++){
                    mapRep[i][19] = "W ";
                }
                for(int i=0; i<20; i++){
                    mapRep[19][i] = "W ";
                    mapRep[0][i] = "W ";
                }
                if(x==5 && y==8){
                    mapRep[x][y] = "T ";
                }
                if(x==6 && y==8){
                    mapRep[x][y] = "T ";
                }
                if(x==4 && y==8){
                    mapRep[x][y] = "T ";
                }
                if(x==13 && y==8){
                    mapRep[x][y] = "T ";
                }
                if(x==15 && y==8){
                    mapRep[x][y] = "T ";
                }
                if(x==14 && y==8){
                    mapRep[x][y] = "T ";
                }
                if(x==14 && y==12){
                    mapRep[x][y] = "T ";
                }
                if(x==13 && y==12){
                    mapRep[x][y] = "T ";
                }
                if(x==15 && y==12){
                    mapRep[x][y] = "T ";
                }
                if(x==4 && y==12){
                    mapRep[x][y] = "T ";
                }
                if(x==5 && y==12){
                    mapRep[x][y] = "T ";
                }
                if(x==6 && y==12){
                    mapRep[x][y] = "T ";
                }
                if(x==5 && y==7){
                    mapRep[x][y] =Main.colorString("I ", 255,255,0);
                }
                if(x==14 && y==7){
                    mapRep[x][y] =Main.colorString("I ", 255,255,0);
                }
                if(x==14 && y==11){
                    mapRep[x][y] =Main.colorString("I ", 255,255,0);
                }
                if(x==5 && y==11){
                    mapRep[x][y] =Main.colorString("I ", 255,255,0);
                }
                if(x==14 && y==13){
                    mapRep[x][y] =Main.colorString("I ", 255,255,0);
                }
                if(x==5 && y==13){
                    mapRep[x][y] =Main.colorString("I ", 255,255,0);
                }
                if(x==18 && y==5){
                    mapRep[x][y] =Main.colorString("I ", 255,255,0);
                }
                if(x==2 && y==16){
                    mapRep[x][y] =Main.colorString("G", 255,255,0);
                }
                if(x==17 && y==16){
                    mapRep[x][y] =Main.colorString("G", 255,255,0);
                }

                mapRep[0][10]=Main.colorString("D", 255,255,0);
                emojiPlacerTwo();
            }
        }
    }
    public void createMapThree(Player p){
        map++;
        String[][] placeHolder = mapRep;
        mapRep = new String[40][40];
        currentMap = mapRep;
        offsetx = 20;
        System.out.println(getLength()+" "+getWidth());
        for(int y = 0; y<=getLength()-1;y++){
            for(int x = 0; x<=getWidth()-1;x++){
                mapRep[x][y] = ". ";
            }
            System.out.print(y+" ");
        }
        place2DArray(placeHolder, mapRep, 0, 20);

        p.x = 21;
        p.y = 10;
        mapRep[20][10]=". ";
        mapRep[21][10]= Main.colorString("P ", 0,255,255);
        emojiPlacerThree();
        for(int i = 0; i<=39; i++){
            mapRep[0][i] = "W ";
            mapRep[39][i] = "W ";
        }
        for(int i = 0; i<=39; i++){
            mapRep[i][0] = "W ";
            mapRep[i][19] = "W ";
            mapRep[i][39] = "W ";
        }
        for(int i = 15; i<=19; i++){
            mapRep[5][i] = "W ";
        }
        for(int i = 1; i<=5; i++){
            mapRep[i][14] = "W ";
        }

        mapRep[3][14] = "L ";
        mapRep[1][15] = "V ";
    }

    public static String[][] place2DArray(String[][] smallerArr, String[][] largerArr, int x, int y){
        for(int i=y; i<=y+smallerArr.length-1; i++){
            for(int j=x; j<=x+smallerArr.length-1; j++){
                largerArr[i][j] = smallerArr[i-y][j-x];
            }
        }
        return largerArr;
    }
    public static void emojiPlacerThree(){

        btopRight = new Box(14,3);
        btopLeft = new Box(5,3);
        bbottomRight = new Box(15, 14);
        mapRep[5][14] = "\ud83d\udc6e"; // Police Officer
        mapRep[11][19] = "\ud83d\udeaa"; // Door
        mapRep[4][14] = "\ud83d\udd11"; // Key
    }
    public static void emojiPlacerTwo(){


        mapRep[0][10] = "\ud83d\udeaa"; // Door
        mapRep[11][1] = "\ud83d\udebf"; // Sink
        mapRep[17][16] = "\ud83d\udc6e"; // Police Officer
        mapRep[2][16] = "\ud83d\udc6e"; // Police Officer
        mapRep[5][7] = "\ud83d\ude4d";  // Inmate
        mapRep[14][7] = "\ud83d\ude4d"; // Inmate
        mapRep[14][11] = "\ud83d\ude4d"; // Inmate
        mapRep[14][13] = "\ud83d\ude4d"; // Inmate
        mapRep[5][13] = "\ud83d\ude4d"; // Inmate
        mapRep[5][11] = "\ud83d\ude4d"; // Inmate
        mapRep[18][5] = "\ud83d\ude4d"; // Inmate
    }
    public static void emojiPlacerOne(){

        mapRep[2][4] = "\uD83D\udeaa"; // Door
        mapRep[3][1] = "\ud83d\udebf"; // Sink
        mapRep[1][1] = "\ud83d\udecf\ufe0f"; // Bed


    }

    public static void drawAreaTwo(Player p){
        areaTwo = new String[7][6];
        for(int y = 0; y<= areaTwo.length-1;y++){
            for(int x = 0; x<=areaTwo[y].length-1;x++){
                areaTwo[y][x] = ". ";
                if(x == 0 || x == areaTwo[y].length-1 || y == 0 || y == areaTwo.length-1){
                    areaTwo[y][x] = "W ";
                }
            }

        }

    }




}
