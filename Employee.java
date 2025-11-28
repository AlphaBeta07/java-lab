// Employee.java
public class Employee {
    private String firstName, lastName;
    private double monthlySalary;

    public Employee(String f, String l, double salary) {
        firstName = f;
        lastName = l;
        monthlySalary = salary > 0 ? salary : 0.0;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public double getMonthlySalary() { return monthlySalary; }
    public void setMonthlySalary(double s) { monthlySalary = s > 0 ? s : 0.0; }
    public double getYearlySalary() { return monthlySalary * 12; }
    public void raiseByPercent(double p) { monthlySalary *= (1 + p/100.0); }
}

// EmployeeTest.java
public class EmployeeTest {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", "Doe", 2000);
        Employee e2 = new Employee("Jane", "Smith", 3000);
        System.out.println("Yearly salaries:");
        System.out.println(e1.getFirstName() + ": " + e1.getYearlySalary());
        System.out.println(e2.getFirstName() + ": " + e2.getYearlySalary());
        e1.raiseByPercent(10); e2.raiseByPercent(10);
        System.out.println("After 10% raise:");
        System.out.println(e1.getFirstName() + ": " + e1.getYearlySalary());
        System.out.println(e2.getFirstName() + ": " + e2.getYearlySalary());
    }
}
