package model;
/**
 @author Chu Qiao
 @author Mingkun Chen
 @author Yihan Ye
 */

import java.util.ArrayList;
import java.util.List;

/**
 * this is the class for bluecrab
 */
public class BlueCrab extends Animal {
	/**
	 * Constructor for blueCrab
	 * @param xPos the x position of crab
	 * @param yPos the y position of crab
	 */
	public BlueCrab(int xPos, int yPos) {
		super("BlueCrab", xPos, yPos, 2, 0, 300,500,0,850);
	}

	/**
	 * Create an animal list with 3 crabs
	 * @return Animal
	 */
	public static Animals createBCList() {
		BlueCrab bc1 = new BlueCrab(800, 640);
		BlueCrab bc2 = new BlueCrab(500, 620);
		BlueCrab bc3 = new BlueCrab(100, 600);

		List<Animal> bcList = new ArrayList<Animal>();
		bcList.add(bc1);
		bcList.add(bc2);
		bcList.add(bc3);
		return new Animals("BlueCrab",bcList);
	}

	public static Animals createSingleBCList(){
		BlueCrab bc = new BlueCrab(480, 500);
		bc.setxInc(0);
		bc.setyInc(0);
		List<Animal> bcList = new ArrayList<>();
		bcList.add(bc);
		return new Animals("BlueCrab", bcList);
	}

}