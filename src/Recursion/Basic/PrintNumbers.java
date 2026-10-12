package Recursion.Basic;

public class PrintNumbers {
    public static void printIncrease(int n) {
        //Base Case
        if(n==1)
        {
            System.out.println(n+" ");
            return;
        }
        //Recursive Work
        printIncrease(n-1);
        //self work
        System.out.println(n+" ");
    }

    static void main(String[] args) {
        printIncrease(10);
    }
}
