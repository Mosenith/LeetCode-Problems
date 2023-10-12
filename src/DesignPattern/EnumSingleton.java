package DesignPattern;

public enum EnumSingleton {
    INSTANCE;

    private EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
