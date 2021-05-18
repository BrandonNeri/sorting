package Lab111;

/**
 *
 * @author Brandon Neri
 * @version 04/24/2021
 *
 * HiredComparator.java is a java class that implements the 
 * Comparator generic interface. It compares the Hired year of 
 * two different Employee.java Class instances and returns 
 * the comparative value between the two.
 * 
 */
public class HiredComparator implements Comparator<Employee> {

    /**
     *
     * @param A a given Employee instance
     * @param B another given Employee instance
     * @return the comparative value between Employee's A and B Hired Year
     */
    @Override
    public int compare(Employee A, Employee B) {
        // Throws exception if given Employee is null
        if (A == null || B == null) {
            throw new NullPointerException();
        }
        
        // Get Hired Year's of Employee's A and B
        int empAHired = A.getHired();
        int empBHired = B.getHired();
        
        // Return the compareTo value between Employee's A and B
        if (empAHired < empBHired) {
            return -1;
        } else if (empAHired > empBHired) {
            return 1;
        } else {
            return 0;
        }
    }
}
