void main() {
    IO.println("Hello, World!");

    long start = System.nanoTime();

    // ======= program start =======

    int[] randomArray = generateRandomArray(100, 100);
    System.out.println("Random Array: " + Arrays.toString(randomArray));

//    useInsertionSort(randomArray);
    useQuickSort(randomArray, 0, randomArray.length - 1);

    System.out.println("Sorted Array: " + Arrays.toString(randomArray));

    // =============================

    double duration = (double) (System.nanoTime() - start) / 1000000;
    System.out.println(duration + "ms");
}

static void useQuickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pivotIndex = partition(arr, low, high);
        useQuickSort(arr, low, pivotIndex - 1);
        useQuickSort(arr, pivotIndex + 1, high);
    }
}

static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
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