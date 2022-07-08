package Algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class PetShelter {

    private LinkedList<Pet> list = new LinkedList<Pet>();

    public void enqueue(Pet pet) {
        list.addFirst(pet);
    }

    public Pet dequeueAny() {
        return list.pollLast();
    }

    public Dog dequeueDog() {
        Iterator x = list.descendingIterator();
        while (x.hasNext()) {
            Pet pet = (Pet)x.next();
            if (pet instanceof Dog) {
                x.remove();
                return (Dog)pet;
            }
        }

        return null;
    }

    public Cat dequeueCat() {
        Iterator x = list.descendingIterator();
        while (x.hasNext()) {
            Pet pet = (Pet)x.next();
            if (pet instanceof Cat) {
                x.remove();
                return (Cat)pet;
            }
        }

        return null;
    }

    public void print() {
        System.out.println(list);
    }
}
