package DesignPattern.SingletonPattern;

public class EagerInitializedSingleton {
    // private static final + init immediately
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();

    // private constructor to avoid client applications using the constructor
    private EagerInitializedSingleton() {

    }

    // public static getInstance() to return the variable
    public static EagerInitializedSingleton getInstance() {
        return instance;
    }

}
