package Recursion.Basic;

public class fibo {
    public static int fiboNum(int n){
        if(n==0||n==1){
            return 1;
        }
        int small1 = fiboNum(n-1);
        int small2 = fiboNum(n-2);

        return small1 + small2;
    }

    public static void main(String[] args) {
        int result = fiboNum(5);
        System.out.println(result);
    }
}
