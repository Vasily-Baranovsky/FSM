package Algorithms;

public class Dog implements Pet {
    protected String name;

    public Dog(String name){
        this.name=name;
    }

    @Override
    public String whoAmI() {
        return "dog";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog{" + name + '}';
    }
}
