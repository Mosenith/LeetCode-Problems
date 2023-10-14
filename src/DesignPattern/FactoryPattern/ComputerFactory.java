package DesignPattern.FactoryPattern;

// Basic Implementation of Factory Class
public class ComputerFactory {
    public static Computer getComputer(String type, String ram,
                                       String hdd, String cpu) {
        if(type.equalsIgnoreCase("PC")) {
            return new PC(ram, hdd, cpu);
        } else {
            return new Server(ram, hdd, cpu);
        }
    }
}
