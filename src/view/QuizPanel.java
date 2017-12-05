package view;

import model.GameModel;

import javax.swing.*;
import java.awt.*;

public class QuizPanel extends JPanel{
    static GameModel model;

    public QuizPanel(){
        JPanel quizPanel = new JPanel();
        quizPanel.setBackground(Color.black);
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
        Font fnt = new Font("TimesRoman", Font.BOLD,30);
        g2d.setFont(fnt);
        g2d.drawImage(ImageLoader.quizBackground,0,0,this);
        g2d.setColor(new Color(85,50,7));
        drawString(g,model.getQuiz().getCurrentQuiz().getQuestion(),270,200);
    }
}
