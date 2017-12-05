package test;
import org.junit.Test;

import model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class BlueCrabTest {
    @Test
    public void createBCListTest() {
        BlueCrab bc1 = new BlueCrab(800, 640);
        BlueCrab bc2 = new BlueCrab(500, 620);
        BlueCrab bc3 = new BlueCrab(100, 600);

        List<Animal> bcList = new ArrayList<Animal>();
        bcList.add(bc1);
        bcList.add(bc2);
        bcList.add(bc3);

        Animal[] array1 = bcList.toArray(new Animal[bcList.size()]);
        Animal[] array2 = BlueCrab.createBCList().getAnimals().toArray(new Animal[3]);

        assertArrayEquals(array1, array2);
    }
}