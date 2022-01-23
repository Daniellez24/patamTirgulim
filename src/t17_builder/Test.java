package t17_builder;

public class Test {

    public static void main(String[] args) {
        // calling the PersonDetailsBuilder's constructor through PersonDetails class,
        // and then call build() to receive a PersonDetails object
        PersonDetails pd1 = new PersonDetails.PersonDetailsBuilder(123, "bla@bla.com").build();

        // whenever we finish setting the fields we want to set, call build()
        PersonDetails pd2 = new PersonDetails.PersonDetailsBuilder(123, "bla@bla.com").setAge((byte)18).setName("my name").build();

        // String and StringBuilder work the same way, with toString() as the build() method
        String s = new StringBuilder("my name").append(" ").append("!").reverse().toString();

    }
}
