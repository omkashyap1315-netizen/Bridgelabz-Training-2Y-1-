package Stack.Assignment_05;

public class Stack_Q5_CircularTour {

    // Returns the starting pump index, or -1 if the tour is not possible
    static int circularTour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, end = 1 % n;
        int surplus = petrol[0] - distance[0];

        while (end != start || surplus < 0) {
            // drop the starting pump while surplus is negative
            while (surplus < 0 && start != end) {
                surplus -= petrol[start] - distance[start];
                start = (start + 1) % n;
                if (start == 0) return -1; // went around once, impossible
            }
            // add the next pump to the tour
            surplus += petrol[end] - distance[end];
            end = (end + 1) % n;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] petrol   = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = circularTour(petrol, distance);
        if (start == -1) {
            System.out.println("No tour possible");
        } else {
            System.out.println("Start at pump index: " + start); // Expected: 1
        }
    }
}

