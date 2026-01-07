package sortingalgorithms;

public class CountingSort {

    private static int counter = 0;

    private CountingSort() {
    }

    public static void useCountingSort(int[] arr) {
        counter++;
        if (arr.length == 0) {
            counter++;
            return;
        }

        // Find max value
        counter++;
        int max = arr[0];

        counter++;
//        int condition = arr.length + 1;
//        counter += condition;
//        counter += condition - 1;
        for (int num : arr) {
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
//        int condition2 = count.length + 1;
//        counter += condition2;
//        counter += condition2 - 1;
        for (int num : arr) {
            counter++;
            count[num]++;
        }
        counter++;

        // Cumulative sum
        counter++;
        int condition3 = max - 1 + 2;
        counter += condition3;
        counter += condition3 - 1;
        for (int i = 1; i <= max; i++) {
            counter++;
            count[i] += count[i - 1];
        }
        counter++;

        // Build output (stable sort)
        counter++;
        int[] output = new int[arr.length];

        counter++;
        int condition4 = max - 1 + 2;
        counter += condition4;
        counter += condition4 - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            counter++;
            output[count[arr[i]] - 1] = arr[i];
            counter++;
            count[arr[i]]--;
        }
        counter++;

        // Copy back to original
        counter++;
        int condition5 = max - 1 + 2;
        counter += condition5;
        counter += condition5 - 1;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            arr[i] = output[i];
        }
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
