package test;

import org.junit.Test;

import model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
public class BassFishTest {
    @Test
    public void createBFListTest() {
        BassFish bf1 = new BassFish(300,300);
        BassFish bf2 = new BassFish(150,240);
        BassFish bf3 = new BassFish(100,360);
        BassFish bf4 = new BassFish(50,270);


        List<Animal> bfList = new ArrayList<Animal>();
        bfList.add(bf1);
        bfList.add(bf2);
        bfList.add(bf3);
        bfList.add(bf4);

        Animal[] array1 = bfList.toArray(new Animal[bfList.size()]);
        Animal[] array2 = BassFish.createBFList().getAnimals().toArray(new Animal[4]);

        assertArrayEquals(array1, array2);
    }
}
