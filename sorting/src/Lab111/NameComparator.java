package Lab111;

/**
 *
 * @author Brandon Neri
 * @version 04/24/2021
 *
 * NameComparator.java is a java class that implements the
 * Comparator generic interface. It compares the names of 
 * two different Employee.java Class instances and returns
 * the comparative value between the two.
 * 
 */
public class NameComparator implements Comparator<Employee>  {

    /**
     * 
     * @param A a given Employee instance
     * @param B another given Employee instance
     * @return the comparative value between Employee's A and B names
     */
    @Override
    public int compare(Employee A, Employee B) {
        // Throws exception if given Employee is null
        if (A == null || B == null) {
            throw new NullPointerException();
        }
        
        // Get names of Employee's A and B
        String empAName = A.getName();
        String empBName = B.getName();
        
        // Return the compareTo value between Employee's A and B
        return empAName.compareTo(empBName);
    }
}
