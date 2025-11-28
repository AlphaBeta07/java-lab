// Person.java
import java.time.LocalDate;
import java.time.Period;

public class Person {
    protected String name;
    protected LocalDate birthdate;
    protected double height, weight;
    protected String address;

    public Person(String name, LocalDate birth, double height, double weight, String address) {
        this.name = name; this.birthdate = birth; this.height = height; this.weight = weight; this.address = address;
    }
    public int calculateAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}

// Student.java
public class Student extends Person {
    private int rollNo;
    private int[] marks;

    public Student(String name, java.time.LocalDate birth, double h, double w, String addr, int roll, int[] marks) {
        super(name, birth, h, w, addr);
        this.rollNo = roll; this.marks = marks;
    }
    public double calculateAvg() {
        int sum = 0; for (int m : marks) sum += m; return sum / (double)marks.length;
    }
}

// EmployeeExt.java
public class EmployeeExt extends Person {
    private String empId;
    private double salary;
    public EmployeeExt(String name, java.time.LocalDate birth, double h, double w, String addr, String id, double salary) {
        super(name, birth, h, w, addr);
        this.empId = id; this.salary = salary;
    }
    public double calculateTax() {
        // simple tax example: 10% if salary>50000
        return salary > 50000 ? salary * 0.1 : salary * 0.05;
    }
}

// InheritanceTest.java
public class InheritanceTest {
    public static void main(String[] args) {
        Student s = new Student("Alice", java.time.LocalDate.of(2000,1,15), 5.5, 55, "City", 101, new int[]{80,90,85});
        EmployeeExt e = new EmployeeExt("Bob", java.time.LocalDate.of(1990,6,20), 5.8, 70, "Town", "E123", 60000);
        System.out.println("Student avg: " + s.calculateAvg());
        System.out.println("Employee tax: " + e.calculateTax());
        System.out.println("Student age: " + s.calculateAge());
    }
}
