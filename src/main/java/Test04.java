public class Test04 {
    public static void main(String[] args)  {
        MyClass myClass = new MyClass();
        MyClass2 myClass2 = new MyClass2();
        StringBuffer buffer = new StringBuffer("hello");
        String a = "hello";
        myClass.changeValue(buffer);
        myClass2.changeValue(a);
        System.out.println(buffer.toString());
        System.out.println("a = " + a);
    }
}

class MyClass {

    void changeValue(final StringBuffer buffer) {
        buffer.append("world");
    }
}

class MyClass2 {

    void changeValue(final String buffer) {
        buffer.toUpperCase();
    }
}