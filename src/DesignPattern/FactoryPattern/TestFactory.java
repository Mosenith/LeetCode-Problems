package DesignPattern.FactoryPattern;

import java.util.Scanner;

public class TestFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pcStr = sc.next();
        Computer pc = ComputerFactory.getComputer(pcStr, "2 GB", "500 GB", "2.4 GHz");

        String serverStr = sc.next();
        Computer server = ComputerFactory.getComputer(serverStr,"16 GB","1 TB","2.9 GHz");

        System.out.println("Factory PC => " + pc);
        System.out.println("Factory Server => " + server);
    }
}
