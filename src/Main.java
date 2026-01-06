void main() {
    IO.println("Hello, World!");

    long start = System.nanoTime();

    // ======= program start =======

    int[] randomArray = generateRandomArray(10, 10);
    System.out.println("Random Array: " + Arrays.toString(randomArray));

    useInsertionSort(randomArray);

    // =============================

    long duration = (System.nanoTime() - start) / 1000000;
    System.out.println(duration + "ms");
}

public static void useInsertionSort(int[] arr) {
    int n = arr.length;

    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }

    System.out.println("Sorted Array: " + Arrays.toString(arr));
}

public static int[] generateRandomArray(int size, int maxRange) {
    int[] randomArray = new int[size];
    Random random = new Random();

    for (int i = 0; i < size; i++) {
        // nextInt(bound) generates a number from 0 (inclusive) to bound (exclusive)
        randomArray[i] = random.nextInt(maxRange);
    }

    return randomArray;
}