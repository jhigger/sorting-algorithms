package sortingalgorithms;

public class QuickSort {
    private static int counter = 0;

    private QuickSort() {
    }

    public static void useQuickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int low, int high) {
        counter++;

        if (low < high) {
            counter++;
            int p = partition(arr, low, high);

            sort(arr, low, p);
            sort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        counter++;
        int mid = low + (high - low) / 2;

        if (arr[mid] < arr[low]) swap(arr, low, mid);
        if (arr[high] < arr[low]) swap(arr, low, high);
        if (arr[high] < arr[mid]) swap(arr, mid, high);

        counter++;
        int pivot = arr[mid];
        counter++;
        int i = low;
        counter++;
        int j = high;

        while (true) {
            counter++;

            while (arr[i] < pivot) {
                counter++;
                counter++;
                i++;
            }
            while (arr[j] > pivot) {
                counter++;
                counter++;
                j--;
            }

            if (i >= j) {
                counter++;
                return j;
            }

            swap(arr, i, j);

            counter++;
            i++;
            counter++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        counter++;
        int temp = arr[i];
        counter++;
        arr[i] = arr[j];
        counter++;
        arr[j] = temp;
    }

    public static int getCounter() {
        return counter;
    }
}