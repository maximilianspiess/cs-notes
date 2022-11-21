package customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

	private List<Customer> customers = new ArrayList<>();

	public List<Customer> findAll() {
		return customers;
	}

	public Customer findById(int id) {
		for (Customer c : customers) {
			if (c.getId() == id)
				return c;
		}
		throw new IllegalArgumentException();
	}

	public List<Customer> findOlderThan(int years) {
		List<Customer> result = new ArrayList<>();
		for (Customer c : customers) {
			if (LocalDate.now().getYear() - c.getDateOfBirth().getYear() > years)
				result.add(c);
		}
		return result;
	}

	public List<Customer> findAllByIds(List<Integer> intList) {
		List<Customer> result = new ArrayList<>();
		for (Customer c : customers) {
			if (intList.contains(c.getId())) {
				result.add(c);
			}
		}
		return result;
	}

	public List<Customer> findAllByNames(List<String> stringList) {
		List<Customer> result = new ArrayList<>();
		for (Customer c : customers) {
			if (stringList.contains(c.getName())) {
				result.add(c);
			}
		}
		return result;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

}
