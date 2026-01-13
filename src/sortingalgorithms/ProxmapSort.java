package sortingalgorithms;

public class ProxmapSort {

    private static int counter = 0;

    private ProxmapSort() {
    }

    public static void useProxmapSort(int[] arr) {
        counter++;
        int n = arr.length;

        if (n <= 1) {
            counter++;
            return;
        }

        counter++;
        int[] minMax = findMinAndMax(arr);
        counter++;
        int min = minMax[0], max = minMax[1];

        if (min == max) {
            counter++;
            return;
        }

        counter++;
        int[] mapKey = new int[n],
                hitCount = mapValuesAndCountHits(arr, mapKey, min, max),
                prefixMap = buildPrefixMap(hitCount),
                result = positionGuidedInsert(arr, mapKey, prefixMap);

        counter++;
        System.arraycopy(result, 0, arr, 0, n);
    }

    private static int[] findMinAndMax(int[] arr) {
        counter++;
        int n = arr.length, min, max, i;

        if (n % 2 == 0) {
            if (arr[0] < arr[1]) {
                counter++;
                min = arr[0];
                counter++;
                max = arr[1];
            } else {
                counter++;
                min = arr[1];
                counter++;
                max = arr[0];
            }
            counter++;
            i = 2;
        } else {
            counter++;
            min = arr[0];
            counter++;
            max = arr[0];
            counter++;
            i = 1;
        }

        while (i < n - 1) {
            counter++;
            if (arr[i] < arr[i + 1]) {
                if (arr[i] < min) {
                    counter++;
                    min = arr[i];
                }
                if (arr[i + 1] > max) {
                    counter++;
                    max = arr[i + 1];
                }
            } else {
                if (arr[i + 1] < min) {
                    counter++;
                    min = arr[i + 1];
                }
                if (arr[i] > max) {
                    counter++;
                    max = arr[i];
                }
            }
            counter++;
            i += 2;
        }

        counter++;
        return new int[]{min, max};
    }

    private static int[] mapValuesAndCountHits(int[] arr, int[] mapKey, int min, int max) {
        counter++;
        int n = arr.length;
        counter++;
        int[] hitCount = new int[n];

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

        counter++;
        return hitCount;
    }

    private static int[] buildPrefixMap(int[] hitCount) {
        counter++;
        int n = hitCount.length, runningTotal = 0;
        counter++;
        int[] prefixMap = new int[n];

        counter++;
        for (int i = 0; i < n; i++) {
            counter++;
            counter++;

            counter++;
            prefixMap[i] = runningTotal;
            counter++;
            runningTotal += hitCount[i];
        }
        counter++;

        counter++;
        return prefixMap;
    }

    private static int[] positionGuidedInsert(int[] arr, int[] mapKey, int[] prefixMap) {
        counter++;
        int n = arr.length;

        counter++;
        int[] result = new int[n];
        counter++;
        boolean[] occupied = new boolean[n];

        counter++;
        for (int i = 0; i < n; i++) {
            counter++;
            counter++;

            counter++;
            int dest = prefixMap[mapKey[i]];

            while (occupied[dest] && result[dest] < arr[i]) {
                counter++;
                counter++;
                dest++;
            }

            insertWithRightShift(result, occupied, dest, arr[i]);
        }
        counter++;

        counter++;
        return result;
    }

    private static void insertWithRightShift(int[] result, boolean[] occupied, int dest, int value) {
        if (!occupied[dest]) {
            counter++;
            result[dest] = value;
            counter++;
            occupied[dest] = true;
            counter++;
            return;
        }

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
            result[temp] = result[temp - 1];
            counter++;
            occupied[temp] = true;
            counter++;
            temp--;
        }

        counter++;
        result[dest] = value;
        counter++;
        occupied[dest] = true;
    }

    public static int getCounter() {
        return counter;
    }
}