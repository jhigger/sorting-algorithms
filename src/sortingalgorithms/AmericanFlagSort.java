package sortingalgorithms;

import java.util.Stack;

public class AmericanFlagSort {
    private static int counter = 0;

    public static void useAmericanFlagSort(int[] arr) {
        counter++;
        int n = arr.length;
        if (n <= 1) {
            counter++;
            return;
        }

        counter++;
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            counter++;
            counter++;
            if (arr[i] > max) {
                counter++;
                max = arr[i];
            }
        }

        counter++;
        int maxDivisor = 1;
        while (max / maxDivisor >= 10) {
            counter++;
            maxDivisor *= 10;
        }

        // Stack stores: {start, end, currentDivisor}
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, n, maxDivisor});
        counter += 2;

        while (!stack.isEmpty()) {
            counter++;
            int[] range = stack.pop();
            int start = range[0];
            int end = range[1];
            int divisor = range[2];

            if (divisor < 1 || start >= end) {
                counter++;
                continue;
            }

            counter++;
            int[] count = new int[10];
            int[] offset = new int[10];
            int[] nextOffsets = new int[10];

            // 1. Distribution Count
            counter++;
            for (int i = start; i < end; i++) {
                counter++;
                int digit = (arr[i] / divisor) % 10;
                count[digit]++;
                counter++;
            }

            // 2. Compute Offsets
            counter++;
            offset[0] = start;
            nextOffsets[0] = start;
            for (int i = 1; i < 10; i++) {
                counter++;
                offset[i] = offset[i - 1] + count[i - 1];
                nextOffsets[i] = offset[i];
                counter++;
            }

            // 3. In-place Permutation
            counter++;
            for (int digit = 0; digit < 10; digit++) {
                counter++;
                // While there are elements belonging to this 'stripe' that aren't here yet
                while (count[digit] > 0) {
                    counter++;
                    int origin = nextOffsets[digit];
                    int currentDigit = (arr[origin] / divisor) % 10;
                    counter++;

                    if (currentDigit == digit) {
                        counter++;
                        nextOffsets[digit]++;
                        count[digit]--;
                    } else {
                        counter++;
                        int dest = nextOffsets[currentDigit];
                        int temp = arr[dest];
                        arr[dest] = arr[origin];
                        arr[origin] = temp;
                        counter++;
                        count[currentDigit]--;
                        nextOffsets[currentDigit]++;
                    }
                }
            }

            // 4. Push next digit ranges to stack
            if (divisor > 1) {
                counter++;
                int nextDiv = divisor / 10;
                for (int i = 0; i < 10; i++) {
                    counter++;
                    int bStart = (i == 0) ? start : offset[i];
                    int bEnd = nextOffsets[i];
                    if (bEnd - bStart > 1) {
                        counter++;
                        stack.push(new int[]{bStart, bEnd, nextDiv});
                    }
                }
            }
        }
    }

    public static int getCounter() {
        return counter;
    }
}