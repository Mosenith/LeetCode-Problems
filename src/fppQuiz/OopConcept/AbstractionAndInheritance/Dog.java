package fppQuiz.OopConcept.AbstractionAndInheritance;

public class Dog extends Animal {
    private String name;
    public Dog() {
    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + " woof woof ...");
    }

    @Override
    public String toString() {
        return "Dog Name = " + name;
    }
}
