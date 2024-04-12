import java.util.*;
public class Inventory{
    public ArrayList<String> myItems;
    public boolean isMyInventory;
    private int myCapacity = 9;
    private void addItem(String item){
        if(myItems.size() < myCapacity){
            myItems.add(item);
        }
    }
}
