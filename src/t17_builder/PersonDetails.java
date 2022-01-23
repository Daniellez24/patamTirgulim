package t17_builder;

public class PersonDetails {
    /** we want every detail to be initialized only once. but we don't have to get all of them - only the required ones.
     the client can decide which other fields he wants to fill - but once he does it, they're final.
     also, we want to have IOC (inversion of control) = the order of initializing the fields doesn't matter **/

    final int id; // required
    final String email; // required
    final String name;
    final String surname;
    final String middleName;
    final String webURL;
    final byte age;
    //..

    // the constructor copies the fields arguments from the PersonDetailsBuilder, and now we have a final PersonDetails
    // now we can't make any more changes to the fields - they're all final
    // the constructor is private so no one can use this constructor, besides PersonDetailsBuilder
    private PersonDetails(PersonDetailsBuilder pb){
        id = pb.id;
        email = pb.email;
        name = pb.name;
        surname = pb.surname;
        middleName = pb.middleName;
        webURL = pb.webURL;
        age = pb.age;
    }

    // we can reach this class through the PrivateDetails class
    public static class PersonDetailsBuilder{
        // only the required fields are final - receive them in the constructor.
        // the rest of the fields can be initialized with setters
        final int id; // required
        final String email; // required
        String name;
        String surname;
        String middleName;
        String webURL;
        byte age;

        public PersonDetailsBuilder(int id, String email) {
            this.id = id;
            this.email = email;
        }

        // every setter returns "this", in order to have fluent programming
        public PersonDetailsBuilder setName(String name){
            this.name = name;
            return this;
        }

        public PersonDetailsBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonDetailsBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonDetailsBuilder setWebURL(String webURL) {
            this.webURL = webURL;
            return this;
        }

        public PersonDetailsBuilder setAge(byte age) {
            this.age = age;
            return this;
        }

        // returns the final PersonDetails by calling its private constructor
        // (can be done because PersonDetailsBuilder is an inner class in the class PersonDetails)
        public PersonDetails build(){
            return new PersonDetails(this);
        }
    }


}
