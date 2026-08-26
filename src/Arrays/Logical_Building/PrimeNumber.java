package Arrays.Logical_Building;

public class PrimeNumber {
    public static void primeNumber(int[] arr){
        int count=0;
        int[] num = new int[arr.length];
        for(int i=1;i< arr.length;i++){
            if(arr[i]%i==0){
                num[i]=count++;
            }
        }

    }
}
