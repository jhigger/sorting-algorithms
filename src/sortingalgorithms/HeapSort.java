package sortingalgorithms;

public class HeapSort {

    private static int counter = 0;

    private HeapSort() {
    }

    static void useHeapSort(int[] arr) {
        makeMaxHeap(arr);
        counter++;
        int tmp;

        counter++;
        for (int i = arr.length - 1; i > 0; i--) {
            counter++;
            counter++;

            counter++;
            tmp = arr[0];
            counter++;
            arr[0] = arr[i];
            counter++;
            arr[i] = tmp;
            adjustHeap(arr, 0, i);
        }
        counter++;
    }

    private static void makeMaxHeap(int[] arr) {
        counter++;
        int len = arr.length;

        counter++;
        for (int i = len / 2 - 1; i >= 0; --i) {
            counter++;
            counter++;

            adjustHeap(arr, i, len);
        }
        counter++;
    }

    private static void adjustHeap(int[] arr, int i, int n) {
        counter++;
        int j = 2 * i + 1;
        counter++;
        int tmp = arr[i];

        while (j < n) {
            counter++;

            if (j < n - 1 && arr[j] < arr[j + 1]) {
                counter++;
                j++;
            }
            if (tmp > arr[j]) {
                counter++;
                break;
            }
            counter++;
            arr[(j - 1) / 2] = arr[j];
            counter++;
            j = 2 * j + 1;
        }

        counter++;
        arr[(j - 1) / 2] = tmp;
    }

    public static int getCounter() {
        return counter;
    }
}