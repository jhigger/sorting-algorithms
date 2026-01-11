package sortingalgorithms;

public class ModifiedCountingSort {

    private static int counter = 0;

    private ModifiedCountingSort() {
    }

    public static void useCountingSort(int[] arr) {
        if (arr.length == 0) {
            counter++;
            return;
        }

        // ===== Find min and max in a single pass (optimization) =====
        counter++;
        int min = arr[0];
        counter++;
        int max = arr[0];

        counter++;
        for (int num : arr) {
            counter++;
            counter++;

            if (num < min) {
                counter++;
                min = num;
            }
            if (num > max) {
                counter++;
                max = num;
            }
        }
        counter++;

        // ===== Allocate count array only for the needed range =====
        counter++;
        int range = max - min + 1;
        counter++;
        int[] count = new int[range];

        // ===== Fill count array =====
        counter++;
        for (int num : arr) {
            counter++;
            counter++;

            counter++;
            count[num - min]++;
        }
        counter++;

        // ===== Build output array directly without cumulative sum loop =====
        // Because we only care about final sorted array
        counter++;
        int index = 0;

        counter++;
        for (int i = 0; i < range; i++) {
            counter++;
            counter++;

            while (count[i] > 0) {
                counter++;

                counter++;
                arr[index++] = i + min;
                counter++;
                count[i]--;
            }
        }
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
