package data;

public class Customer extends Person {

    private final String email;

    public Customer(String firstName, String lastName, String email) {
    	super(firstName, lastName);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
    	return super.toString() + " " + email;
    }

}
