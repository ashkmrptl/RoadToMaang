package companies.paloaltonetworks;

public class Employee extends Person {
    private final String role;

    public Employee(String name, int age, String role) {
        super(name, age);
        this.role = role;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!super.equals(object) || getClass() != object.getClass()) {
            return false;
        }

        Employee employee = (Employee) object;
        return role != null ? role.equals(employee.role) : employee.role == null;
    }

    @Override
    public int hashCode() {
        int hashcode = super.hashCode();
        hashcode = 31 * hashcode + (role != null ? role.hashCode() : 0);
        return hashcode;
    }
}
