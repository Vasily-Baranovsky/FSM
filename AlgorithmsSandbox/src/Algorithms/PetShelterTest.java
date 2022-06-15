package Algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetShelterTest {
    @Test
    public void SmokeTest() {
        PetShelter ps = new PetShelter();
        ps.enqueue(new Dog("dog1"));
        ps.enqueue(new Cat("cat1"));
        ps.enqueue(new Dog("dog2"));
        ps.enqueue(new Cat("cat2"));
        ps.enqueue(new Cat("cat3"));

        ps.print();

        System.out.println(ps.dequeueAny());
        ps.print();

        System.out.println(ps.dequeueDog());
        ps.print();

        System.out.println(ps.dequeueCat());
        ps.print();
    }
}