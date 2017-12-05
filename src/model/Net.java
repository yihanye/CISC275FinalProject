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

/**
* this is the class for net
*/
public class Net {
	double xPos, yPos;
	double xInc, yInc;
	int rotation;
	int rotationDeg;
	boolean swing;
	boolean caught;

	/**
	 * Class constructor of net
	 * @param xPos the x position of net
	 * @param yPos the y position of net
	 * @param xInc the x increment of net
	 * @param yInc the y increment of net
	 * @param rotation the rotation of net
	 * @param rotationDeg the rotation degree incremnt of net
	 */
	public Net(int xPos, int yPos, int xInc, int yInc, int rotation, int rotationDeg) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xInc = xInc;
		this.yInc = yInc;
		this.rotation = rotation;
		this.rotationDeg = rotationDeg;
		this.swing = true;
		this.caught = false;
	}

	/**
	 * get the net x position
	 * @return get x position of net
	 */
	public double getxPos() {
		return xPos;
	}

	/**
	 * get y position of the net
	 * @return  this net's x position
	 */
	public double getyPos() {
		return yPos;
	}

	/**
	 * get x increment of the net
	 * @return this net x increment
	 */
	public double getxInc() { return xInc;}

	/**
	 * get y increment of the net
	 * @return this net y increment
	 */
	public double getyInc() { return yInc;}
//	public boolean getSwing (){
//		return this.swing;
//	}

	/**
	 * get the rotation degree of net
	 * @return this net rotation degree
	 */
	public int getRotation() {
		return rotation;
	}
	
	
	public int getRotationDeg() {
		return rotationDeg;
	}

	public void setRotationDeg(int rotationDeg) {
		this.rotationDeg = rotationDeg;
	}

	/**
	 * create a new net in [500, 50] position
	 * @return the new net
	 */

	public boolean getSwing(){ return swing; }
	public boolean getCaught(){return caught;}
	public static Net createNet(){
		return new Net(500,80,0,0,0,10);
	}

	public int getCenterPosX(){
		return (int)(((Math.sin(Math.toRadians(getRotation())))*-60))+ (int)getxPos()+30;
	}

	public int getCenterPosY(){
		return (int)(((Math.cos(Math.toRadians(getRotation())))*60))+ (int)getyPos();
	}

	/**
	 * update the net increment based on the current degree
	 */
	public void updateInc(){
		this.xInc = -Math.sin(Math.toRadians(rotation))*20;
		this.yInc = Math.cos(Math.toRadians(rotation))*20;
	}

	/** 
	 *let net stop swinging
	 */
	public void stopSwing(){
		this.swing = false;
	}

	/**
	 * When net reached certain degree, change the rotation degree to let net go back
	 */
	public void updateRotationDeg() {
		if (rotation>50||rotation<-50) {
			rotationDeg*=-1;
		}
	}

	/**
	 * Update the current rotation depends on whether net swings or not
	 */
	public void updateRotation() {
			if(swing){
			updateRotationDeg();
			rotation += rotationDeg;}
	}

	/**
	 * determine whether the net is at edge
	 * @return whether the net is at edge
	 */
	public boolean atEdge() {
		return xPos<=50||xPos>=850||yPos>=600;
	}
	public void updatePosition() {
		if(caught){
			xPos -=xInc;
			yPos -= yInc;
		}
		else{
			if(atEdge()){
				goBack();
			}
			xPos +=xInc;
			yPos += yInc;

		}
	}

	/**
	 * let net go back for the start point
	 */
	public void goBack(){
		xInc *= -1;
		yInc *= -1;
	}

	/**
	 * if the net is not swing and yinc greater than 0, net can go down
	 * @return whether the net should go down
	 */
	public boolean goDown(){
		return !swing & (yInc>0);
	}
	public void resetNet(){
		if(yPos<80) {
			this.xPos = 500;
			this.yPos = 80;
			this.swing = true;
			this.caught = false;
		}
	}

	/**
	 * update the this.caught to true
	 */
	public void updateCollision(){
			caught = true;
	}

	/**
	 * update the movement of net based on the net status
	 */
	public void update() {

		if(swing){
			updateRotation();
			updateInc();
		}
		else{
			updatePosition();
		}

		resetNet();
	}

	public String toString() {
		return " net is on position " + "( "+(int)xPos+", "+(int)yPos+" ) with degree of " + rotation;
	}
//	public static void main(String[] args) {
//		Net n = new Net(500, 100, 3,3,45,10);
//		System.out.println(n);
//		for(int i = 0; i < 1000; i++){
//			n.update();
//			System.out.println(n);
//			try {
//				Thread.sleep(300);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
