package sortingalgorithms;

public class CountingSort {

    private static int counter = 0;

    private CountingSort() {
    }

    public static void useCountingSort(int[] arr) {
        if (arr.length == 0) {
            counter++;
            return;
        }

        // Find max value
        counter++;
        int max = arr[0];

        counter++;
        for (int num : arr) {
            counter++;
            counter++;

            if (num > max) {
                counter++;
                max = num;
            }
        }
        counter++;

        // Build count array
        counter++;
        int[] count = new int[max + 1];

        counter++;
        for (int num : arr) {
            counter++;
            counter++;

            counter++;
            count[num]++;
        }
        counter++;

        // Cumulative sum
        counter++;
        for (int i = 1; i <= max; i++) {
            counter++;
            counter++;

            counter++;
            count[i] += count[i - 1];
        }
        counter++;

        // Build output (stable sort)
        counter++;
        int[] output = new int[arr.length];

        counter++;
        for (int i = arr.length - 1; i >= 0; i--) {
            counter++;
            counter++;

            counter++;
            output[count[arr[i]] - 1] = arr[i];
            counter++;
            count[arr[i]]--;
        }
        counter++;

        // Copy back to original
        counter++;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            counter++;

            counter++;
            arr[i] = output[i];
        }
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
