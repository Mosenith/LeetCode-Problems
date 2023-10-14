package DesignPattern.CompositePattern;

public class TestCompositePattern {
    public static void main(String[] args) {
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();

        Drawing drawing = new Drawing();
        drawing.add(tri);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");
        System.out.println("\n*****\n");

        drawing.draw("Green");
        System.out.println("\n*****\n");

        drawing.clear();
        System.out.println("\n*****\n");

        drawing.add(tri);
        drawing.add(cir);

        drawing.draw("Green");
    }
}
