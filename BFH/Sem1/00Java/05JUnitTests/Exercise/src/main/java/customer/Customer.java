package customer;

import java.time.LocalDate;

public class Customer {
	private int id;
	private String name;
	private LocalDate dateOfBirth;

	public Customer(int id, String name, LocalDate dateOfBirth) {
		this.setId(id);
		this.setName(name);
		this.setDateOfBirth(dateOfBirth);
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		if (id <= 0)
			throw new IllegalArgumentException();
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.length() < 2)
			throw new IllegalArgumentException();
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		if (dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())
				|| dateOfBirth.isBefore(LocalDate.now().minusYears(100)))
			throw new IllegalArgumentException();
		this.dateOfBirth = dateOfBirth;
	}
}
