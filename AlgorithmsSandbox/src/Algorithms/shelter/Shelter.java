package Algorithms.shelter;

import Algorithms.QueueIsEmptyException;

public class Shelter {

    public class AnimalInShelter {
        Animal animal;
        int number;

        AnimalInShelter(Animal animal, int number) {
            this.animal = animal;
            this.number = number;
        }

        @Override
        public String toString() {
            return "(" + animal.toString() + ": " + number + ")";
        }
        //todo: use as example on static
    }

    GenericListQueue<AnimalInShelter> dogsQueue = new GenericListQueue<>();
    GenericListQueue<AnimalInShelter> catsQueue = new GenericListQueue<>();
    int nextFreeNumber = 1;

    public void enqueue(Animal animal) {
        AnimalInShelter value = new AnimalInShelter(animal, nextFreeNumber);
        if (animal.getClass() == Dog.class) {
            dogsQueue.add(value);
        } else if(animal.getClass() == Cat.class) {
            catsQueue.add(value);
        } else {
            throw new RuntimeException("We have found a new species!!!!");
        }
        nextFreeNumber = nextFreeNumber + 1;
    }

    public Animal dequeueAny() {
        int catNumber;
        int dogNumber;
        try {
           catNumber  = catsQueue.peek().number;
        } catch (QueueIsEmptyException e) {
            catNumber = Integer.MAX_VALUE;
        }
        try {
            dogNumber  = dogsQueue.peek().number;
        } catch (QueueIsEmptyException e) {
            dogNumber = Integer.MAX_VALUE;
        }
        if(dogNumber < catNumber) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        try {
            return (Dog)dogsQueue.remove().animal;
        } catch (QueueIsEmptyException e) {
            return null;
        }
    }

    public Cat dequeueCat() {
        try {
            return (Cat)catsQueue.remove().animal;
        } catch (QueueIsEmptyException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DogsQueue: ").append(dogsQueue).append("; ");
        builder.append("CatsQueue: ").append(catsQueue).append("; ");
        builder.append("nextFreeNumber: ").append(nextFreeNumber);
        builder.append("\n");
        return builder.toString();
    }
}
