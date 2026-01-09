public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String index;

    public Student(String firstName, String lastName, int age, String index) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.index = index;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getIndex() { return index; }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + "), index: " + index;
    }
}
