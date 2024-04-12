public class Player{
    public int lives;
    public int health;
    public int x, y;
    public Inventory inventory;
    public int likability;
    public boolean canMove;

    public Player(){
        lives = 3;
        health = 100;
        y = 2;
        x = 2;
        inventory = new Inventory();
        likability = 25;
    }
    public Player(int lives, int health, int y, int x, Inventory i){
        this.lives = lives;
        this.health = health;
        this.x = x;
        this.y = y;
        this.inventory = i;
    }
    public void stats(){
        System.out.println("Lives: "+lives+" \n Health: "+health+" \n likability: "+likability+"% \n Map Exposition: "+x+" "+y);
    }

    public void movement(String input){

        if(input.equals("up")){
            if(y == 0) System.out.println("You cannot go up further.");
            else y+=1;
        }
        else if(input.equals("down")){
            if(y == Map.getLength()) System.out.println("You cannot go down further.");
            else y-=1;
        }
        else if(input.equals("right")){
            if(x == Map.getWidth()) System.out.println("You cannot go right further.");
            else x+=1;
        }
        else if(input.equals("left")){
            if(x == 0) System.out.println("You cannot go left further.");
            else x-=1;
        }
    }
    public String colorHealth(){
        if(health <= 25){
            return Main.colorString("Health: "+health+"% ", 255,0,0);
        }
        else if(health <= 50){
            return Main.colorString("Health: "+health+"% ", 255,255,0);
        }
        else if(health <= 100){
            return Main.colorString("Health: "+health+"% ", 0,255,0);
        }
        return "";
    }
    public String colorLives(){
        if(lives == 1){
            return Main.colorString("Lives: "+lives+" ", 255,0,0);
        }
        if(lives == 2){
            return Main.colorString("Lives: "+lives+" ", 255,255,0);
        }
        if(lives == 3){
            return Main.colorString("Lives: "+lives+" ", 0,255,0);
        }
        return "";
    }
}
