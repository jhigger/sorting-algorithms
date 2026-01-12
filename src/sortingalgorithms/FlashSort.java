package sortingalgorithms;

public class FlashSort {
    private static int counter = 0;

    private FlashSort() {
    }

    public static void useFlashSort(int[] arr) {
        counter++;
        int n = arr.length;
        if (n <= 1) {
            counter++;
            return;
        }

        counter++;
        int min, max, start;

        if (n % 2 == 0) {
            if (arr[0] > arr[1]) {
                counter++;
                max = arr[0];
                counter++;
                min = arr[1];
            } else {
                counter++;
                max = arr[1];
                counter++;
                min = arr[0];
            }
            counter++;
            start = 2;
        } else {
            counter++;
            min = max = arr[0];
            counter++;
            start = 1;
        }

        counter++;
        for (int i = start; i < n - 1; i += 2) {
            counter++;
            counter++;
            if (arr[i] > arr[i + 1]) {
                counter++;
                if (arr[i] > max) max = arr[i];
                counter++;
                if (arr[i + 1] < min) min = arr[i + 1];
            } else {
                counter++;
                if (arr[i + 1] > max) max = arr[i + 1];
                counter++;
                if (arr[i] < min) min = arr[i];
            }
        }
        counter++;

        if (min == max) {
            counter++;
            return;
        }

        counter++;
        int m = (int) (n * 1.2);
        counter++;
        if (m <= 0) m = 1;
        counter++;
        int[] L = new int[m];

        counter++;
        for (int value : arr) {
            counter++;
            counter++;
            counter++;
            int k = (int) ((double) (m - 1) * (value - min) / (max - min));
            counter++;
            L[k]++;
        }
        counter++;

        counter++;
        for (int k = 1; k < m; k++) {
            counter++;
            counter++;
            counter++;
            L[k] += L[k - 1];
        }
        counter++;

        counter++;
        int nmove = 0;
        counter++;
        int j = 0;
        counter++;
        int k = m - 1;

        while (nmove < n - 1) {
            counter++;
            while (j >= L[k]) {
                counter++;
                counter++;
                j++;
                counter++;
                k = (int) ((double) (m - 1) * (arr[j] - min) / (max - min));
            }

            counter++;
            int flash = arr[j];

            while (j != L[k]) {
                counter++;
                counter++;
                k = (int) ((double) (m - 1) * (flash - min) / (max - min));
                counter++;
                int hold = arr[L[k] - 1];
                counter++;
                arr[L[k] - 1] = flash;
                counter++;
                flash = hold;
                counter++;
                L[k]--;
                counter++;
                nmove++;
            }
        }

        binaryInsertionSort(arr);
    }

    private static void binaryInsertionSort(int[] arr) {
        counter++;
        int n = arr.length;

        counter++;
        for (int i = 1; i < n; i++) {
            counter++;
            counter++;

            if (arr[i] >= arr[i - 1]) {
                counter++;
                continue;
            }

            counter++;
            int key = arr[i];
            counter++;
            int low = 0, high = i - 1;

            while (low <= high) {
                counter++;
                counter++;
                int mid = (low + high) >>> 1;

                if (key < arr[mid]) {
                    counter++;
                    high = mid - 1;
                } else {
                    counter++;
                    low = mid + 1;
                }
            }

            counter++;
            int nToMove = i - low;

            if (nToMove > 0) {
                counter++;
                System.arraycopy(arr, low, arr, low + 1, nToMove);
            }

            counter++;
            arr[low] = key;
        }
        counter++;
    }

    public static int getCounter() {
        return counter;
    }
}