package test;

import static org.junit.Assert.*;

import org.junit.Test;
import model.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SummerFlounderTest {
    @Test
    public void createSFListTest() {
        SummerFlounder sf1 = new SummerFlounder(600,350);
        SummerFlounder sf2 = new SummerFlounder(200,450);
        SummerFlounder sf3 = new SummerFlounder(100,500);

        List<Animal> sfList = new ArrayList<>();
        sfList.add(sf1);
        sfList.add(sf2);
        sfList.add(sf3);

        Animal[] array1 = sfList.toArray(new Animal[sfList.size()]);

        Animal[] array2 = SummerFlounder.createSFList().getAnimals().toArray(new Animal[3]);
        assertArrayEquals(array1, array2);
    }
}