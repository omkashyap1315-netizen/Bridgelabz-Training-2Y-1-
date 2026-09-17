package Arrays.Assignment_01;

public class LinearSearchDemo {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 61, 2, 3, 4, 0};
        int targetBest = 8;
        int targetWorst = 0;

        int resultBest = linearSearch(arr, targetBest);
        int resultWorst = linearSearch(arr, targetWorst);

        System.out.println("Best Case (Target " + targetBest + "): Index " + resultBest);
        System.out.println("Worst Case (Target " + targetWorst + "): Index " + resultWorst);
    }
}
