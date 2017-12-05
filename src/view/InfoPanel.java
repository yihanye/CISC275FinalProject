package view;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    public InfoPanel(){
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.black);
        add(menuPanel);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(GameView.scaleX,GameView.scaleY);
        g2d.drawImage(ImageLoader.infoBackground,0,0,this);
    }
}
