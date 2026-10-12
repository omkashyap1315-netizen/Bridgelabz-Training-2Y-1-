package Recursion.Basic;

public class FactorialNumber {
    public static int fact(int n){
        if(n==0){
            return 1;
        }

        int small = fact(n-1);
        return n*small;
    }
    public static int add(int n){
        if(n==1){
            return 1;
        }
        int small = add(n-1);
        return small+n;
    }

    static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(add(5));
    }
}
