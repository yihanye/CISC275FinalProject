package test;

//import static org.junit.Assert.*;
//
//import org.junit.Test;

import org.junit.*;

import model.*;

import static org.junit.Assert.assertEquals;

public class NetTest {

    @Test
    public void netTest() {
        Net net1 = new Net(50, 60, 70, 80, 120, 15);
        assertEquals(50, net1.getxPos(),0.0001);
        assertEquals(60, net1.getyPos(), 0.0001);
        assertEquals(70, net1.getxInc(), 0.0001);
        assertEquals(80, net1.getyInc(), 0.0001);
        assertEquals(120, net1.getRotation());
        assertEquals(15, net1.getRotationDeg());
        assertEquals(true, net1.getSwing());
        assertEquals(false, net1.getCaught());
        assertEquals(29, net1.getCenterPosX());
        assertEquals(31, net1.getCenterPosY());
        assertEquals(true, net1.atEdge());
        assertEquals(false, net1.goDown());
        assertEquals(" net is on position ( 50, 60 ) with degree of 120", net1.toString());

        net1.updateCollision();
        assertEquals(true, net1.getCaught());

        net1.updateInc();
        assertEquals(-17.32051, net1.getxInc(), 0.0001);
        assertEquals(-9.9999999, net1.getyInc(), 0.0001);

        net1.stopSwing();
        assertEquals(false, net1.getSwing());

        net1.updateRotation();
        assertEquals(120, net1.getRotation());

        net1.updateRotationDeg();
        assertEquals(-15, net1.getRotationDeg());

        net1.updatePosition();
        assertEquals(67.3205, net1.getxPos(), 0.0001);
        assertEquals(70.0, net1.getyPos(), 0.0001);

        net1.goBack();
        assertEquals(17.32051, net1.getxInc(), 0.0001);
        assertEquals(9.9999999, net1.getyInc(), 0.0001);

        net1.resetNet();
        assertEquals(500, net1.getxPos(), 0.0001);
        assertEquals(80, net1.getyPos(), 0.0001);
        assertEquals(true, net1.getSwing());
        assertEquals(false, net1.getCaught());
    }
}


