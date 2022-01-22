package antesh;

import java.util.Comparator;
import java.util.List;

public class GroupBySortComparator {

    public static void main(String[] args) {
        List<Employee> employees = Employee.getEmployees();

        System.out.println(employees + "\n");

        Comparator<Employee> byIdComparator = Comparator.comparing(emp -> emp.getId());
        Comparator<Employee> byFirstNameComparator = Comparator.comparing(Employee::getFirstName);
        Comparator<Employee> byLastNameComparator = Comparator.comparing(Employee::getLastName);

        Comparator<Employee> groupByFirstNameLastNameComparator = byFirstNameComparator.thenComparing(byLastNameComparator);

        //sort by id only using comparator
        employees.sort(byIdComparator);
        System.out.println(employees + "\n");

        employees.sort(byFirstNameComparator);
        System.out.println(employees + "\n");

        employees.sort(byLastNameComparator);
        System.out.println(employees + "\n");

        employees.sort(groupByFirstNameLastNameComparator);
        System.out.println(employees + "\n");



    }


}
