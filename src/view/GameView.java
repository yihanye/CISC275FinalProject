package view;

import model.GameModel;
import model.Tutorial;

import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameView extends JFrame{
	static GameModel model = new GameModel();
	static TutorialPanel tutorialPanel = new TutorialPanel();
	static MenuPanel menuPane = new MenuPanel();
	static AskHelpPanel askHelpPanel = new AskHelpPanel();
	static GamePanel gamePanel = new GamePanel();
	static QuizPanel quizPanel = new QuizPanel();
	static ExplanPanel explanPanel = new ExplanPanel();
	static InfoPanel infoPanel = new InfoPanel();
	static EndPanel endPanel = new EndPanel();


	final static int frameWidth = 1200;
    final static int frameHeight = 700;
	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	static double width = screenSize.getWidth();
	static double height = screenSize.getHeight();
	static double scaleX = width/frameWidth;
	static double scaleY = height/frameHeight;

	public static double getScaleX() {
		return scaleX;
	}

	public static double getScaleY() {
		return scaleY;
	}

	public void setModel(GameModel model) {
		this.model = model;
		gamePanel.setModel(model);
		quizPanel.setModel(model);
		explanPanel.setModel(model);
		endPanel.setModel(model);
		tutorialPanel.setModel(model.getTutorial());
	}

	public GameView(){
		setPreferredSize(new Dimension(1200,700));
		setBackground(Color.black);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();
		setResizable(true);

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = env.getDefaultScreenDevice();
		if(gd.isFullScreenSupported()){
			gd.setFullScreenWindow(this);
		}

		//exit full screen
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "EXIT");
		getRootPane().getActionMap().put("EXIT", new AbstractAction(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				int x = (int) (me.getX()/ getScaleX());
				int y = (int) (me.getY()/ getScaleY());
				model.clicked(x,y);
			}
		});
	}



    public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if(model.getGameState() == GameModel.STATE.MENU){
			menuPane.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.ASKHELP){
			askHelpPanel.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.INFO){
			infoPanel.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.GAME){
			gamePanel.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.QUIZ){
			quizPanel.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.EXPLAN){
			explanPanel.paint(g2d);
		}
		else if(model.getGameState() == GameModel.STATE.END){
			endPanel.paint(g2d);
		}
		else{
				//else if(model.getGameState() == GameModel.STATE.TUTORIAL){
				if(model.getTutorial().getGameState() == GameModel.STATE.GAME){
					tutorialPanel.paint(g2d);
				}
				if(model.getTutorial().getGameState() == GameModel.STATE.QUIZ){
					quizPanel.paint(g2d);
				}
				if(model.getTutorial().getGameState() == GameModel.STATE.EXPLAN){
					explanPanel.paint(g2d);
				}
		}
	}

	public  void update() {
		this.repaint();
	}

//    public static void main(String[] args) {
//		for(int i = 0; i < 10000; i++){
//				update();
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//    }

}
