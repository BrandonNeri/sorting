package Lab111;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Brandon Neri
 * @version 04/23/2021
 *
 * Employee.java is a Java Class that stores information about
 * employees including their name, id, department, and their
 * year of hire. This information is determined randomly for
 * use in Client.java.
 * 
 */
public class Employee {

    private Random r = new Random();
    private int id = r.nextInt(100000000); // Range 0 to 99999999
    private String name = createName();
    private int dept = r.nextInt(5) + 1; // Range: 1 to 5
    private int hired = r.nextInt(27) + 1995; // Range: 1995 to 2021
    
    /**
     * 
     * @return the id of an employee
     */
    public int getId() {
        return id;
    }
    
    /**
     * 
     * @return the name of an employee
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return the department of an employee
     */
    public int getDept() {
        return dept;
    }

    /**
     * 
     * @return the year hired of an employee
     */
    public int getHired() {
        return hired;
    }
    
    /**
     * 
     * A method to create a "name" of length 5 to 10 
     * characters randomly.
     * 
     * @return a randomly generated name
     */
    private String createName() {
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] newName = new char[r.nextInt(6) + 5];
        for (int i = 0; i < newName.length; i++) {
            newName[i] = letters[r.nextInt(letters.length)];
        }
        return new String(newName);
    }
    
    /**
     * 
     * @return a string with the contents of the Employee Class
     */
    @Override
    public String toString() {
        return super.toString() + ":" + id + ":" + name + ":" + dept + ":" + hired;
    }

    /**
     * 
     * @param o an object to be compared to an Employee class instance
     * @return true if the objects are equal, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee e = (Employee) o;
        return id == e.id
                && name.equals(e.name)
                && dept == e.dept
                && hired == e.hired;
    }
}
