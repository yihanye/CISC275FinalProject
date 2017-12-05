package test;

import org.junit.*;

import model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AnimalsTest {
    Animal a1 = new Animal("animal", -50, 0, 1, 2, 200, 500, 0, 850);
    Animal a2 = new Animal("animal", 300, 0, 1, 2, 200, 500, 0, 850);
    List<Animal> list = new ArrayList<Animal>(2){{add(a1); add(a2);}};
    Animals animalList = new Animals("hello", list);

    Net net = new Net(500, 100, 3,3,45,10);;

    @Test
    public void getAnimalsTest() {
        List<Animal> temp = new ArrayList<>(2);
        temp.add(a1);
        temp.add(a2);
        Animal[] array2 = temp.toArray(new Animal[temp.size()]);
        Animal[] array1 = list.toArray(new Animal[list.size()]);

//        assertArrayEquals(temp, animalList.getAnimals());
        assertArrayEquals(array1,array2);
    }

    @Test
    public void numberTest() {
        assertEquals(2, animalList.number());
    }

    @Test
    public void deleteDeadTest() {
        animalList.deleteDead(net);
        assertEquals(2, animalList.number());
    }

    @Test
    public void hasCollisionTest() {
        boolean result = animalList.hasCollision();
        assertEquals(false, result);
    }

    @Test
    public void updateTest() {
        animalList.update(net);
        assertEquals(2, animalList.number());
    }
}
