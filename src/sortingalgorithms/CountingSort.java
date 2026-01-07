package sortingalgorithms;

public class CountingSort {

    static int counter = 0;

    private CountingSort() {
    }

    public static void countingSort(int[] arr) {
        counter++;
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
                max = num;
                counter++;
            }
        }
        counter++;

        // Build count array
        counter++;
        int[] count = new int[max + 1];
        for (int num : arr) {
            counter++;
            count[num]++;
            counter++;
        }
        counter++;

        // Cumulative sum
        counter++;
        for (int i = 1; i <= max; i++) {
            counter++;
            counter++;
            count[i] += count[i - 1];
            if (i + 1 <= max) {
                counter++;
            }
        }
        counter++;
        counter++;

        // Build output (stable sort)
        counter++;
        int[] output = new int[arr.length];
        counter++;
        for (int i = arr.length - 1; i >= 0; i--) {
            counter++;
            counter++;
            output[count[arr[i]] - 1] = arr[i];
            counter++;
            count[arr[i]]--;
            if (i + 1 <= max) {
                counter++;
            }
        }
        counter++;
        counter++;

        // Copy back to original
        counter++;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            counter++;
            arr[i] = output[i];
            if (i + 1 <= max) {
                counter++;
            }
        }
        counter++;
        counter++;
    }
}
