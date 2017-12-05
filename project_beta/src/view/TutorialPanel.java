package view;

import model.*;
//import project.src.cisc275_project.Model.Animals;
//import project.src.cisc275_project.Model.GameModel;
//import project.src.cisc275_project.Model.Tutorial;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class TutorialPanel extends JPanel {
    static Tutorial model;
    final static int left = 0;
    final static int right = 1;


    public TutorialPanel(){
        JPanel menuPanel = new JPanel();
        add(menuPanel);
    }

    public void setModel(Tutorial model){
        this.model =model;
    }

    public void paintAnimal(Graphics g, Animal a, BufferedImage img){
        g.drawImage(img,(int)a.getxPos(),(int)a.getyPos(),this);
    }

    public void paintAnimals(Graphics g, Animals animals, BufferedImage[] imgs) {
        for(Animal a: animals.getAnimals()) {
            if(a.getxInc()<0){
                paintAnimal(g,a,imgs[left]);
            }
            else {
                paintAnimal(g,a,imgs[right]);
            }
        }
    }

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paint(Graphics g){
        // for the center of net
        double d = model.getNet().getRotation();
        int x  = (int)(((Math.sin(Math.toRadians(d)))*-60))+ (int)model.getNet().getxPos()+30;
        int y = (int)(((Math.cos(Math.toRadians(d)))*60))+ (int)model.getNet().getyPos();
        Rectangle rec  = new Rectangle(x,y,5,5);
        AffineTransform trans1 = AffineTransform.getTranslateInstance(300, 300);
        trans1.rotate(Math.toRadians(d),30,0);

        Graphics2D g2d = (Graphics2D) g;
        Font fnt = new Font("Garamond", Font.BOLD,40);
        g2d.setFont(fnt);
        g2d.scale(GameView.scaleX,GameView.scaleY);
        g2d.setColor(new Color(155,90,7));
        g2d.drawImage(ImageLoader.mainBackground, 0, 0, this);
        AffineTransform trans = AffineTransform.getTranslateInstance
                (model.getNet().getxPos(), model.getNet().getyPos());
        trans.rotate(Math.toRadians(model.getNet().getRotation()),30,0);

        paintAnimals(g2d, model.getBlueFishList(), ImageLoader.blueFish);
        paintAnimals(g2d, model.getBlueCrabList(), ImageLoader.blueCrab);
        paintAnimals(g2d,model.getSummerFlounderList(),ImageLoader.summerFlounder);
        paintAnimals(g2d,model.getBassFishList(),ImageLoader.bassFish);
        g2d.drawImage(ImageLoader.net, trans, this);
        g2d.draw(rec);
        g2d.drawImage(ImageLoader.boat,420,20,this);
        g2d.drawString(""+model.getScore(),1050,200);
        g2d.drawString("" + model.getCaughtBassFishNum(),1150, 310);
        g2d.drawString("" + model.getCaughtBlueFishNum(),1150, 400);
        g2d.drawString("" + model.getCaughtSummerFlounderNum(),1150, 490);
        g2d.drawString("" + model.getCaughtBlueCrabNum(),1150, 580);
        g2d.drawString(""+model.getQuizCorrect(),1150, 660);
        drawString(g2d, ""+model.hint(),300,300);

    }
}

