package model;

public class GameModel {
	protected Animals blueFishList;
	protected Animals blueCrabList;
	protected Animals summerFlounderList;
	protected Animals bassFishList;
	protected Tutorial tutorial;
	protected int score;
	protected int time;
	protected int quizCorrect;
	protected Net net;
	protected QuizList quiz;
	protected boolean quizable= true;
	public enum STATE{MENU,TUTORIAL,ASKHELP,INFO,GAME,QUIZ,EXPLAN,END}
	protected STATE state;

	//Constructor
	public GameModel() {
		this.blueFishList = BlueFish.createBFList();
		this.blueCrabList = BlueCrab.createBCList();
		this.summerFlounderList = SummerFlounder.createSFList();
		this.bassFishList = BassFish.createBFList();
		this.tutorial = new Tutorial();
		this.net = Net.createNet();
		this.quiz = QuizList.createQuizList();
		this.quizCorrect = 0;
		this.score = 0;
		this.time = 600;
		this.state = STATE.MENU;
	}
 
	public GameModel(Animals blueFishList, Animals blueCrabList, Animals summerFlounderList, Animals bassFishList,
					 int score, int time, int quizCorrect, Net net, QuizList quiz, boolean quizable, STATE state) {
		this.blueFishList = blueFishList;
		this.blueCrabList = blueCrabList;
		this.bassFishList = bassFishList;
		this.summerFlounderList = summerFlounderList;
		this.score = score;
		this.time = time;
		this.quizCorrect = quizCorrect;
		this.net = net;
		this.quiz = quiz;
		this.quizable = quizable;
		this.state = state;
	}
 

	public Animals getBlueFishList() {
		return blueFishList;
	}
	public Animals getBlueCrabList() {
		return blueCrabList;
	}
	public Animals getSummerFlounderList() {
		return summerFlounderList;
	}
	public Animals getBassFishList() {
		return bassFishList;
	}
	public int getScore() {
		return score;
	}
	public QuizList getQuiz() { return quiz; }
	public void setQuizable(boolean bool){ quizable = bool; }
	public boolean getQuizable(){return quizable;}
	public int getTime() {
		return time;
	}
	public int getQuizCorrect(){
		return quizCorrect;
	}
	public Net getNet() {
		return net;
	}
	public STATE getGameState() {
		return state;
	}
	public Tutorial getTutorial() { return tutorial; }

	public int getCaughtBlueCrabNum(){
		return 3 - blueCrabList.getAnimals().size();
	}
	public int getCaughtBlueFishNum(){
		return 4 - blueFishList.getAnimals().size();
	}
	public int getCaughtSummerFlounderNum(){
		return 3 - summerFlounderList.getAnimals().size();
	}
	public int getCaughtBassFishNum(){
		return 4 - bassFishList.getAnimals().size();
	}

	public void CaughtNumUpdate(){
		getCaughtSummerFlounderNum();
		getCaughtBlueFishNum();
		getCaughtBlueCrabNum();
		getCaughtBassFishNum();
	}


	public void setState(STATE state){
		this.state = state;
	}


	public void clicked(int x, int y){
		if(getGameState()== STATE.GAME){
			net.stopSwing();
			if(!hasCollision()){
				setQuizable(true);
			}
		}

		else if(getGameState()== STATE.TUTORIAL){
			getTutorial().clicked(x,y);
		}

		else if(getGameState() == STATE.MENU){
			boolean startButton =x<705 && x>495 && y<425 && y>355;
			boolean helpButton = x<705 & x>495 && y<520 && y>450;
			if(startButton){
				setState(STATE.ASKHELP);
			}
			if(helpButton){
				setState(STATE.TUTORIAL);
			}
		}
		else if(getGameState() == STATE.ASKHELP){
			boolean ofCourseButton = x<600 && x>420 && y<550 && y>500;
			if(ofCourseButton){
				setState(STATE.INFO);
			}
		}
		else if(getGameState() == STATE.INFO){
			boolean button = x<1160 && x>910 && y<700 && y>640;
			if(button){
				setState(STATE.GAME);
			}
		}
		else if(getGameState() == STATE.QUIZ){
			boolean option1 = (x>370 && x<480 && y > 410 && y<470);
			boolean option2 = (x>650 && x<760 && y > 410 && y<470);
			if(getQuiz().getCurrentQuiz().checkAnswer(option1,option2)){
				getQuiz().getCurrentQuiz().setCorrectornot(true);
				quizCorrect++;
			}
			if(option1||option2){
				setState(STATE.EXPLAN);
			}
		}
		else if(getGameState() == STATE.EXPLAN){
			if(x<630 && x>470 && y<470 && y>410){
				switchBackToGame();
			}
		}
	}

	public void timeUpdate(){
		time--;
	}

	public void scoreUpdate(){
	   score = getCaughtBassFishNum()*10+
			   getCaughtBlueFishNum()*10+
			   getCaughtSummerFlounderNum()*30+
			   getCaughtBlueCrabNum()*50+
			   quizCorrect*100;
    }

	/**
	 * Check whether there is a collision happened for all animal list
	 * @return whether there is a collision happened
	 */

	public boolean hasCollision (){
		return blueCrabList.hasCollision() || blueFishList.hasCollision()||
				summerFlounderList.hasCollision()||bassFishList.hasCollision();
	}

	/**
	 * switch to quiz model
	 */
	public void switchToQuiz(){
		boolean quizornot = (blueCrabList.hasCollision()) && getQuizable();
		if(quizornot==true){
			setState(STATE.QUIZ);
			setQuizable(false);
		}
	}

	/**
	 *  swich back to GAME from QUIZ
	 */
	public void switchBackToGame(){
			setQuizable(false);
			quiz.nextQuiz();
			setState(STATE.GAME);
	}

	public void switchToEnd(){
		if(time == 0){
			setState(STATE.END);
		}
	}
	public void stateUpdate(){
		switchToQuiz();
		switchToEnd();
	}


	public void update() {
		if(state == STATE.GAME ) {
			blueFishList.update(net);
			blueCrabList.update(net);
			summerFlounderList.update(net);
			bassFishList.update(net);
			net.update();
			timeUpdate();
			scoreUpdate();
			stateUpdate();
			CaughtNumUpdate();
		}
		else if(state == STATE.TUTORIAL){
			tutorial.update();
		}
	}

}
