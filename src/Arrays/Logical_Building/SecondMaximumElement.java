//package Arrays.Logical_Building;
//
//public class SecondMaximumElement {
//    public static int MaxElement(int arr[])
//    {
//        int max = Integer.MIN_VALUE;
//        for(int i=0 ; i<arr.length; i++)
//        {
//            if(arr[i]>max)
//            {
//                max=arr[i];
//            }
//        }
//        return max;
//    }
//
//    public static void main(String[] args){
//
//    }
//}
package Arrays.Logical_Building;

public class SecondMaximumElement {

    public static int MaxElement(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int secondMaxElement(int arr[]) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};

        System.out.println("Maximum Element : " + MaxElement(arr));
        System.out.println("Second Maximum Element : " + secondMaxElement(arr));
    }
}
