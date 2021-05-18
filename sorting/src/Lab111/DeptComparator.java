package Lab111;

/**
 *
 * @author Brandon Neri
 * @version 04/24/2021
 *
 * DeptComparator.java is a java class that implements the 
 * Comparator generic interface. It compares the Dept of 
 * two different Employee.java Class instances and returns 
 * the comparative value between the two.
 *
 */
public class DeptComparator implements Comparator<Employee> {
    
    /**
     * 
     * @param A a given Employee instance
     * @param B another given Employee instance
     * @return the comparative value between Employee's A and B Dept
     */
    @Override
    public int compare(Employee A, Employee B) {
        // Throws exception if given Employee is null
        if (A == null || B == null) {
            throw new NullPointerException();
        }
        
        // Get Dept's of Employee's A and B
        int empADept = A.getDept();
        int empBDept = B.getDept();
        
        // Return the compareTo value between Employee's A and B
        if (empADept < empBDept) {
            return -1;
        } else if (empADept > empBDept) {
            return 1;
        } else {
            return 0;
        }
    }
}
