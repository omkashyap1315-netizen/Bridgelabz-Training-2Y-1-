package Recursion.AdvanceRecursion;

public class MergeSort {
    public static void mergeSort(int arr[], int l, int r){
        if(l>=r){
            return;
        }
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        mergeSort(arr,l,mid,r);
    }
    public static void 
}
