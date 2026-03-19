/**
 * a very simple person class.
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person(name=" + name + ")";
    }

    public boolean equals(Person p) {
        return p.name.equals(name);
    }

    public int hashCode() {
        return name.hashCode();
    }
}
