package sortingalgorithms;

public class ModifiedCountingSort {

    private static int counter = 0;

    private ModifiedCountingSort() {
    }

    public static void useCountingSort(int[] arr) {
        counter++;

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
//        int condition = arr.length + 1;
//        counter += condition;
//        counter += condition - 1;
        for (int num : arr) {
            counter++;
            if (num < min) {
                counter++;
                min = num;
            }
            counter++;
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
//        int condition2 = arr.length + 1;
//        counter += condition2;
//        counter += condition2 - 1;
        for (int num : arr) {
            counter++;
            count[num - min]++;
        }
        counter++;

        // ===== Build output array directly without cumulative sum loop =====
        // Because we only care about final sorted array
        counter++;
        int index = 0;

        counter++;
        int condition3 = range + 1;
        counter += condition3;
        counter += condition3 - 1;
        for (int i = 0; i < range; i++) {
            counter++;
            while (count[i] > 0) {
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
