package fppQuiz.OopConcept.Abstraction;

public class Bird extends Animal implements Flyable {
    private String name;

    public Bird() {
    }

    public Bird(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("Chip Chip ...");
    }

    @Override
    public void fly() {
        System.out.println(this.name + " can fly");
    }

    @Override
    public String toString() {
        return "Bird Name = " + this.name;
    }
}
