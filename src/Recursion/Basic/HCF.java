package Recursion.Basic;

import java.util.Scanner;

public class HCF {
    public static int HCF(int a, int b){
        if(b==0){
            return a;
        }
        return HCF(b,a%b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = sc.nextInt();

        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println(HCF(b,a));
    }
}