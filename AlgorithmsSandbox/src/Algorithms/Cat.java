package Algorithms;

public class Cat implements Pet {
    protected String name;

    public Cat(String name){
        this.name=name;
    }

    @Override
    public String whoAmI() {
        return "cat";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Cat{" + name + '}';
    }
}
