package Algorithms.shelter;

import Algorithms.QueueIsEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShelterTest {
    Shelter shelter;
    private static final int NUMBER_OF_ANIMALS_IN_RANDOM_TEST = 30000;
    @BeforeEach
    void setUp () {
         shelter = new Shelter();
    }

    @Test
    void enqueueTest () {
        enqueueTestManual();
        setUp();
        enqueueTestRandom();
    }

    private void enqueueTestManual() {
        Dog firstDog = new Dog("Tuzik");
        shelter.enqueue(firstDog);
        try {
            assertSame(shelter.dogsQueue.peek().animal, firstDog);
            System.out.println(shelter);
        } catch (QueueIsEmptyException e) {
            fail();
        }
        System.out.println(shelter);

        Cat firstCat = new Cat("Murzik");
        shelter.enqueue(firstCat);
        try {
            assertSame(shelter.catsQueue.peek().animal, firstCat);
            System.out.println(shelter);
        } catch (QueueIsEmptyException e) {
            fail();
        }
        System.out.println(shelter);
    }

    private void enqueueTestRandom() {
        Animal[] testAnimals = testAnimals(NUMBER_OF_ANIMALS_IN_RANDOM_TEST);

        for (int i=0; i < NUMBER_OF_ANIMALS_IN_RANDOM_TEST; i++) {
            shelter.enqueue(testAnimals[i]);
        }
        //System.out.println(shelter);

        for (int i=0; i < NUMBER_OF_ANIMALS_IN_RANDOM_TEST; i++) {
            assertSame(shelter.dequeueAny(), testAnimals[i]);
        }
        //System.out.println(shelter);
    }

    @Test
    void dequeueAny() {
        enqueueTestManual();
        assertSame("Tuzik", shelter.dequeueAny().name);
        assertSame("Murzik", shelter.dequeueAny().name);
        enqueueTestRandom();
    }

    @Test
    void dequeueDog() {
        enqueueTestManual();
        assertSame("Tuzik", shelter.dequeueDog().name);
        assertNull(shelter.dequeueDog());

        Animal[] animals = testAnimals(NUMBER_OF_ANIMALS_IN_RANDOM_TEST);
        ArrayList<Dog> dogs = new ArrayList<>(NUMBER_OF_ANIMALS_IN_RANDOM_TEST);

        for(int i=0; i<NUMBER_OF_ANIMALS_IN_RANDOM_TEST; i++) {
            shelter.enqueue(animals[i]);
            if (animals[i] instanceof Dog) {
                dogs.add((Dog)animals[i]);
            }
        }

        for (int i=0; i < dogs.size(); i++) {
            assertSame(shelter.dequeueDog(), dogs.get(i));
        }

        assertNull(shelter.dequeueDog());
    }

    @Test
    void dequeueCat() {
        enqueueTestManual();
        assertSame("Murzik", shelter.dequeueCat().name);
        assertNull(shelter.dequeueCat());

        Animal[] animals = testAnimals(NUMBER_OF_ANIMALS_IN_RANDOM_TEST);
        ArrayList<Cat> cats = new ArrayList<>(NUMBER_OF_ANIMALS_IN_RANDOM_TEST);

        for(int i=0; i<NUMBER_OF_ANIMALS_IN_RANDOM_TEST; i++) {
            shelter.enqueue(animals[i]);
            if (animals[i] instanceof Cat) {
                cats.add((Cat)animals[i]);
            }
        }

        for (int i=0; i < cats.size(); i++) {
            assertSame(shelter.dequeueCat(), cats.get(i));
        }

        assertNull(shelter.dequeueCat());
    }

    private Animal[] testAnimals(int numberOfAnimals) {
        Animal[] animals = new Animal[numberOfAnimals];

        for (int i=0; i < numberOfAnimals; i++) {
            if (Math.random() <0.5) {
                animals[i] = new Dog("Tuzik " + i);
            } else {
                animals[i] = new Cat ("Murzik " + i);
            }
        }
        return animals;
    }
}