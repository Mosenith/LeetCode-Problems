package fppQuiz.OopConcept.Abstraction;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog("Shiba Inu");
        animal.makeSound(); // Prints "Shiba Inu woof woof"

        Flyable flyable = new Bird("Parrot");
        flyable.fly(); // Prints "Parrot can fly"
    }
}
