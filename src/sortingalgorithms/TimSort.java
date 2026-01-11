package sortingalgorithms;

public class TimSort {
    private static int counter = 0;

    private TimSort() {
    }

    public static void useTimSort(int[] arr) {
        counter++;
        int n = arr.length;
        counter++;
        int runSize = 10;

        counter++;
        for (int i = 0; i < n; i += runSize) {
            counter++;
            counter++;

            insertionSort(arr, i, Math.min(i + runSize - 1, n - 1));
        }
        counter++;

        counter++;
        for (int size = runSize; size < n; size *= 2) {
            counter++;
            counter++;

            counter++;
            for (int left = 0; left < n; left += 2 * size) {
                counter++;
                counter++;

                counter++;
                int mid = left + size - 1;
                counter++;
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
            counter++;
        }
        counter++;
    }

    private static void insertionSort(int[] arr, int left, int right) {
        counter++;
        for (int i = left + 1; i <= right; i++) {
            counter++;
            counter++;

            counter++;
            int key = arr[i];

            if (key >= arr[i - 1]) {
                counter++;
                continue;
            }

            counter++;
            int low = left;
            counter++;
            int high = i - 1;

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

    private static void merge(int[] arr, int l, int m, int r) {
        counter++;
        if (arr[m] <= arr[m + 1]) return;
        counter++;
        int[] temp = new int[r - l + 1];
        counter++;
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            counter++;

            if (arr[i] <= arr[j]) {
                counter++;
                temp[k++] = arr[i++];
            } else {
                counter++;
                temp[k++] = arr[j++];
            }
        }

        if (i <= m) {
            counter++;
            System.arraycopy(arr, i, temp, k, m - i + 1);
        }

        if (j <= r) {
            counter++;
            System.arraycopy(arr, j, temp, k, r - j + 1);
        }

        counter++;
        System.arraycopy(temp, 0, arr, l, temp.length);
    }

    public static int getCounter() {
        return counter;
    }
}