package sortingalgorithms;

public class AddressCalculationSort {
    private static int counter = 0;

    public static void useAddressCalculationSort(int[] arr) {
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
        int numBuckets = n;
        counter++;
        int[] bucketCount = new int[numBuckets];
        counter++;
        int[] bucketMap = new int[n];
        counter++;
        double range = (double) max - min;

        counter++;
        for (int i = 0; i < n; i++) {
            counter++;
            counter++;
            counter++;
            int addr = (int) ((numBuckets - 1) * (arr[i] - min) / range);
            counter++;
            bucketMap[i] = addr;
            counter++;
            bucketCount[addr]++;
        }
        counter++;

        counter++;
        int[] offset = new int[numBuckets];
        for (int i = 1; i < numBuckets; i++) {
            counter++;
            counter++;
            counter++;
            offset[i] = offset[i - 1] + bucketCount[i - 1];
            counter++;
        }
        counter++;

        counter++;
        int[] sorted = new int[n];
        counter++;
        int[] currentOffset = offset.clone();
        counter++;
        for (int i = 0; i < n; i++) {
            counter++;
            counter++;
            counter++;
            int addr = bucketMap[i];
            counter++;
            sorted[currentOffset[addr]++] = arr[i];
        }
        counter++;

        counter++;
        for (int i = 0; i < numBuckets; i++) {
            counter++;
            counter++;
            counter++;
            int bStart = offset[i];
            counter++;
            int bEnd = (i == numBuckets - 1) ? n : offset[i + 1];

            if (bEnd - bStart > 1) {
                counter++;
                for (int m = bStart + 1; m < bEnd; m++) {
                    counter++;
                    int key = sorted[m];
                    counter++;
                    int j = m - 1;
                    while (j >= bStart && sorted[j] > key) {
                        counter++;
                        counter++;
                        sorted[j + 1] = sorted[j];
                        j--;
                        counter++;
                    }
                    sorted[j + 1] = key;
                    counter++;
                }
            }
        }
        counter++;

        counter++;
        System.arraycopy(sorted, 0, arr, 0, n);
    }

    public static int getCounter() {
        return counter;
    }
}