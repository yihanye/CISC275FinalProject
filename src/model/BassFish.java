package model;

/**
 /**
 @author Chu Qiao
 @author Mingkun Chen
 @author Yihan Ye
 */

import java.util.ArrayList;
import java.util.List;

/**
 * this is the class for blue fish
 */
public class BassFish extends Animal {
    /**
     * Constructor for blueFish
     * @param xPos the x position of fish
     * @param yPos the y position of fish
     */
    public BassFish(int xPos, int yPos) {
        super("blue_fish", xPos, yPos, 2, 1, 200,400,0,850);
    }
    //create BlueFishList
    /**
     * Create an animal list with 3 blue fish
     * @return Animal
     */
    public static Animals createBFList(){

        BassFish bf1 = new BassFish(300,300);
        BassFish bf2 = new BassFish(150,240);
        BassFish bf3 = new BassFish(100,360);
        BassFish bf4 = new BassFish(50,270);


        List<Animal> bfList = new ArrayList<Animal>();
        bfList.add(bf1);
        bfList.add(bf2);
        bfList.add(bf3);
        bfList.add(bf4);
        return new Animals("BlueFish",bfList);
    }
    public static Animals createSingleBFList(){
        BassFish bf = new BassFish(480, 350);
        bf.setxInc(0);
        bf.setyInc(0);
        List<Animal> bfList = new ArrayList<>();
       // bfList.add(bf);
        return new Animals("BassFish", bfList);
    }
}
