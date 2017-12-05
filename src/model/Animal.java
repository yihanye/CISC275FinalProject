package model;
/**
@author Chu Qiao
@author Mingkun Chen
@author Yihan Ye
*/

/**
@author Chu Qiao
@author Mingkun Chen
@author Yihan Ye
*/

import java.util.Random;

/**
 * Represnt an animal in the game
 */
public class Animal 
	{
		String name;
		double xPos, yPos;
		double xInc, yInc;
		double upBound, downBound, leftBound, rightBound;
		boolean caught;

		/**
		 * Class constructor for animal
		 * @param name the name of the animal
		 * @param xPos the x position of the animal
		 * @param yPos the y position of the animal
		 * @param xInc the x incremnet of the animal
		 * @param yInc the y increment of the animal
		 */
	    public Animal(String name,int xPos,int yPos, int xInc, int yInc, int upBound, int downBound, int leftBound, int rightBound){
	        this.name = name;
	        this.xPos = xPos;
	        this.yPos = yPos;
	        this.xInc = xInc;
	        this.yInc = yInc;
	        this.upBound = upBound;
	        this.downBound = downBound;
	        this.leftBound = leftBound;
	        this.rightBound = rightBound;
	        this.caught = false;
	    }

		/**
		 * the description of an animal
		 * @return the string of animal constructor
		 */
		public String toString() {
	    	return name + " is on position" + "("+xPos+", "+ yPos+") with speed"+ "("+xInc+", "+ yInc+")" ;
	    }

		/**
		 * 	get the x position of the animal
		 * @return this animal's x position
		 */
		public double getxPos() {
			return xPos;
		}

		/**
		 * get the y position of the animal
		 * @return this animal's y position
		 */
		public double getyPos() {
			return yPos;
		}


		public double getyInc() {
			return yInc;
		}
		public double getxInc() {
			return xInc;
		}
		public boolean getCaught(){ return caught;}
		
		public void setCaught(Boolean bool) {
			caught = bool;
		}

		public void setxInc(double xInc) {
			this.xInc = xInc;
		}

		public void setyInc(double yInc) {
			this.yInc = yInc;
		}

		/**
		 * generate the random direction
		 * animal will change direction randomly
		 * @return this animal's updated direction
		 */
		public int randomDirection() {
			Random rand = new Random();
			int n = rand.nextInt(100)+1;
			return (n > 98) ? -1: 1;
		}

		/**
		 * update x direction
		 * if the animal at edge, the direction will turn back
		 * otherwise the aniaml direction will change randomly
		 */

		public void updateXDirection(Net n) {
				if(xPos >= rightBound || xPos < leftBound) {
					xInc *= -1;
				}
				else {
					xInc = xInc * randomDirection();
				}
		}

		/**
		 * update y direction
		 * if the animal at edge, the direction will turn back
		 * otherwise this animal's direction will change randomly
		 */
		public void updateYDirection(Net n) {

				if(yPos >= downBound || yPos <= upBound) {
					yInc *= -1;
				}
				else {
					yInc = yInc * randomDirection();
				}


		}

		/**
		 *update animals's position based on the current x/y direction
		 *
		 */
		public void updatePosition(Net n) {
			if(!this.caught){
				updateXDirection(n);
				updateYDirection(n);
				xPos = xPos + xInc;
				yPos = yPos + yInc;
			}
			else{
				xPos = n.getCenterPosX()-50;
				yPos = n.getCenterPosY()-30;
			}

		}

		/**
		 * determine whether this animal has to touched net
		 * @param n the net that in the game
		 * @return whether this animal has been caught by the net
		 */

		public boolean isCollision(Net n){
			//net center location
			int nX  = n.getCenterPosX();
			int nY = n.getCenterPosY();
			return (n.goDown())&&
					(!n.getCaught())&&
					(nX-getxPos()>0)&&(nX-getxPos()<100)&&
					(nY-getyPos()>10)&&(nY-getyPos()<80);
		}


		/**
		 * if it has been determined the animal has touched the net
		 * it will change the status of net and this animal
		 * @param n the net in the game
		 */
		public void updateCollision(Net n){

			if(isCollision(n)){
				this.caught = true;
				n.updateCollision();
			}
		}

		/**update the status of animal based on the interaction with net
		 * @param n the net that in the game
		 */
		public void update(Net n) {
			updatePosition(n);
			updateCollision(n);

		}
//
//	    public static void main(String[] args) {
//	    		Animal a1 = new Animal("animal",0,0,1,2,false);
//	    		for(int i = 0; i < 1000; i++){
//	    			a1.update();
//	    			System.out.println(a1);
//	    			try {
//	    				Thread.sleep(300);
//	    			} catch (InterruptedException e) {
//	    				e.printStackTrace();
//	    			}
//	    		}
//	    }
}
