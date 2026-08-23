/*
 * TOPIC: Abstract class
 * Analogy: A job contract template with required duties but no exact execution details.
 * Link: Pairs well with runtime polymorphism.
 */
public class AbstractClassDemo {
    static abstract class Employee {
        String name;
        Employee(String name) { this.name = name; }
        abstract double salary();
        void intro() { System.out.println("I am " + name); }
    }
    static class FullTimeEmployee extends Employee {
        double monthly;
        FullTimeEmployee(String name, double monthly) { super(name); this.monthly = monthly; }
        @Override double salary() { return monthly; }
    }

    public static void main(String[] args) {
        Employee e = new FullTimeEmployee("Ari", 50000); // Cannot instantiate abstract Employee directly.
        e.intro(); // Concrete inherited method from abstract parent.
        System.out.println("Beginner salary: " + e.salary()); // Abstract method implemented by subclass.

        Employee[] team = {new FullTimeEmployee("Ben", 60000), new FullTimeEmployee("Cara", 55000)};
        double total = 0;
        for (Employee x : team) total += x.salary();
        System.out.println("Intermediate payroll: " + total);

        System.out.println("Pro: abstract class shares state+behavior, unlike interfaces focused on contract only.");
    }
}

/*
 * Pitfalls: trying to create abstract object, forgetting to implement abstract methods, mixing unrelated responsibilities.
 * Practice: abstract Payment, abstract Animal movement, abstract Report generator.
 */

