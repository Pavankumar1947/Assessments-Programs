package albertson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// write a program Increase salary 10% hose salary is lessthan 20,000


class Employee {
    private int id;
    private String name;
    private double salary;

 // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    

    public void display() {
        System.out.printf("ID: %d, Name: %s, Salary: %.2f%n", id, name, salary);
    }
}


public class SalaryIncrease {
	
	public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", 18000));
        employees.add(new Employee(2, "Bob", 22000));
        employees.add(new Employee(3, "Charlie", 15000));
        employees.add(new Employee(4, "David", 25000));

        System.out.println("Before Increment:");
        employees.forEach(Employee::display);
        incrementUsingMap(employees);

        System.out.println("\nAfter Increment:");
        employees.forEach(Employee::display);
	}
    
    public static List<Employee> incrementUsingMap(List<Employee> employees) {
        return employees.stream()
            .map(emp -> {
                if (emp.getSalary() < 20000) {
                    emp.setSalary(emp.getSalary() * 1.10);
                }
                return emp;
            })
            .collect(Collectors.toList());
    }

}
