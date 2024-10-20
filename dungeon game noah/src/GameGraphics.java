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

public class GameGraphics {

    private boolean isInteract = false;

    Color green = new Color(0,255,0, 65);
    JFrame frame;
    JPanel panel;
    JLabel label = new JLabel(Main.p.x + " " + Main.p.y);
    JLabel label2 = new JLabel("[Backstory]: You are a thief that has \n attempted to steal coins and you got caught. You are now serving time in prison. You have a friend, Doug who is a Prison Guard, he wants you to turn your life around.");
    JLabel label3 = new JLabel("[Doug]: I found a job opportunity for you, It's hauling crates for the Dining Hall. I'm wondering if a thief like you would even consider the position.");
    JPanel tutorial1 = new JPanel();
    BufferedImage prisoner;
    BufferedImage prisonWall;
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

    private int blockSize = 160;
    private int cellSize = 15;

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
                if (Map.mapRep[j][i].equals("\ud83d\udecf️")) {
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
            }
            g.drawImage(prisoner, Main.p.x * blockSize, Main.p.y * blockSize, blockSize, blockSize, null);
        }

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

    public void drawTutorial(Graphics g) throws IOException {
        int xPanelPosition = 40;
        g.drawRect(145-xPanelPosition,100, 400, 650);
        g.setColor(new Color(61, 93, 46));
        g.fillRect(145-xPanelPosition, 100, 400, 650);
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
        g.drawImage(MenuRed, 650, 445, 325,150, null);

    }

    public void start() throws IOException {
        frame = new JFrame("DungeonGame");
        frame.setVisible(true);
        label.setFont(new Font("Sedan", Font.PLAIN, 18));
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

                System.out.print("X Position: ");
                System.out.println(e.getX());

                System.out.print("Y Position: ");
                System.out.println(e.getY());
                if (e.getX() > 451 && e.getX() < 1148 && e.getY() > 346 && e.getY() < 536) {
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
                if (e.getX() > 41 && e.getX() < 105 && e.getY() > 758 && e.getY() < 820) {
                    System.out.println("Back");
                    mainMenuSelector = "main menu";
                    panel.repaint();
                }
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
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    // Your logic for key pressed
                    BasicCommands.movement("s", Main.p);

                }
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    // Your logic for key pressed
                    BasicCommands.movement("w", Main.p);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    // Your logic for key pressed
                    BasicCommands.movement("a", Main.p);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    // Your logic for key pressed
                    BasicCommands.movement("d", Main.p);
                }

                if (e.getKeyCode() == KeyEvent.VK_E) {
                    // Your logic for key pressed
                    isInteract = true;
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_1){
                    BasicCommands.checkItemsNearMe(Main.p);
                    BasicCommands.interactInput("1", Main.p, Main.m);
                    isInteract = false;
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_2){
                    BasicCommands.checkItemsNearMe(Main.p);
                    BasicCommands.interactInput("2", Main.p, Main.m);
                    isInteract = false;
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_3){
                    BasicCommands.checkItemsNearMe(Main.p);
                    BasicCommands.interactInput("3", Main.p, Main.m);
                    isInteract = false;
                }
                if(isInteract && e.getKeyCode() == KeyEvent.VK_4){
                    BasicCommands.checkItemsNearMe(Main.p);
                    BasicCommands.interactInput("4", Main.p, Main.m);
                    isInteract = false;
                }
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
}

