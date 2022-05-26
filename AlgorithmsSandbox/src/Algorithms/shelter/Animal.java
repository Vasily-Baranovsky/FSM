package Algorithms.shelter;

public abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
