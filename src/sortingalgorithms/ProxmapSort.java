package sortingalgorithms;

public class ProxmapSort {

    private static int counter = 0;

    private ProxmapSort() {
    }

    public static void useProxmapSort(int[] arr) {
        if (arr.length <= 1) {
            counter++;
            return;
        }

        counter++;
        int[] minMax = findMinAndMax(arr);

        if (minMax[0] == minMax[1]) {
            counter++;
            return;
        }

        counter++;
        int[] mapKey = new int[arr.length],
                prefixMap = buildPrefixMap(mapValuesAndCountHits(arr, mapKey, minMax[0], minMax[1])),
                result = positionGuidedInsert(arr, mapKey, prefixMap);

        counter++;
        System.arraycopy(result, 0, arr, 0, arr.length);
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
        int[] hitCount = new int[arr.length];
        counter++;
        double scale = (double) (arr.length - 1) / (max - min);

        counter++;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            counter++;

            counter++;
            hitCount[mapKey[i] = (int) (scale * (arr[i] - min))]++;
        }
        counter++;

        counter++;
        return hitCount;
    }

    private static int[] buildPrefixMap(int[] hitCount) {
        counter++;
        int n = hitCount.length, runningTotal = 0, prefixMap[] = new int[n];

        for (int i = 0; i < n; i++) {
            counter++;
            prefixMap[i] = runningTotal;
            counter++;
            runningTotal += hitCount[i];
        }

        counter++;
        return prefixMap;
    }

    private static int[] positionGuidedInsert(int[] arr, int[] mapKey, int[] prefixMap) {
        counter++;
        int[] result = new int[arr.length];
        counter++;
        boolean[] occupied = new boolean[arr.length];

        counter++;
        for (int i = 0; i < arr.length; i++) {
            counter++;
            counter++;

            while (occupied[prefixMap[mapKey[i]]] && result[prefixMap[mapKey[i]]] < arr[i]) {
                counter++;
                counter++;
                prefixMap[mapKey[i]]++;
            }

            insertWithRightShift(result, occupied, prefixMap[mapKey[i]], arr[i]);
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