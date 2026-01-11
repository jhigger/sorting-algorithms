package sortingalgorithms;

public class WaveSort {
    private static int counter = 0;

    private WaveSort() {
    }

    public static void useWaveSort(int[] arr) {
        counter++;
        int n = arr.length;

        counter++;
        for (int i = 0; i < n; i += 2) {
            counter++;
            counter++;

            if (i > 0 && arr[i - 1] > arr[i]) {
                counter++;
                swap(arr, i - 1, i);
            }


            if (i < n - 1 && arr[i + 1] > arr[i]) {
                counter++;
                swap(arr, i + 1, i);
            }

        }
    }

    private static void swap(int[] arr, int i, int j) {
        counter++;
        int temp = arr[i];
        counter++;
        arr[i] = arr[j];
        counter++;
        arr[j] = temp;
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}