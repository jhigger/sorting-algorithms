package sortingalgorithms;

public class ProxmapSort {
    private static int counter = 0;

    public static void useProxmapSort(int[] arr) {
        counter++;
        int n = arr.length;
        if (n <= 1) {
            counter++;
            return;
        }

        // 1. Tournament Min-Max (Optimized Scan)
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

        // 2. Mapping & Hit Counting (Consolidated)
        counter++;
        int[] hitCount = new int[n];
        counter++;
        int[] mapKey = new int[n];
        counter++;
        double scale = (double) (n - 1) / (max - min);

        counter++;
        for (int i = 0; i < n; i++) {
            counter++;
            counter++;
            counter++;
            int key = (int) (scale * (arr[i] - min));
            counter++;
            mapKey[i] = key;
            counter++;
            hitCount[key]++;
        }
        counter++;

        // 3. ProxMap Construction
        counter++;
        int[] proxMap = new int[n];
        counter++;
        int runningTotal = 0;
        for (int i = 0; i < n; i++) {
            counter++;
            counter++;
            counter++;
            proxMap[i] = runningTotal;
            counter++;
            runningTotal += hitCount[i];
        }
        counter++;

        // 4. Dense Insertion Pass
        counter++;
        int[] result = new int[n];
        counter++;
        boolean[] occupied = new boolean[n];

        counter++;
        for (int i = 0; i < n; i++) {
            counter++;
            counter++;
            counter++;
            int key = mapKey[i];
            counter++;
            int dest = proxMap[key];

            // Localized search and shift
            counter++;
            while (occupied[dest] && result[dest] < arr[i]) {
                counter++;
                dest++;
            }

            if (!occupied[dest]) {
                counter++;
                result[dest] = arr[i];
                counter++;
                occupied[dest] = true;
            } else {
                counter++;
                int temp = dest;
                while (occupied[temp]) {
                    counter++;
                    counter++;
                    temp++;
                }
                while (temp > dest) {
                    counter++;
                    counter++;

                    counter++;
                    result[temp] = result[temp - 1];
                    counter++;
                    occupied[temp] = true;
                    counter++;
                    temp--;
                }
                counter++;
                result[dest] = arr[i];
                counter++;
                occupied[dest] = true;
            }
        }
        counter++;

        counter++;
        System.arraycopy(result, 0, arr, 0, n);
    }

    public static int getCounter() {
        return counter;
    }
}