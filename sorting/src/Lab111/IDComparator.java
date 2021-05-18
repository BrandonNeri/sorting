package Lab111;

/**
 *
 * @author Brandon Neri
 * @version 04/24/2021
 *
 * IDComparator.java is a java class that implements the 
 * Comparator generic interface. It compares the ID of 
 * two different Employee.java Class instances and returns 
 * the comparative value between the two.
 *
 */
public class IDComparator implements Comparator<Employee> {
    
    /**
     * 
     * @param A a given Employee instance
     * @param B another given Employee instance
     * @return the comparative value between Employee's A and B ID's
     */
    @Override
    public int compare(Employee A, Employee B) {
        // Throws exception if given Employee is null
        if (A == null || B == null) {
            throw new NullPointerException();
        }
        
        // Get ID's of Employee's A and B
        int empAID = A.getId();
        int empBID = B.getId();

        // Return the compareTo value between Employee's A and B
        if (empAID < empBID) {
            return -1;
        } else if (empAID > empBID) {
            return 1;
        } else {
            return 0;
        }
    }
}
