package antesh;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String designation;
    private String gender;

    public Employee(int id, String firstName, String lastName, String designation, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee {" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", designation='" + designation + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Antesh", "Sharma", "sd", "male"));
        employees.add(new Employee(5, "Dheeraj", "Sharma", "sd", "male"));
        employees.add(new Employee(2, "Sachin", "Mahamuni", "ssd", "male"));
        employees.add(new Employee(4, "Prerana", "Tendulakar", "sd", "female"));
        employees.add(new Employee(3, "Rahul", "Sharma", "ssd", "male"));
        employees.add(new Employee(7, "Sneha", "Shinde", "sd", "female"));
        employees.add(new Employee(6, "Dheeraj", "Yadav", "lead", "male"));

        return employees;
    }
}
