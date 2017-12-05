package model;
/**
 * @author Chu Qiao
 * @author Mingkun Chen
 * @author Yihan Ye
 */

import java.util.Iterator;
import java.util.List;

/**
 * This is the class of animals
 */
public class Animals {
	private String name;
	private List<Animal> animals;

	/**
	 * Class constructor for Animals
	 * @param name the name of the animals
	 * @param animals the list of animal
	 */

	public Animals(String name, List<Animal> animals) {
		this.name = name;
		this.animals = animals;
	}

	/**
	 * Get the animals in a list
	 * @return the animals in this list
	 */
	public List<Animal> getAnimals() {
		return animals;
	}

	/**
	 * get the size of Animals list
	 * @return the size of Animals
	 */
	public int number(){
		return getAnimals().size();
	}

	/**
	 * return the string of Animals
	 * @return the size of Animals
	 */
	public String toString(){
		String result = "";
		result += number();
		return result;
	}

	public void deleteDead(Net n){
		for(Iterator<Animal> iter = animals.iterator(); iter.hasNext();){
			Animal a = iter.next();
			if(a.getCaught() && n.getSwing()){
				iter.remove();
			}
		}
	}

	public boolean hasCollision(){
		boolean result = false;

		for(Animal a: animals) {
			result = result || a.getCaught();
		}

		return result;
	}

	/**
	 * update all the animal in the animals list
	 * @param n the net in the game
	 */
	public void update(Net n) {
		for(Animal a: animals) {
			a.update(n);
		}
		deleteDead(n);
		hasCollision();
	}

}
