package sortingalgorithms;

public class JesseSort {
    private static int counter = 0;

    private JesseSort() {
    }

    public static void useJesseSort(int[] arr) {
        counter++;
        int n = arr.length;
        counter++;
        int runSize = 64;

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
                    counter++;
                    if (arr[mid] <= arr[mid + 1]) {
                        counter++;
                        continue;
                    }
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        counter++;
        int n1 = m - l + 1;
        counter++;
        int n2 = r - m;
        counter++;
        int[] L = new int[n1];
        counter++;
        int[] R = new int[n2];

        counter++;
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        counter++;

        int i = 0, j = 0, k = l;
        counter++;
        while (i < n1 && j < n2) {
            counter++;
            if (L[i] <= R[j]) {
                counter++;
                arr[k++] = L[i++];
            } else {
                counter++;
                arr[k++] = R[j++];
            }
        }

        if (i < n1) {
            counter++;
            System.arraycopy(L, i, arr, k, n1 - i);
        }
        if (j < n2) {
            counter++;
            System.arraycopy(R, j, arr, k, n2 - j);
        }
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
            int low = left, high = i - 1;
            counter++;
            while (low <= high) {
                counter++;
                counter++;
                int mid = (low + high) >>> 1;
                counter++;
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