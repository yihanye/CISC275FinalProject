package view;

import model.GameModel;

import javax.swing.*;
import java.awt.*;

public class ExplanPanel extends JPanel{
    static GameModel model;


    public ExplanPanel(){
        JPanel quizPanel = new JPanel();
        quizPanel.setBackground(null);
        add(quizPanel);
    }

    public void setModel(GameModel model){
        this.model = model;
    }

    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight());
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(GameView.scaleX,GameView.scaleY);

        Font fnt = new Font("TimesRoman", Font.BOLD,25);
        g2d.setFont(fnt);
        g2d.setColor(new Color(85,50,7));
        g2d.drawImage(ImageLoader.explanBackground,0,0,this);
        g2d.drawString(""+model.getQuiz().getCurrentQuiz().getResult(),300,230);
        drawString(g2d,model.getQuiz().getCurrentQuiz().getExplanation(),300,250);
        g2d.drawString("Got it!",520,440);
    }
}

