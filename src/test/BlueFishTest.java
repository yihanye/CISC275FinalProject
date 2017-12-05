package test;

import org.junit.Test;

import model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class BlueFishTest {
    @Test
    public void createBFListTest() {
        BlueFish bf1 = new BlueFish(800,250);
        BlueFish bf2 = new BlueFish(250,220);
        BlueFish bf3 = new BlueFish(500,280);
        BlueFish bf4 = new BlueFish(600,320);
        BlueFish bf5 = new BlueFish(300,300);
        BlueFish bf6 = new BlueFish(150,240);
        BlueFish bf7 = new BlueFish(100,360);
        BlueFish bf8 = new BlueFish(50,270);


        List<Animal> bfList = new ArrayList<Animal>();
        bfList.add(bf1);
        bfList.add(bf2);
        bfList.add(bf3);
        bfList.add(bf4);

        Animal[] array1 = bfList.toArray(new Animal[bfList.size()]);
        Animal[] array2 = BlueFish.createBFList().getAnimals().toArray(new Animal[4]);

        assertArrayEquals(array1, array2);
    }
}
