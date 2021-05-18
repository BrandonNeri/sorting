package Lab111;

/**
 *
 * @author Brandon Neri
 * @version 04/23/2021
 *
 * Client.java is a Java Class that uses the Sort.java Class
 * to run a series of tests to see how long each sort method
 * takes to sort N number of employee's using the parameters 
 * of a given employee. The results are printed out into a
 * formatted ASCII table for review.
 *
 */
public class Client {

    public static void main(String[] args) {

        // Comparators
        NameComparator nameComp = new NameComparator();
        DeptComparator deptComp = new DeptComparator();
        IDComparator idComp = new IDComparator();
        HiredComparator hiredComp = new HiredComparator();
        
        // Number of Employee's in the given arrays
        int N = 50000;
        
        // Generate arrays of N Employee's for sorting tests
        Employee[] mergeEmpList = new Employee[N];
        Employee[] quickEmpList = new Employee[N];
        Employee[] bubbleEmpList = new Employee[N];
        Employee[] enhancedBubbleEmpList = new Employee[N];
        Employee[] radixEmpList = new Employee[N];
        
        // Add random Employee's to each array copy
        for (int i = 0; i < mergeEmpList.length; i++) {
            mergeEmpList[i] = new Employee();
            quickEmpList[i] = mergeEmpList[i];
            bubbleEmpList[i] = mergeEmpList[i];
            enhancedBubbleEmpList[i] = mergeEmpList[i];
            radixEmpList[i] = mergeEmpList[i];
        }
        
        // Merge Sort Using Name Comparator
        long start = System.currentTimeMillis();
        Sort.mergeSort(mergeEmpList, nameComp); // Run merge sort
        long stop = System.currentTimeMillis();
        long mergeSortTime = stop - start; // Get time difference
        
        // Quick Sort Using Dept Comparator
        start = System.currentTimeMillis();
        Sort.callQuickSort(quickEmpList, deptComp); // Run quick sort
        stop = System.currentTimeMillis();
        long quickSortTime = stop - start; // Get time difference
 
        // Simple Bubble Sort Using ID Comparator
        start = System.currentTimeMillis();
        Sort.simpleBubbleSort(bubbleEmpList, idComp); // Run simple bubble sort
        stop = System.currentTimeMillis();
        long bubbleSortTime = stop - start; // Get time difference
  
        // Enhanced Bubble Sort Using ID Comparator
        start = System.currentTimeMillis();
        Sort.enhancedBubbleSort(enhancedBubbleEmpList, idComp); // Run enhanced bubble sort
        stop = System.currentTimeMillis();
        long enhancedBubbleSortTime = stop - start; // Get time difference
        
        // Radix Sort Using Dept Comparator grouped to Hired Comparator, grouped to Name Comparator
        start = System.currentTimeMillis();
        Sort.radixSort(radixEmpList, deptComp, hiredComp, nameComp); // Run radix sort
        stop = System.currentTimeMillis();
        long radixSortTime = stop - start; // Get time difference
        
        // ASCII Time Table
        String bar = "+-------------------+-------------------+";
        System.out.printf(bar +"\n|   %30s      |\n" + bar + "\n", "Data Sorting: Timing Table");
        System.out.printf("|     %-12s  |     %-12s  |\n" + bar + "\n", "Sort Type", "Time (ms)");
        System.out.printf("|  %-15s  |  %-15s  |\n" + bar + "\n", "Merge", mergeSortTime);
        System.out.printf("|  %-15s  |  %-15s  |\n" + bar + "\n", "Quick", quickSortTime);
        System.out.printf("|  %-15s  |  %-15s  |\n" + bar + "\n", "Bubble", bubbleSortTime);
        System.out.printf("|  %-15s  |  %-15s  |\n" + bar + "\n", "Enhanced Bubble", enhancedBubbleSortTime);
        System.out.printf("|  %-15s  |  %-15s  |\n" + bar + "\n", "Radix", radixSortTime);
    }
}