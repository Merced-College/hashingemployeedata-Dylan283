//Dylan Hamilton
//11/13/25

import java.util.Objects;

public class Employee {
    private String lastName;
    private String firstName;
    private String jobTitle;
    private String department;
    private double annualSalary;
    private double estimatedAnnualMinusFurloughs;

    // No-argument constructor
    public Employee() {
        this.lastName = "";
        this.firstName = "";
        this.jobTitle = "";
        this.department = "";
        this.annualSalary = 0.0;
        this.estimatedAnnualMinusFurloughs = 0.0;
    }

    // Parameterized constructor
    public Employee(String lastName, String firstName, String jobTitle,
                    String department, double annualSalary, double estMinusFurloughs) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.annualSalary = annualSalary;
        this.estimatedAnnualMinusFurloughs = estMinusFurloughs;
    }

    // Getters and Setters
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getAnnualSalary() { return annualSalary; }
    public void setAnnualSalary(double annualSalary) { this.annualSalary = annualSalary; }

    public double getEstimatedAnnualMinusFurloughs() { return estimatedAnnualMinusFurloughs; }
    public void setEstimatedAnnualMinusFurloughs(double estimatedAnnualMinusFurloughs) {
        this.estimatedAnnualMinusFurloughs = estimatedAnnualMinusFurloughs;
    }

    // equals() method: compares lastName, firstName, and department
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // same reference
        if (o == null || getClass() != o.getClass()) return false; // null or different class
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) &&
               Objects.equals(firstName, employee.firstName) &&
               Objects.equals(department, employee.department);
    }

    // hashCode() method: consistent with equals()
    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", department='" + department + '\'' +
                ", annualSalary=" + annualSalary +
                ", estimatedAnnualMinusFurloughs=" + estimatedAnnualMinusFurloughs +
                '}';
    }
}
