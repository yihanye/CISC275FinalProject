package model;

public class Tutorial extends GameModel{
    public Tutorial() {
        super(  BlueFish.createSingleBFList(),
                BlueCrab.createSingleBCList(),
                SummerFlounder.createSingleSFList(),
                BassFish.createSingleBFList(),
               0,
                999999999,
                0,
                Net.createNet(),
                QuizList.createQuizList(),
                true,
                STATE.GAME);
    }
    public int getCaughtBlueCrabNum(){
        return 1 - blueCrabList.getAnimals().size();
    }
    public int getCaughtBlueFishNum(){
        return 1 - blueFishList.getAnimals().size();
    }
    public int getCaughtSummerFlounderNum(){
        return 1 - summerFlounderList.getAnimals().size();
    }
    public int getCaughtBassFishNum(){
        return 1 - bassFishList.getAnimals().size();
    }
    @Override
    public void scoreUpdate() {
            score = (1 - getBassFishList().getAnimals().size())*10+
                    (1 - getBlueFishList().getAnimals().size())*10+
                    (1 - getSummerFlounderList().getAnimals().size())*30+
                    (1 - getBlueCrabList().getAnimals().size())*50+
                    quizCorrect*100;
    }

    public String hint(){
        String hint;
        hint = "Click the screen to capture the fish!";
        if(getCaughtBlueFishNum()==1){
            hint = "Capture FLOUNDER or BLUB CRAB; answer the quiz question for Bonus Points";
        }
        return hint;
    }

}
