package companies.paloaltonetworks;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. hashCode() / equals() problem
 * Consider these two simple classes
 * public class Person {
 * private final int age;
 * private final String name;
 * public Person(String name, int age) {
 * this.name = name;
 * this.age = age;
 * }
 * }
 * public class Employee extends Person {
 * private final String role;
 * public Employee(String name, int age, String role) {
 * super(name, age);
 * this.role = role;
 * }
 * }
 * The task is to write appropriate hashCode() and equals()methods for both classes.
 * Nothing from the above source should be modified but additional fields and methods can be
 * added. Instances of Person and Employee should never be equal to one another. An
 * Employee is equal to another Employee if the role, age, and name are all equal between
 * instances. A Person is equal to another Person instance if the age and name are both equal
 * between instances.
 */
public class ProblemOne {

    public static void main(String[] args) {
        Employee e1 = new Employee("Ashish", 34, "CTO");

        Map<Person, String> map = new HashMap<>();
        map.put(e1, "Employee name: Ashish");

        Employee e2 = new Employee("Ashish", 34, "CTO");
        System.out.println(map.get(e2));
        System.out.println(e1.equals(e2));

        Person p1 = new Person("Ashish", 34);
        Person p2 = e1;

        System.out.println(map.get(p1));
        System.out.println(p1.equals(p2));
    }

}

