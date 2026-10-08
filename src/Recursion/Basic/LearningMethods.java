package Recursion.Basic;

public class LearningMethods {
    public static int add(int a, int b){
        return a + b;
    }
    public static void mul(int a, int b){
        System.out.println(a*b);
    }
    static void main(String[] args){
        System.out.println( add(10,20));
        int result = add(10,20);
        System.out.println(result);
        mul(10,20);
    }
}
