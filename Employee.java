//Dylan Hamilton
//11/13/25

public class Employee {
    String lastName;
    String firstName;
    String jobTitle;
    String department;
    double annualSalary;
    double estimatedAnnualMinusFurloughs;

    public Employee(String lastName, String firstName, String jobTitle,
                    String department, double annualSalary, double estMinusFurloughs) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
        this.department = department;
        this.annualSalary = annualSalary;
        this.estimatedAnnualMinusFurloughs = estMinusFurloughs;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + department + ")";
    }
}
