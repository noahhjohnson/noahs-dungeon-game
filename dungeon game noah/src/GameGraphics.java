import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
    BufferedImage pUp;
    BufferedImage PrisonerSprite;
    BufferedImage player;
    BufferedImage prisonWall;
    BufferedImage sink;
    BufferedImage door;
    BufferedImage bed;
    BufferedImage floor;
    File pUpFile;
    File PrisonFloorFile = new File("dungeon game noah/src/PrisonFloorTiles.png");
    File playerFile = new File("dungeon game noah/src/PrisonerSprite.png");
    File PWallFile = new File("dungeon game noah/src/PrisonWall.png");
    File bedFile = new File("dungeon game noah/src/Bed.png");
    File sinkFile = new File("dungeon game noah/src/Sink.png");
    File doorFile = new File("dungeon game noah/src/PrisonDoor.png");

    private int blockSize = 160;
    private int cellSize = 15;

    public GameGraphics() throws IOException, FontFormatException {
    }

    public void drawMap(Graphics g) throws IOException {
        if (Map.map == 2) {
            blockSize = 40;
        }
        prisonWall = ImageIO.read(PWallFile);
        player = ImageIO.read(playerFile);
        door = ImageIO.read(doorFile);
        bed = ImageIO.read(bedFile);
        sink = ImageIO.read(sinkFile);
        floor = ImageIO.read(PrisonFloorFile);

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
            }
            g.drawImage(player, Main.p.x * blockSize, Main.p.y * blockSize, blockSize, blockSize, null);
        }

    }

    public void start() throws IOException {
        frame = new JFrame("DungeonGame");
        frame.setVisible(true);
        label.setFont(new Font("Sedan", Font.PLAIN, 18));
        panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    drawMap(g);
                    if(isInteract){
                        g.setColor(green);
                        g.fillRect(Main.p.x * blockSize,(Main.p.y * blockSize) - blockSize, blockSize, blockSize);
                        g.fillRect(Main.p.x * blockSize,(Main.p.y * blockSize) + blockSize, blockSize, blockSize);
                        g.fillRect((Main.p.x * blockSize) - blockSize, (Main.p.y * blockSize), blockSize, blockSize);
                        g.fillRect((Main.p.x * blockSize) + blockSize, (Main.p.y * blockSize), blockSize, blockSize);
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                label.setText(Main.p.x + " " + Main.p.y);
                label2.setText("<html> [Backstory]: You are a thief that has attempted to steal coins and you got caught. You are now serving time in prison. <br/> You have a friend, Doug who is a Prison Guard, he wants you to turn your life around. </html>");
                label3.setText("<html> [Doug]: I found a job opportunity for you, It's hauling crates for the Dining Hall. <br/> I'm wondering if a theif like you would even consider the position. </html>");
            }
        };

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        label.setBounds(1550, 2, 100, 100);
        label2.setBounds(850, 15, 7000, 100);
        label3.setBounds(850, 50, 7000, 100);

        panel.setPreferredSize(new Dimension(300, 200));
        frame.add(panel);
        frame.pack();

        // Adding KeyListener to the panel
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

