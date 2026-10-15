package Recursion.Arrays;

public class PrintArray {
    public static void print(int arr[],int index){
        if(index == arr.length){
            return;
        }

        System.out.print(arr[index]+" ");
        print(arr,index+1);
    }
    public static void rev(int[] arr,int index){
        if(index<0){
            return;
        }
        System.out.print(arr[index]+" ");
        rev(arr,index-1);
    }
    static void main(String[] args) {
        int[] arr = {1,6,4,98,34,23,45};
        print(arr,0);
        System.out.println();
        rev(arr,arr.length-1);
    }
}