package antesh;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByMultipleFields {

    public static void main(String[] args) {
        // group by - multiple fields
        // Grouping by designation and Gender two properties and need to get the count.

        List<Employee> employees = Employee.getEmployees();

        Map<String, Map<String, Long>> multipleFieldsMap = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDesignation,
                                Collectors.groupingBy(Employee::getGender,
                                        Collectors.counting())));

        // printing the count based on the designation and gender.
        System.out.println("Group by on multiple properties" + multipleFieldsMap);

        /*
        * Collect the list of employees as List<Employee> instead of getting the count.
        * That means inner aggregated Map value type should be List.
        * To get the list, we should not pass the second argument for the second groupingBy() method.
        * */

        Map<String, Map<String, List<Employee>>> multipleFieldsMapList = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDesignation,
                                Collectors.groupingBy(Employee::getGender)));
        // printing the count based on the designation and gender.
        System.out.println("Group by on multiple properties and Map key as List" + multipleFieldsMapList);

    }
}
