package data;

import java.util.Objects;

public abstract class Person {
    private final String firstName;
    private final String lastName;
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String toString() {
        return firstName + " " + lastName;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Person person)
			return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
		return false;
	}
}

