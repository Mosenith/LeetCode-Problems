package DesignPattern;

public class LazyInitializedSingleton {
    private static LazyInitializedSingleton instance;

    private LazyInitializedSingleton() {

    }

    public static LazyInitializedSingleton getInstance() {
        // Lazy Singleton check null here, if null => initialized first
        if(instance == null) {
            instance = new LazyInitializedSingleton();
        }

        return instance;
    }
}
