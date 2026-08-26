package Arrays.Logical_Building;

import java.util.Scanner;

public class Swapping {
    public static void display(int[] arr){
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void swap(int[] arr){
        int temp=0;
        temp = arr[0];
        arr[0]=arr[4];
        arr[4]=temp;
        display(arr);

    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i< arr.length;i++){
            arr[i]= sc.nextInt();
        }
        swap(arr);
    }
}
