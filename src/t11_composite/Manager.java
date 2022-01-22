package t11_composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Manager extends Employee {

    /**
     * With this data structure we make sure that we are not adding employees
     * that we have added in the past.
     * This is static to be shared between all the managers
     **/
    static HashSet<Employee> hasAManager = new HashSet<>();

    /**
     * This list can contain Engineer or employee
     **/
    List<Employee> employees;

    public Manager() {
        employees = new ArrayList<>();
    }

    /**
     * Only add employee if he does not have a manager
     */
    public void addEmployee(Employee e) throws Exception {
        if (hasAManager.contains(e) || fineMe(e)) {
            throw new Exception("This employee already got a manager");
        }
        this.employees = employees;
        hasAManager.add(e);
    }

    /**Check if there is a top level manager (he is employee that does not have  a boss)
     * meaning that he does not have a manager (CEO  for example)
     * */
    private boolean fineMe(Employee e) {
        /**This e is me*/
        if(e == this){
            return true;
        }
        /**If this e is a manager continue search in a recursive way */
        if(e.getClass() == Manager.class){
            Manager m = (Manager) e;
            for(Employee emp : m.employees){
                if(fineMe(emp)){
                    return true;
                }
            }
        }

        return false;
    }
}
