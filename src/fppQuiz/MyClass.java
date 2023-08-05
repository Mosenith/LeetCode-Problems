package fppQuiz;

public class MyClass {
    // Example page 11
    /*MyInnerClass inner;
    private String param;
    MyClass(String param) {
        inner = new MyInnerClass("innerStr");
        this.param = param; // the outer class version of this
    }
    void outerMethod() {
        System.out.println("Here 1: " + inner.innerParam);
        inner.innerMethod();
        //String t = inner.this.innerParam; //compiler error
    }
    class MyInnerClass {
        private String innerParam;

        MyInnerClass(String innerParam) {
        //the inner class version of 'this'
            this.innerParam = innerParam;
        }
        void innerMethod() {
            //accessing enclosing class’s version of this
            System.out.println(MyClass.this.param);
            // same as the following
            System.out.println(param);
        }
    }

    public static void main(String[] args) {
        (new MyClass("outerStr")).outerMethod();
    }*/

    /*private String s = "hello";
    MyInnerClass inner;
    public static void main(String[] args){
        new MyClass();
    }
    MyClass() {
//        System.out.println(inner.anInt); //NullPointerException
         inner = new MyInnerClass();
         System.out.println(inner.anInt); //OK
    }
    class MyInnerClass {
        private int anInt = 3;
        void innerMethod(){
            System.out.println(s);
        }
    }*/

    private  MyInner inner;
    public MyInner getMyInner() {
        return inner;
    }

    private class MyInner {
        private int innerInt;
        MyInner(int x) {
            innerInt = x;
        }
    }

    public static void main(String[] args) {
        MyClass mc = new MyClass();
//        MyInner mi = MyIn
        MyInner mi = mc.getMyInner();
        mi = mc.getMyInner();
        System.out.println(mi.innerInt);
    }

}
