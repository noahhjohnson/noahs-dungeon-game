import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class GameGraphics {

    private boolean isInteract = false;
    public int isInInventory = 0;
    private boolean canInteract = false;
    private boolean dialogueIsShowing = false;

    Color green = new Color(0,255,0, 65);
    JFrame frame;
    JPanel panel;
    JLabel label = new JLabel(Main.p.x + " " + Main.p.y);
    JLabel label2 = new JLabel("[Backstory]: You are a thief that has \n attempted to steal coins and you got caught. You are now serving time in prison. You have a friend, Doug who is a Prison Guard, he wants you to turn your life around.");
    JLabel label3 = new JLabel("[Doug]: I found a job opportunity for you, It's hauling crates for the Dining Hall. I'm wondering if a thief like you would even consider the position.");
    JPanel tutorial1 = new JPanel();
    BufferedImage prisoner;
    BufferedImage prisonWall;
    BufferedImage Trashcan;
    BufferedImage sink;
    BufferedImage door;
    BufferedImage bed;
    BufferedImage floor;
    BufferedImage BlackTitle;
    BufferedImage RedTitle;
    BufferedImage StoneBrickTitle;
    BufferedImage TutBlack;
    BufferedImage TutRed;
    BufferedImage PlayBack;
    BufferedImage PlayBlack;
    BufferedImage PlayRed;
    BufferedImage CobbleBack;
    BufferedImage Table;
    BufferedImage Prisoner1;
    BufferedImage backButton;
    BufferedImage ResumeRed;
    BufferedImage ResumeBlack;
    BufferedImage MenuBlack;
    BufferedImage MenuRed;
    BufferedImage InteractFour;
    BufferedImage InteractThree;
    BufferedImage InteractTwo;
    BufferedImage InteractOne;
    BufferedImage Guard;
    BufferedImage vicinity;
    BufferedImage inventory;
    BufferedImage banana;
    BufferedImage Coin;
    BufferedImage Pencil;
    BufferedImage Screw;
    BufferedImage DuctTape;
    BufferedImage Paper;
    BufferedImage Apple;
    BufferedImage InventoryButton;
    BufferedImage lockedDoor;
    BufferedImage ventCover;
    File ventCoverFile = new File("dungeon game noah/src/ventcover.png");
    File lockedDoorFile = new File("dungeon game noah/src/lockedDoor.png");
    File InventoryButtonFile = new File("dungeon game noah/src/InventoryButton.png");
    File AppleFile = new File("dungeon game noah/src/Apple.png");
    File PaperFile = new File("dungeon game noah/src/Paper.png");
    File DuctTapeFile = new File("dungeon game noah/src/DuctTape.png");
    File ScrewFile =  new File("dungeon game noah/src/Screw.png");

    File PencilFile = new File("dungeon game noah/src/Pencil.png");
    File CoinFile = new File("dungeon game noah/src/Coin.png");
    File bananaFile = new File("dungeon game noah/src/banana.png");
    File inventoryFile = new File("dungeon game noah/src/Inventory.png");
    File vicinityFile = new File("dungeon game noah/src/Vicinity.png");

    File TrashcanFile = new File("dungeon game noah/src/Trashcan.png");
    File GuardFile = new File("dungeon game noah/src/Riot_guard.png");
    File InteractFourFile = new File("dungeon game noah/src/InteractFour.png");
    File InteractThreeFile = new File("dungeon game noah/src/InteractThree.png");
    File InteractTwoFile = new File("dungeon game noah/src/InteractTwo.png");
    File InteractOneFile = new File("dungeon game noah/src/InteractOne.png");
    File ResumeBlackFile = new File("dungeon game noah/src/ResumeBlack.png");
    File MenuRedFile = new File("dungeon game noah/src/MenuRed.png");
    File MenuBlackFile = new File("dungeon game noah/src/MenuBlack.png");
    File ResumeRedFile = new File("dungeon game noah/src/ResumeRed.png");
    File Prisoner1File = new File("dungeon game noah/src/Prisoner1.png");
    File backButtonFile = new File("dungeon game noah/src/backButton.png");
    File TableFile = new File("dungeon game noah/src/Table.png");
    File PrisonFloorFile = new File("dungeon game noah/src/PrisonFloorTiles.png");
    File prisonerFile = new File("dungeon game noah/src/Prisoner.png");
    File PWallFile = new File("dungeon game noah/src/PrisonWall.png");
    File bedFile = new File("dungeon game noah/src/Bed.png");
    File sinkFile = new File("dungeon game noah/src/Sink.png");
    File doorFile = new File("dungeon game noah/src/PrisonDoor.png");
    File TitleBlackFile = new File("dungeon game noah/src/TitleBlack.png");
    File TitleRedFile = new File("dungeon game noah/src/TitleRed.png");
    File StoneBrickFile = new File("dungeon game noah/src/StoneBrickTitle.jpg");
    File TutBlackFile = new File("dungeon game noah/src/TutBlack.png");
    File TutRedFile = new File("dungeon game noah/src/TutRed.png");
    File PlayBackFile = new File("dungeon game noah/src/PlayBack.png");
    File PlayBlackFile = new File("dungeon game noah/src/PlayBlack.png");
    File PlayRedFile = new File("dungeon game noah/src/PlayRed.png");
    File CobbleBackFile = new File("dungeon game noah/src/CobbleBack.png");

    private String mainMenuSelector = "main menu";
    public static boolean doorOnOff = true;
    //True = Closed
    //False = Open

    private int blockSize = 160;
    private int cellSize = 15;

    public boolean inventoryChecker = false;

    public GameGraphics() throws IOException, FontFormatException {
    }

    public void drawMap(Graphics g) throws IOException {
        if (Map.map == 2) {
            blockSize = 40;
        }
        prisonWall = ImageIO.read(PWallFile);
        prisoner = ImageIO.read(prisonerFile);
        door = ImageIO.read(doorFile);
        bed = ImageIO.read(bedFile);
        sink = ImageIO.read(sinkFile);
        floor = ImageIO.read(PrisonFloorFile);
        Table = ImageIO.read(TableFile);
        Prisoner1 = ImageIO.read(Prisoner1File);
        Guard = ImageIO.read(GuardFile);
        Trashcan = ImageIO.read(TrashcanFile);
        lockedDoor = ImageIO.read(lockedDoorFile);
        ventCover = ImageIO.read(ventCoverFile);


        for (int i = 0; i < Map.mapRep.length; i++) {
            for (int j = 0; j < Map.mapRep.length; j++) {
                g.drawImage(floor, j * blockSize, i * blockSize, blockSize, blockSize, null);
            }
        }
        for (int i = 0; i < Map.mapRep.length; i++) {
            for (int j = 0; j < Map.mapRep.length; j++) {
                if (Map.mapRep[j][i].equals("W ")) {
                    g.drawImage(prisonWall, j * blockSize, i * blockSize, blockSize, blockSize, null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\udecf\ufe0f")) {
                    g.drawImage(bed, j * blockSize, i * blockSize, blockSize, blockSize, null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\udebf")) {
                    g.drawImage(sink, (j * blockSize), (i * blockSize), blockSize, blockSize, null);
                }
                if (Map.mapRep[j][i].equals("\uD83D\udeaa")) {
                    g.drawImage(door, j * blockSize, i * blockSize, blockSize, blockSize, null);
                }
                if (Map.mapRep[j][i].equals("T ")){
                    g.drawImage(Table, j * blockSize, i * blockSize, blockSize, blockSize, null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\ude4d")) {
                    g.drawImage(Prisoner1, j * blockSize, i * blockSize, blockSize, blockSize, null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\udc6e")) {
                    g.drawImage(Guard, j * blockSize, i * blockSize, blockSize, blockSize, null);
                }
                if(Map.mapRep[j][i].equals("R ")) {
                    g.drawImage(Trashcan, j * blockSize, i * blockSize, blockSize, blockSize, null);
                }
                if(Map.mapRep[j][i].equals("L ") && doorOnOff == true) {
                    g.drawImage(lockedDoor, j * blockSize-35, i *blockSize-10, blockSize+69, blockSize+25, null);
                    //
                }
            }
            g.drawImage(prisoner, Main.p.x * blockSize, Main.p.y * blockSize, blockSize, blockSize, null);
        }

        if(Map.map ==3){
            g.drawImage(ventCover, 40, 600, 40,40,null);
        }


        if(doorOnOff == true && Map.map == 3){
            g.setColor( new Color(0,0,0, 240));
            g.fillRect(40,600,160,160);
        }

    }



    public void drawInventoryItems(Graphics g) throws IOException {
        System.out.println("hello world! " + Main.p.x + Main.p.y);
        banana = ImageIO.read(bananaFile);
        Coin = ImageIO.read(CoinFile);
        Paper = ImageIO.read(PaperFile);
        Pencil = ImageIO.read(PencilFile);
        DuctTape = ImageIO.read(DuctTapeFile);
        Screw = ImageIO.read(ScrewFile);
        Apple = ImageIO.read(AppleFile);



        for(String s: Inventory.myItems){
            //System.out.println(s+"ohasd");
            //g.drawImage(ImageIO.read(new File("dungeon game noah/src/"+s+".png")),800, 150, 100, 100,null );
        }

        if(nearTrashcan.isNearBottomRight())displayItemsInTrashcan(g, Map.bbottomRight);
        if(nearTrashcan.isNearTopRight())displayItemsInTrashcan(g, Map.btopRight);
        if(nearTrashcan.isNearTopLeft())displayItemsInTrashcan(g, Map.btopLeft);


        drawItemsFromInventory(g);
        panel.repaint();

    }

    public void drawMainMenu(Graphics g) throws IOException {
        RedTitle = ImageIO.read(TitleRedFile);
        BlackTitle = ImageIO.read(TitleBlackFile);
        StoneBrickTitle = ImageIO.read(StoneBrickFile);
        TutRed = ImageIO.read(TutRedFile);
        TutBlack = ImageIO.read(TutBlackFile);
        PlayBack = ImageIO.read(PlayBackFile);
        PlayBlack = ImageIO.read(PlayBlackFile);
        PlayRed = ImageIO.read(PlayRedFile);
        CobbleBack = ImageIO.read(CobbleBackFile);
        backButton = ImageIO.read(backButtonFile);
        vicinity = ImageIO.read(vicinityFile);
        inventory = ImageIO.read(inventoryFile);
        InventoryButton = ImageIO.read(InventoryButtonFile);
        g.setColor(new Color(61,93,46));
        g.fillRect(0,0, 1600, 1000);
        g.setColor(new Color(0,0,0));
        g.drawRect(450, 70, 700, 200);
        g.drawRect(450, 70, 700, 200);
        g.drawRect(450, 70, 700, 200);
        g.drawRect(450, 70, 700, 200);
        g.drawImage(StoneBrickTitle, 450, 70, 700, 200, null);
        g.setColor(new Color(61, 93, 46, 125));
        g.fillRect(450, 70, 700, 200);
        g.drawImage(BlackTitle, 475, 105, null);
        g.drawImage(RedTitle, 475, 110, null);
        g.drawImage(PlayBack, 450, 345, null);
        g.drawImage(PlayBack, 710, 345, null);
        g.drawImage(PlayBack, 890, 345, null);
        g.drawImage(PlayBlack, 715, 368, null);
        g.drawImage(PlayRed, 695, 383, null);
        g.drawImage(CobbleBack, 450, 600, 260,165, null);
        g.drawImage(CobbleBack, 710, 600, 260,165, null);
        g.drawImage(CobbleBack, 970, 600, 180,165, null);
        g.drawImage(TutBlack, 640, 615, null);
        g.drawImage(TutRed, 630, 625, null);
    }

    public void drawInventory(Graphics g) throws IOException {
        g.setColor(new Color(0,0,0, 215));
        g.fillRect(0, 0, 1600, 1600);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.WHITE);

        g.drawImage(inventory, 115, 635, 200, 100, null);
        g.drawImage(vicinity, 920, 18, 200,100, null);
        g.drawImage(prisoner, 275, 80, 200,200, null);
        g.drawImage(InventoryButton, 1300, 650, 150,150,null);

            g2d.setColor(Color.WHITE);
        // Player Inventory
        for (int i = 1; i < 5; i++) {
          g.drawRect(100*i, 315, 200,200);
        }
        for (int i =1; i < 5; i++) {
           g.drawRect(100*i, 415, 200,200);
        }
        // Vicinity
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                g.drawRect((100*i)+800, (100*j)+15, 100, 100);
            }
        }
        drawInventoryItems(g);
    }

    public void drawTutorial(Graphics g) throws IOException {
        int xPanelPosition = 40;
        g.drawRect(145-xPanelPosition,100, 400, 650);
        g.setColor(new Color(61, 93, 46));
        g.fillRect(145-xPanelPosition, 100, 400, 650);
        g.setColor(new Color(255,50,50));
        Font font = new Font("Serif", Font.BOLD, 40);
        g.setFont(font);
        g.drawString("Controls", 225, 152);
        g.drawLine(160, 160, 430, 160);
        Font font1 = new Font("Serif", Font.CENTER_BASELINE, 19);
        g.setFont(font1);
        g.setColor(new Color(10, 20,30));
        g.drawString("Movement:", 145, 200);
        g.setColor(new Color(255,255,255));
        g.drawString("W - Move Up", 145, 220);
        g.drawString("A - Move Left", 145, 240);
        g.drawString("S - Move Down", 145, 260);
        g.drawString("D - Move Right", 145, 280);
        g.setColor(new Color(10, 20,30));
        g.drawString("Interact:", 145, 320);
        g.setColor(new Color(255,255,255));
        g.drawString("E - Interact Menu", 145, 340);
        g.drawString("1 - Interact Up", 145, 360);
        g.drawString("2 - Interatct Right", 145, 380);
        g.drawString("3 - Interact Down", 145, 400);
        g.drawString("4 - Interact Left", 145, 420);
        g.setColor(new Color(10, 20,30));
        g.drawString("Pause Game - M", 145, 460
        );

        //-
        g.drawRect(650-xPanelPosition, 100,400, 650);
        g.setColor(new Color(61, 93, 46));
        g.fillRect(650-xPanelPosition, 100, 400, 650);
        //-
        g.drawRect(1150-xPanelPosition,100, 400, 650);
        g.setColor(new Color(61, 93, 46));
        g.fillRect(1150-xPanelPosition, 100, 400, 650);

        g.drawImage(backButton, 25,740, 100,100, null);
    }

    public void drawPause(Graphics g) throws IOException {

        g.setColor(new Color(61, 93, 46));
        g.fillRect(570, 212, 1055-570, 663-212);
        StoneBrickTitle = ImageIO.read(StoneBrickFile);
        PlayBack = ImageIO.read(PlayBackFile);
        ResumeRed = ImageIO.read(ResumeRedFile);
        ResumeBlack = ImageIO.read(ResumeBlackFile);
        MenuBlack = ImageIO.read(MenuBlackFile);
        MenuRed = ImageIO.read(MenuRedFile);
        g.drawImage(StoneBrickTitle, 650, 267, 325, 150, null);
        g.drawImage(PlayBack, 650, 450, 325, 150, null);
        g.setColor(new Color(61, 93, 46, 125));
        g.fillRect(650, 267, 325, 150);
        g.fillRect( 650, 450, 325, 150);
        g.drawImage(ResumeBlack, 675, 275, 300, 150, null);
        g.drawImage(ResumeRed, 665, 287, 300, 150, null);
        g.drawImage(MenuBlack, 665, 433, 325, 150, null);
        g.drawImage(MenuRed, 650, 445, 325,150, null);


    }

    public void start() throws IOException {
        frame = new JFrame("DungeonGame");
        frame.setVisible(true);
        label.setFont(new Font("Sedan", Font.PLAIN, 18));

        InteractFour = ImageIO.read(InteractFourFile);
        InteractThree = ImageIO.read(InteractThreeFile);
        InteractTwo = ImageIO.read(InteractTwoFile);
        InteractOne = ImageIO.read(InteractOneFile);
        panel = new JPanel(null) {

            // 0 = Main Menu, 1 = The Game, 2  Pause Menu
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    if(mainMenuSelector.equals("main menu")){
                        drawMainMenu(g);
                    }

                    if(mainMenuSelector.equals("Play")){
                        drawMap(g);
                       if(isInteract){
                               //dialogueBox("hi", g);
                               System.out.println("");
                       }
                    }

                    if(mainMenuSelector.equals("Tutorial")){
                        drawTutorial(g);
                    }
                    if(isInteract){

                        g.setColor(green);
                        g.fillRect(Main.p.x * blockSize,(Main.p.y * blockSize) - blockSize, blockSize, blockSize);
                        g.fillRect(Main.p.x * blockSize,(Main.p.y * blockSize) + blockSize, blockSize, blockSize);
                        g.fillRect((Main.p.x * blockSize) - blockSize, (Main.p.y * blockSize), blockSize, blockSize);
                        g.fillRect((Main.p.x * blockSize) + blockSize, (Main.p.y * blockSize), blockSize, blockSize);
                        g.drawImage(InteractOne, Main.p.x * blockSize, (Main.p.y * blockSize) - blockSize, blockSize, blockSize, null);
                        g.drawImage(InteractThree, Main.p.x * blockSize, (Main.p.y * blockSize) + blockSize, blockSize, blockSize, null);
                        g.drawImage(InteractTwo, (Main.p.x * blockSize) + blockSize, (Main.p.y * blockSize), blockSize, blockSize, null);
                        g.drawImage(InteractFour, (Main.p.x * blockSize) - blockSize, (Main.p.y * blockSize), blockSize, blockSize, null);
                    }
                    if(mainMenuSelector.equals("Pause Menu")){
                        drawPause(g);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                label.setText(Main.p.x + " " + Main.p.y);
                label2.setText("<html> [Backstory]: You are a thief that has attempted to steal coins and you got caught. You are now serving time in prison. <br/> You have a friend, Doug who is a Prison Guard, he wants you to turn your life around. </html>");
                label3.setText("<html> [Doug]: I found a job opportunity for you, It's hauling crates for the Dining Hall. <br/> I'm wondering if a theif like you would even consider the position. </html>");

                if(dialogueIsShowing) {
                    System.out.println(Main.p.x + ", " + Main.p.y);

                    if (Main.p.x == 18 && Main.p.y == 6 ||
                            Main.p.x == 17 && Main.p.y == 5) {
                        dialogueBox("Depressed Guy: Just leave me alone...", g, "\ud83d\ude4d");
                    }
                    if (Main.p.x == 15 && Main.p.y == 7 ||
                            Main.p.x == 14 && Main.p.y == 6 ||
                            Main.p.x == 13 && Main.p.y == 7) {
                        dialogueBox("Prisoner: Gimme your shoes.", g, "\ud83d\ude4d");
                    }
                    if (Main.p.x == 6 && Main.p.y == 7 ||
                            Main.p.x == 6 && Main.p.y == 6 ||
                            Main.p.x == 5 && Main.p.y == 6 ||
                            Main.p.x == 4 && Main.p.y == 7) {
                        dialogueBox("Prisoner: I'm telling you, they need to bring back the good coffee in the chow hall.   ", g, "\ud83d\ude4d");
                    }
                    if(Main.p.x == 5  && Main.p.y == 10 ||
                            Main.p.x == 6 && Main.p.y == 11 ||
                            Main.p.x == 4 && Main.p.y == 11){
                        dialogueBox("Prisoner: You are not hard.", g, "\ud83d\ude4d");
                    }
                    if(Main.p.x == 13  && Main.p.y == 11 ||
                            Main.p.x == 14 && Main.p.y == 10 ||
                            Main.p.x == 15 && Main.p.y == 11) {
                        dialogueBox("Prisoner: Hey, if you keep taking my seat at the card table, I'll take your lunch money.", g, "\ud83d\ude4d");
                    }
                    if(Main.p.x == 15 && Main.p.y == 13 ||
                            Main.p.x == 14 && Main.p.y == 14 ||
                            Main.p.x == 13 && Main.p.y == 13) {
                        dialogueBox("Prisoner: Whatever he said..", g, "\ud83d\ude4d");
                    }
                    if(Main.p.x == 6 && Main.p.y == 13 ||
                            Main.p.x == 5 && Main.p.y == 14 ||
                            Main.p.x == 4 && Main.p.y == 13) {
                        dialogueBox("Prisoner: Huh..?", g, "\ud83d\ude4d");
                    }
                    if(Main.p.x == 2 && Main.p.y == 15 ||
                            Main.p.x == 3 && Main.p.y == 16 ||
                            Main.p.x == 2 && Main.p.y == 17 ||
                            Main.p.x == 1 && Main.p.y == 16){
                        dialogueBox("Guard: What you lookin' at?", g, "\ud83d\udc6e");
                    }
                    if(Main.p.x == 16 && Main.p.y == 16 ||
                            Main.p.x == 17 && Main.p.y == 15 ||
                            Main.p.x == 18 && Main.p.y == 16 ||
                            Main.p.x == 17 && Main.p.y == 17){
                        dialogueBox("Guard: Get outta here.", g, "\ud83d\udc6e");
                    }
                }
                if(isInInventory > 0){
                    try {
                        drawInventory(g);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(isInInventory);

                }
            }

        };

        //panel.add(label);
        //panel.add(label2);
        //panel.add(label3);
        label.setBounds(1550, 2, 100, 100);
        label2.setBounds(850, 15, 7000, 100);
        label3.setBounds(850, 50, 7000, 100);

        panel.setPreferredSize(new Dimension(300, 200));
        frame.add(panel);
        frame.pack();

        // Adding KeyListener to the panel
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(isInInventory > 0){
                    System.out.println("hello world");
                }

                System.out.print("X Position: ");
                System.out.println(e.getX());

                System.out.print("Y Position: ");
                System.out.println(e.getY());
                if (e.getX() > 450 && e.getX() < 1149 && e.getY() > 344 && e.getY() < 534) {
                    System.out.println("Play");
                    mainMenuSelector = "Play";
                    System.out.println(mainMenuSelector);
                    panel.repaint();
                }
                if (e.getX() > 451 && e.getX() < 1148 && e.getY() > 599 && e.getY() < 763) {
                    System.out.println("Tutorial");
                    mainMenuSelector = "Tutorial";
                    panel.repaint();
                }
                if (e.getX() > 651 && e.getX() < 974 && e.getY() > 449 && e.getY() < 599) {
                    System.out.println("Pause Back");
                    mainMenuSelector = "main menu";
                    panel.repaint();
                }
                if (e.getX() > 43 && e.getX() < 104 && e.getY() > 759 && e.getY() < 821) {
                    System.out.println("Tutorial Back");
                    mainMenuSelector = "main menu";
                    panel.repaint();
                }
                if (e.getX() > 903 && e.getX() < 1400 && e.getY() > 151 && e.getY() < 648) {
                    System.out.println("great");
                    panel.repaint();
                }
                if (e.getX() > 1329 && e.getX() < 1421 && e.getY() > 679 && e.getY() < 771){
                    isInInventory = 0;
                    panel.repaint();
                }

                //System.out.println(Map.bbottomRight.getItem((int)Math.floor((e.getX()-900)/100) + ((int)Math.floor((e.getY()-120)/100)*5)));
                Map.bbottomRight.printItemsInBox();
                Inventory.printItems();

                if(nearTrashcan.isNearBottomRight())itemMover((int)Math.floor((e.getX()-900)/100) + ((int)Math.floor((e.getY()-120)/100)*5), Map.bbottomRight);
                if(nearTrashcan.isNearTopRight())itemMover((int)Math.floor((e.getX()-900)/100) + ((int)Math.floor((e.getY()-120)/100)*5), Map.btopRight);
                if(nearTrashcan.isNearTopLeft())itemMover((int)Math.floor((e.getX()-900)/100) + ((int)Math.floor((e.getY()-120)/100)*5), Map.btopLeft);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'g' || e.getKeyChar() == 'G') {
                    if(isInInventory == 0) {
                        isInInventory ++;
                    }
                    else if(isInInventory > 0) {
                        isInInventory = 0;
                    }
                    System.out.println(isInInventory + " dog");
                }
            }

            private void checkToOpenInventory(int v){
                if(BasicCommands.itemsNearMe.get(v).equals("R ")){
                    isInInventory = 1;
                    System.out.println("adas");
                    panel.repaint();
                }
            }

            private void handleOpeningInventory(int v, String s){
                BasicCommands.checkItemsNearMe(Main.p);
                BasicCommands.interactInput(s, Main.p, Main.m);
                if (BasicCommands.itemsNearMe.get(v).equals("\ud83d\ude4d") || BasicCommands.itemsNearMe.get(v).equals("\ud83d\udc6e")){
                    dialogueIsShowing = true;
                }
                checkToOpenInventory(v);
                isInteract = false;
            }


            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    // Your logic for key pressed
                    BasicCommands.movement("s", Main.p);
                    dialogueIsShowing = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    // Your logic for key pressed
                    BasicCommands.movement("w", Main.p);
                    dialogueIsShowing = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    // Your logic for key pressed
                    BasicCommands.movement("a", Main.p);
                    dialogueIsShowing = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    // Your logic for key pressed
                    BasicCommands.movement("d", Main.p);
                    dialogueIsShowing = false;
                }


                if (e.getKeyCode() == KeyEvent.VK_E) {
                    //System.out.println("oahsds");
                    //isInteract = true;
                    // Your logic for key pressed
                    BasicCommands.checkItemsNearMe(Main.p);
                    for(int i = 0; i < 4; i++){
                        System.out.print("["+i+"] ");
                        if(BasicCommands.itemsNearMe.size() == 0){
                            return;
                        }
                        System.out.println(BasicCommands.itemsNearMe.get(i));
                        if (!BasicCommands.itemsNearMe.get(i).equals(". ")) {
                            isInteract = true;
                            //break;
                        }
                        //System.out.println(isInteract);
                    }
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_1){
                    handleOpeningInventory(0,"1");
                }

                if(isInteract && e.getKeyCode() == KeyEvent.VK_2) {
                    handleOpeningInventory(1,"2");
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_3) {
                    handleOpeningInventory(2,"3");
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_4) {
                    handleOpeningInventory(3,"4");
                }

                /*if(isInteract && e.getKeyCode() == KeyEvent.VK_2){
                    BasicCommands.checkItemsNearMe(Main.p);
                    BasicCommands.interactInput("2", Main.p, Main.m);
                    isInteract = false;
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_3){
                    BasicCommands.checkItemsNearMe(Main.p);
                    char v = BasicCommands.interactInput("3", Main.p, Main.m);

                    isInteract = false;
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_4){
                    BasicCommands.checkItemsNearMe(Main.p);
                     BasicCommands.interactInput("4", Main.p, Main.m);
                     BasicCommands.interactInput("4", Main.p, Main.m);


                    isInteract = false;
                }*/
                if(e.getKeyCode() == KeyEvent.VK_M){
                    mainMenuSelector = "Pause Menu";
                }

                panel.repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        // Setting focus on the panel
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }

    private void dialogueBox(String s, Graphics g, String unicode){
        g.setColor(new Color(210, 210, 210));
        g.fillRect(0,556, 2000, 270);
        Font font = new Font("Serif", Font.BOLD, 25);
        g.setFont(font);

        // Draw some text
        g.setColor(Color.BLACK);
        g.drawString(s, 210, 645); // Draw text at position (50, 100)
        if(Objects.equals(unicode, "\ud83d\udc6e")){
            g.drawImage(Guard,-10, 610, 250, 200, null);
        }
        if(Objects.equals(unicode, "\ud83d\ude4d")){
            g.drawImage(Prisoner1, -40, 610, 300, 200, null);
        }

    }

    public void displayItemsInTrashcan(Graphics g, Box b) throws IOException {
        for(int i = 0; i < b.manyItems(); i++){
            g.drawImage(itemToFile(b.getItem(i)), (i*100)+900, 125, 100,80, null);
        }
    }

    private BufferedImage itemToFile(String item) throws IOException {
        return ImageIO.read(new File("dungeon game noah/src/"+item + ".png"));
    }

    public void drawItemsFromInventory(Graphics g) throws IOException {
        for(int i =0; i < Inventory.myItems.size()-1; i++){
            g.drawImage(itemToFile(Inventory.myItems.get((Inventory.myItems.size()-1)-i)), 105+(100*(i%5)),325+(int)((i/5)*100),100,80,null);
        }
    }

    public void itemMover(int itemsIndex, Box b){
        Inventory.myItems.add(b.getItem(itemsIndex));
        b.remove(itemsIndex);
    }

    /*
    This allows us to translate from a list index to an x and y coordinate for the inventory.
     */
    public static void printOutput(int input){
        int firstValue = input / 6;
        int secondValue = input % 6;
        System.out.println(firstValue + ", " + secondValue);
    }
}

