import org.junit.Test;

public class PersonTest {
    public Person p = new Person("test", "last");
    @Test
    public void getFirstName() {
        System.out.println(p.getFirstName());
    }

    @Test
    public void setFirstName() {
        p.setFirstName("first");
        System.out.println(p.getFirstName());
    }

    @Test
    public void getLastName() {
        System.out.println(p.getLastName());
    }

    @Test
    public void setLastName() {
        p.setLastName("test");

        System.out.println(p.getLastName());
    }
}