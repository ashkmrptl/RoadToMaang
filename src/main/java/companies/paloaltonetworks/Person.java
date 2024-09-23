package companies.paloaltonetworks;

public class Person {
    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Person p = (Person) object;
        if (age != p.age) {
            return false;
        }

        return name != null ? name.equals(p.name) : p.name == null;
    }

    @Override
    public int hashCode() {
        int hashcode = 17;
        hashcode = 31 * hashcode + (name != null ? name.hashCode() : 0);
        hashcode = 31 * hashcode + age;

        return hashcode;
    }

}
