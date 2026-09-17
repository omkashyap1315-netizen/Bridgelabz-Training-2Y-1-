package Arrays.Assignment_02.Sorting_Algorithmns;

public class SortingAlgorithms {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;
        for (int i = 1; i < n; ++i) {
            int key = employeeIds[i];
            int j = i - 1;
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }
            employeeIds[j + 1] = key;
        }
    }

    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    private static void merge(double[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        for (int i = 0; i < n1; ++i) {
            leftArray[i] = prices[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = prices[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pi = partition(prices, low, high);
            quickSort(prices, low, pi - 1);
            quickSort(prices, pi + 1, high);
        }
    }

    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = scores[minIdx];
            scores[minIdx] = scores[i];
            scores[i] = temp;
        }
    }

    public static void heapSort(double[] salaries) {
        int n = salaries.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            double temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }

    private static void heapify(double[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int i = 0; i < ages.length; i++) {
            count[ages[i] - minAge]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentMarks = {85, 45, 78, 92, 63};
        bubbleSort(studentMarks);

        int[] employeeIds = {104, 101, 105, 102, 103};
        insertionSort(employeeIds);

        double[] bookPrices = {450.50, 299.99, 150.00, 599.49, 350.25};
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        double[] productPrices = {999.00, 199.50, 499.99, 29.99, 150.00};
        quickSort(productPrices, 0, productPrices.length - 1);

        int[] examScores = {72, 88, 91, 65, 54, 82};
        selectionSort(examScores);

        double[] salaries = {45000.0, 72000.0, 55000.0, 62000.0, 48000.0};
        heapSort(salaries);

        int[] studentAges = {14, 12, 16, 10, 18, 15, 13, 17, 11};
        countingSort(studentAges);
    }
}