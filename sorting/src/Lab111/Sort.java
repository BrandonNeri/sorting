package Lab111;

/**
 *
 * @author Brandon Neri
 * @version 04/23/2021
 *
 * Sort.java is a Java Class that implement a series of sorting 
 * algorithms. These sorting algorithms include a simple and 
 * enhanced bubble sort, merge sort, quick sort, radix sort, 
 * and a series of helper methods for these implemented sorts.
 *
 */
public class Sort {

    /**
     *
     * Simple Bubble Sort Method for an array.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @param comp a generic comparator
     */
    public static <K> void simpleBubbleSort(K[] S, Comparator<K> comp) {
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S.length - 1; j++) {
                if (comp.compare(S[j], S[j + 1]) <= 0) {
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;
                }
            }
        }
    }

    /**
     *
     * Enhanced Bubble Sort Method for an array.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @param comp a generic comparator
     */
    public static <K> void enhancedBubbleSort(K[] S, Comparator<K> comp) {
        if (S == null || S.length == 0) { return; } // Ignore if null
        boolean isSwapped;
        int size = S.length;
        for (int i = 0; i < size - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (comp.compare(S[j], S[j + 1]) <= 0) {
                    K temp = S[j];
                    S[j] = S[j + 1];
                    S[j + 1] = temp;
                    isSwapped = true; // Swapping occurred
                }
            }
            if (isSwapped == false) {
                break; // Exit if no swapping occurred 
            }
        }
    }

    /**
     *
     * Merge contents of arrays S1 and S2 into properly sized array S.
     *
     * @param <K> a generic type
     * @param S1 a generic array
     * @param S2 a generic array
     * @param S a generic array
     * @param comp a generic comparator
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
    }

    /**
     * Merge-Sort Method for an array.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @param comp a generic comparator
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) {
            return; // array is trivially sorted
        }
        int mid = n / 2; // divide
        K[] S1 = copyOfRange(S, 0, mid); // copy of first half
        K[] S2 = copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp); // sort copy of first half
        mergeSort(S2, comp); // sort copy of second half
        // merge results
        merge(S1, S2, S, comp); // merge sorted halves back into original
    }

    /**
     *
     * A method to copy a given range of an array.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @param start a starting index in an array
     * @param end an ending index in an array
     * @return
     */
    public static <K> K[] copyOfRange(K[] S, int start, int end) {
        K[] rangedArray = (K[]) new Object[end - start]; // A new array of ranged size
        for (int i = 0; i < end - start; i++) { // Add each element in the range
            rangedArray[i] = S[i + start];
        }
        return rangedArray;
    }

    /**
     *
     * Quick-Sort Method for a queue.
     *
     * @param <K> a generic type
     * @param S a generic queue
     * @param comp a generic comparator
     */
    public static <K> void quickSort(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) {
            return; // queue is trivially sorted
        } // divide  
        K pivot = S.first(); // using first as arbitrary pivot
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        while (!S.isEmpty()) { // divide original into L, E, and G
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if (c < 0) { // element is less than pivot
                L.enqueue(element);
            } else if (c == 0) { // element is equal to pivot
                E.enqueue(element);
            } else { // element is greater than pivot
                G.enqueue(element);
            }
        }
        // conquer
        quickSort(L, comp); // sort elements less than pivot
        quickSort(G, comp); // sort elements greater than pivot
        // concatenate results
        while (!L.isEmpty()) {
            S.enqueue(L.dequeue());
        }
        while (!E.isEmpty()) {
            S.enqueue(E.dequeue());
        }
        while (!G.isEmpty()) {
            S.enqueue(G.dequeue());
        }
    }
    
    /**
     * 
     * A calling method for the quickSort() method.
     * 
     * @param <K> a generic type
     * @param S a generic array
     * @param comp a generic comparator
     * @return an array that is sorted with the quickSort() method
     */
    public static <K> K[] callQuickSort(K[] S, Comparator<K> comp) {
        Queue<K> converted = arrayToQueue(S); // Convert to Queue
        quickSort(converted, comp); // Quick Sort Method
        K[] sortedArray = queueToArray(converted); // Convert back to Array
        return sortedArray;
    }

    /**
     *
     * A method to convert an array into a queue.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @return a queue equivalent of the given array
     */
    public static <K> Queue arrayToQueue(K[] S) {
        LinkedQueue lq = new LinkedQueue(); // Create new queue
        for (int i = 0; i < S.length; i++) { // Copy contents to queue
            lq.enqueue(S[i]);
        }
        return lq;
    }

    /**
     *
     * A method to convert a queue into an array.
     *
     * @param <K> a generic type
     * @param S a generic queue
     * @return a array equivalent of the given queue
     */
    public static <K> K[] queueToArray(Queue<K> S) {
        K[] newArray = (K[]) new Object[S.size()]; // Create new array
        for (int i = 0; i < newArray.length; i++) { // Copy contents to array
            newArray[i] = S.dequeue();
        }
        return newArray;
    }

    /**
     *
     * RadixSort for two keys.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @param first a generic Comparator
     * @param second a generic Comparator
     */
    public static <K> void radixSort(K[] S, Comparator<K> first, Comparator<K> second) {
        mergeSort(S, first);
        mergeSort(S, second);
    }

    /**
     *
     * RadixSort for three keys.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @param first a generic Comparator
     * @param second a generic Comparator
     * @param third a generic Comparator
     */
    public static <K> void radixSort(K[] S, Comparator<K> first, 
            Comparator<K> second, Comparator<K> third) {
        mergeSort(S, first);
        mergeSort(S, third);
        mergeSort(S, second);
    }

    /**
     *
     * RadixSort for four keys.
     *
     * @param <K> a generic type
     * @param S a generic array
     * @param first a generic Comparator
     * @param second a generic Comparator
     * @param third a generic Comparator
     * @param fourth a generic Comparator
     */
    public static <K> void radixSort(K[] S, Comparator<K> first, 
            Comparator<K> second, Comparator<K> third, Comparator<K> fourth) {
        mergeSort(S, first);
        mergeSort(S, third);
        mergeSort(S, second);
        mergeSort(S, fourth);
    }
}
