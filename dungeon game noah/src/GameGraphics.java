import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameGraphics {
    JFrame frame;
    JPanel panel;
    JLabel label = new JLabel("Hello World!");
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

    public void drawMap(Graphics g) throws IOException {
        if (Map.map==2){
            blockSize =40;
        }
        prisonWall = ImageIO.read(PWallFile);
        player = ImageIO.read(playerFile);
        door = ImageIO.read(doorFile);
        bed = ImageIO.read(bedFile);
        sink = ImageIO.read(sinkFile);
        floor = ImageIO.read(PrisonFloorFile);

        for(int i = 0; i< Map.mapRep.length; i++) {
            for (int j = 0; j < Map.mapRep.length; j++) {
            g.drawImage(floor, j*blockSize, i*blockSize, blockSize, blockSize,null);
            }
        }
        for(int i = 0; i< Map.mapRep.length; i++){
            for(int j = 0; j< Map.mapRep.length; j++){
                if(Map.mapRep[j][i].equals("W ")){
                    g.drawImage(prisonWall, j*blockSize,i*blockSize, blockSize, blockSize,null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\udecf\ufe0f ")) {
                    g.drawImage(bed, j*blockSize,i*blockSize,blockSize,blockSize, null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\udebf")) {
                    g.drawImage(sink, (j*blockSize)-(j*6), (i*blockSize)-(i*6), 200,200, null);
                }
                if (Map.mapRep[j][i].equals("\uD83D\udeaa")) {
                    g.drawImage(door, j*blockSize,i*blockSize, blockSize,blockSize, null);
                }
            }
            g.drawImage(player, Main.p.x*blockSize, Main.p.y*blockSize, blockSize,blockSize, null);
        }

    }

    public void start() throws IOException {
        frame =  new JFrame("DungeonGame");
        frame.setVisible(true);
        label.setBounds(0,500, 100,100);
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                try {
                    drawMap(g);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                panel.repaint();
            }
        };
        panel.add(label);
        JButton button = new JButton();
        button.setBounds(0,0,cellSize, cellSize);


        panel.setPreferredSize(new Dimension(300,200));
        frame.add(panel);
        panel.setBackground(new Color(255,0,0));
        frame.setBounds(0,0,800,800);
        //frame.add(button);
        frame.pack();



    }

}

