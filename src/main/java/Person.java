import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected String address;
    protected OptionalInt age = OptionalInt.empty();
    //...

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        //...
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        //...
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return this.address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }
        @Override
        public String toString() {
            return String.format("%s %s [age: %s address: %s]",
                    name,
                    surname,
                    (age.isPresent() ? age.getAsInt() : "unknown!"),
                    (!address.isEmpty() ? address : "unknown!"));
        }

    public PersonBuilder newChildBuilder() {
      return new PersonBuilder().setSurname(surname).setAddress(address);
    }
}

