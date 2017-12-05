package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Animal;
import model.Net;

public class AnimalTest {

	static Animal animal = new Animal("animal",300,300,1,2,200, 500, 0 , 850);
    static Net net = new Net(500, 100, 3,3,45,10);;
    @Test
    public void getXPosTest() {
        assertEquals(301, animal.getxPos(), 0);
    }

    @Test
    public void getYPosTest() {
        assertEquals(300, animal.getyPos(), 0);
    }

    @Test
    public void getXIncTest() {
        assertEquals(1, animal.getxInc(), 0);
    }

    @Test
    public void getCaughtTest() {
        assertEquals(false, animal.getCaught());
    }

    //This can be tested by chi-square testing method
    @Test
    public void randomDirectionTest() {
        assertEquals(-1, animal.randomDirection(), 2);
    }

    @Test
    public void updateXDirectionTest() {
        Animal a1 = new Animal("animal", -50, 0, 1, 2, 200, 500, 0, 850);
        Animal a2 = new Animal("animal", 300, 0, 1, 2, 200, 500, 0, 850);

        a1.updateXDirection(net);
        assertEquals(-1, a1.getxInc(), 0);

        a2.updateXDirection(net);
        assertEquals(-1, a1.getxInc(), 2);
    }

    @Test
    public void updateYDirectionTest() {
        Animal a1 = new Animal("animal",0,150,1,2,200, 500, 0 , 850);
        Animal a2 = new Animal("animal",0,300,1,2,200, 500, 0 , 850);

        a1.updateYDirection(net);
        assertEquals(-2, a1.getyInc(), 0);

        a2.updateYDirection(net);
        assertEquals(-1, a1.getyInc(), 2);
    }

    @Test
    public void updatePositionTest() {
        Animal a1 = new Animal("animal",300,300,1,2,200, 500, 0 , 850);

        a1.updatePosition(net);

        assertEquals(301, a1.getxPos(), 0);
        assertEquals(302, a1.getyPos(), 0);

        a1.setCaught(true);

        a1.updatePosition(net);

        assertEquals(438, a1.getxPos(), 0);
        assertEquals(112, a1.getyPos(), 0);
    }

    @Test
    public void isCollisionTest() {
        boolean check = animal.isCollision(net);

        assertEquals(false, check);
    }

    @Test
    public void updateCollisionTest() {
        animal.updateCollision(net);

        assertEquals(false, animal.getCaught());
    }

    @Test
    public void updateTest() {
        animal.update(net);

        assertEquals(301, animal.getxPos(), 0);
        assertEquals(302, animal.getyPos(), 0);
        assertEquals(false, animal.getCaught());
    }
}
