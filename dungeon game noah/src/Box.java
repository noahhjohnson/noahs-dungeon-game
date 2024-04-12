import java.util.Random;
import java.util.ArrayList;
import java.io.* ;

public class Box{

    private ArrayList <String> itemsInside = new ArrayList<>();
    private String[] boxStuff = {"You found a Granola Bar!", "You found nothing!", "You found nothing!", "You found Fruit Snacks!"};
    Random random = new Random();

    private int x;
    private int y;
    private boolean canOpen = true;
    private int cooldownSeconds = 10;
    public Box(int x, int y){
        Map.mapRep[x][y] = unicodeValue();
    }


    public void add(ArrayList <String> s){
        itemsInside.addAll(s);
    }

    public ArrayList <String> boxStuff(){
        ArrayList <String> allItems = new ArrayList<>();
        allItems.add("You found a Piece of Bread!");
        allItems.add("You found an Apple!");
        allItems.add("You found a Carrot!");
        allItems.add("You found nothing!");
        allItems.add("You found nothing!");
        return allItems;
    }

    private void openBox(){
        canOpen = false;
    }

    public static void main(String[] args) {

    }
    public String selectRandomItem(){
        int rand_int1 = random.nextInt(4);
        //System.out.println(itemsInside[rand_int1]);
        return itemsInside.get(rand_int1);
    }
    public String unicodeValue(){
        return "\uD83D\uDDD1 ";

    }
    public void readContents(File f){

        try{
            FileReader fr=new FileReader(f);
            BufferedReader br=new BufferedReader(fr);
            StringBuffer sb=new StringBuffer();

            String line;
            while((line=br.readLine())!=null){
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}