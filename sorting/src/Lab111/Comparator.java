package Lab111;

public interface Comparator<K> {

    /**
     *
     * Method to compare values of two given instances.
     *
     * @param a first instance of a given class
     * @param b second instance of a given class
     * @return the numeric value of the difference between a and b
     */
    int compare(K a, K b);
}
