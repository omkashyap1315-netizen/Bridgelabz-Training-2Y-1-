package Recursion.Basic;

public class Sum {
    public static int sum(int n){
        if(n<10){
            return n;
        }
        int small = n%10;
        int small2 = sum(n/10);

        return small + small2;
    }
    public static void main(String[] args){
        System.out.println(sum(1234));
    }
}