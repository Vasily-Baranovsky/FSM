package Algorithms.shelter;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public String toString(){
        return "Cat: " + super.toString();
    }
}
