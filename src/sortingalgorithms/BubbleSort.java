package sortingalgorithms;

public class BubbleSort {
    private static int counter = 0;

    private BubbleSort() {
    }

    static void useBubbleSort(int[] arr) {
        counter++;
        int len = arr.length;
        counter++;
        int tmp;
        counter++;
        boolean flag;

        counter++;
        for (int i = 0; i < len; i++) {
            counter++;
            counter++;

            counter++;
            flag = false;

            counter++;
            for (int j = 0; j < len - i - 1; j++) {
                counter++;
                counter++;

                if (arr[j] > arr[j + 1]) {
                    counter++;
                    tmp = arr[j];
                    counter++;
                    arr[j] = arr[j + 1];
                    counter++;
                    arr[j + 1] = tmp;
                    counter++;
                    flag = true;
                }
                counter++;
            }
            counter++;

            if (!flag) {
                counter++;
                break;
            }
        }
    }

    public static int getCounter() {
        return counter;
    }
}
