package Arrays.Logical_Building;

import java.util.Scanner;

public class ReverseArray {
    public static void reverse(int arr[])
    {
        int a=0;
        int b=arr.length-1;
        while(a<b)
        {
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
            a++;
            b--;
        }
    }

    public static void display(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }

    static void main() {
        Scanner sc = new Scanner(System.in);

    }
}
