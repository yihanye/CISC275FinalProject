package model;

import java.util.ArrayList;


public class Quiz {
    private String question;
    private int answer;
    private String explanation;
    private boolean correctornot = false;

    public Quiz(String question, int answer, String explanation){
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
    }

    public String getQuestion() {
        return question;
    }

    public String getExplanation(){
        return explanation;
    }


    public boolean getCorrectornot(){
        return correctornot;
    }

    public void setCorrectornot(Boolean bool){
        correctornot = bool;
    }

    public String getResult(){
        if(getCorrectornot()){
            return "CORRECT!";
        }
        else{
            return "Incorrect!";
        }
    }

    public boolean checkAnswer(boolean option1, boolean option2){
        return (answer==0 && option1) || (answer == 1 && option2 );
    }


}
