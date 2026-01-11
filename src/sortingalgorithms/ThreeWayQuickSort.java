package sortingalgorithms;

/**
 * autor: Edimar Chaves Jr.
 * 02/10/2019 13:40:33
 *
 * @param <T> T is a generic comparable type (Integer for exemple)
 *            <p>
 *            The Three way quicksort it is an optimized version of traditional quicksort
 *            this one deals better with several occurrences of elements equal to the pivot.
 **/

public class ThreeWayQuickSort<T extends Comparable<T>> {
    private int counter = 0;

    /**
     * The main method.
     *
     * @param array a generic collection to be sorted.
     * @param left  the begin of the order.
     * @param right the end of the order.
     **/

    public void sort(T[] array, int left, int right) {
        if (left < right) {
            counter++;
            this.partition(array, left, right);
        }

    }

    /**
     * The partition of array method.
     *
     * @param array a generic collection to partition.
     * @param left  the begin of partition.
     * @param right the end of partition.
     */

    private void partition(T[] array, int left, int right) {

        if (left < right) {

            counter++;
            int start = left;
            counter++;
            int end = right;
            counter++;
            int i = left;
            counter++;
            T pivot = array[left];

            while (i <= end) {
                counter++;

                if (array[i].compareTo(pivot) < 0) {

                    counter++;
                    this.swap(array, start, i);
                    counter++;
                    start++;
                    counter++;
                    i++;

                } else if (array[i].compareTo(pivot) > 0) {

                    counter++;
                    this.swap(array, i, end);
                    counter++;
                    end--;

                } else {
                    counter++;
                    i++;
                }

            }

            sort(array, left, start - 1);
            sort(array, end + 1, right);
        }
    }

    /**
     * The swap method.
     *
     * @param array a generic collection.
     * @param i     the index of the element that will be swapped with the j-element.
     * @param j     the index of the element that will be swapped with de i-element.
     */

    private void swap(T[] array, int i, int j) {
        counter++;
        T temp = array[i];
        counter++;
        array[i] = array[j];
        counter++;
        array[j] = temp;
    }

    public int getCounter() {
        return counter;
    }
}
