import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create your ChainingHashTable using zyBook code
        ChainingHashTable<String, Employee> table = new ChainingHashTable<>(11);

        // Make an ArrayList to store duplicate Employee objects
        ArrayList<Employee> duplicates = new ArrayList<>();

        // Counters to keep track of total employees and duplicates
        int totalLoaded = 0;
        int duplicatesFound = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Employee_data.csv"))) {
            String line = br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] cols = line.split(",", -1);
                if (cols.length < 6) continue;

                // Create the Employee object from the CSV
                Employee emp = new Employee(
                        cols[0].trim(),  // LAST NAME
                        cols[1].trim(),  // FIRST NAME
                        cols[2].trim(),  // JOB TITLE
                        cols[3].trim(),  // DEPARTMENT
                        parseMoney(cols[4]),
                        parseMoney(cols[5])
                );

                // Increment your total counter
                totalLoaded++;

                // Create the hash key using last + first name
                String key = (emp.getLastName() + emp.getFirstName()).toLowerCase();

                // Check for duplicates
                Employee existing = table.get(key);
                if (existing != null) {
                    if (existing.getDepartment().equalsIgnoreCase(emp.getDepartment())) {
                        // Duplicate found
                        duplicates.add(emp);
                        duplicatesFound++;
                    } else {
                        // Same name but different department → insert normally
                        table.insert(key, emp);
                    }
                } else {
                    // No existing employee → insert normally
                    table.insert(key, emp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print results
        System.out.println("Total employees loaded: " + totalLoaded);
        System.out.println("Duplicates found: " + duplicatesFound);

        if (!duplicates.isEmpty()) {
            System.out.println("Duplicate list:");
            for (Employee dup : duplicates) {
                System.out.println(dup);
            }
        } else {
            System.out.println("No duplicates found.");
        }
    }

    // helper for cleaning up salary strings
    private static double parseMoney(String s) {
        if (s == null || s.isBlank()) return 0.0;
        try {
            return Double.parseDouble(s.replace("$", "").replace(",", "").trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
