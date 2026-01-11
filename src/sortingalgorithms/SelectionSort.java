package sortingalgorithms;

public class SelectionSort {
    private static int counter = 0;

    private SelectionSort() {
    }

    static void useSelectionSort(int[] arr) {
        counter++;
        int len = arr.length;
        counter++;
        int pos;
        counter++;
        int tmp;

        counter++;
        for (int i = 0; i < len; i++) {
            counter++;
            counter++;

            counter++;
            pos = i;

            counter++;
            for (int j = i + 1; j < len; j++) {
                counter++;
                counter++;

                if (arr[j] < arr[pos]) {
                    counter++;
                    pos = j;
                }
            }
            counter++;

            counter++;
            tmp = arr[i];
            counter++;
            arr[i] = arr[pos];
            counter++;
            arr[pos] = tmp;
        }
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}