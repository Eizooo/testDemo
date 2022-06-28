package dataStructrue.recursion;

public class RecursionTest {

    public static void main(String[] args) {
        System.out.println("function1(3) = " + function1(3));
    }

    public static int function1(int n) {
        if (n <= 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }else {
            return n*function1(n-1);
        }
    }
}
