package fppQuiz;

public class Outer {
    private int data = 10;
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.printVal(20);
    }
    void printVal(int bound) {
        if(data < bound) {
            //Replace definition of Inner and call to inner.getValue()
            //with a lambda expression.
//            class Inner implements ValGetter {
//                public int getValue() {
//                    return data;
//                }
//            }

//            ValGetter inner = new Inner();
//            System.out.println("Inside inner: " + inner.getValue());

            ValGetter inner = () -> data;
            System.out.println("Inside inner: " + inner.getValue());
        } else {
            System.out.println("Inside outer: " + (data - bound));
        }
    }
}
