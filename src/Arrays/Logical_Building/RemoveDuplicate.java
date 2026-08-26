package Arrays.Logical_Building;

public class RemoveDuplicate {

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    public static void removeDuplicate(int arr[]) {
        System.out.println("Array with duplicate elements : ");
        display(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = -1;
                }
            }
        }

        System.out.println("Array with Non Duplicate Elements : ");
        display(arr);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 4, 1, 5};
        removeDuplicate(arr);
    }
}