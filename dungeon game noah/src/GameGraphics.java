import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameGraphics {
    JFrame frame;
    JPanel panel;
    BufferedImage pUp;
    BufferedImage PrisonerSprite;
    BufferedImage player;
    BufferedImage prisonWall;
    BufferedImage sink;
    BufferedImage door;
    BufferedImage bed;
    File pUpFile;
    File playerFile = new File("dungeon game noah/src/PrisonerSprite.png");
    File PWallFile = new File("dungeon game noah/src/PrisonWall.png");
    File bedFile = new File("dungeon game noah/src/Bed.png");
    File sinkFile = new File("dungeon game noah/src/Sink.png");
    File doorFile = new File("dungeon game noah/src/PrisonDoor.png");

    private int cellSize = 15;

    public void drawMap(Graphics g) throws IOException {
        prisonWall = ImageIO.read(PWallFile);
        player = ImageIO.read(playerFile);
        door = ImageIO.read(doorFile);
        bed = ImageIO.read(bedFile);
        sink = ImageIO.read(sinkFile);
        for(int i = 0; i< Map.mapRep.length; i++){
            for(int j = 0; j< Map.mapRep.length; j++){
                if(Map.mapRep[j][i].equals("W ")){
                    g.drawImage(prisonWall, j*160,i*160, 160, 160,null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\udecf\ufe0f ")) {
                    g.drawImage(bed, j*160,i*160,160,160, null);
                }
                if (Map.mapRep[j][i].equals("\ud83d\udebf")) {
                    g.drawImage(sink, (j*160)-(j*6), (i*160)-(i*6), 200,200, null);
                }
                if (Map.mapRep[j][i].equals("\uD83D\udeaa")) {
                    g.drawImage(door, j*160,i*160, 160,160, null);
                }
            }
            g.drawImage(player, Main.p.x*160, Main.p.y*160, 160,160, null);
        }

    }

    public void start() throws IOException {
        frame =  new JFrame("DungeonGame");
        frame.setVisible(true);
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
        JButton button = new JButton();
        button.setBounds(0,0,cellSize, cellSize);

        frame.add(panel);
        panel.setLocation(800, 0);
        frame.setBounds(0,0,800,800);
        //frame.add(button);


    }

}

