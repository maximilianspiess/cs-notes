package customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SomeCustomerTests {

	private final String[] names = { "Peter", null, "", "Pe" };
	private final int[] ids = { 1, 0, -1 };
	private final LocalDate[] dates = { LocalDate.now().minusYears(40), LocalDate.now().minusYears(25),
			LocalDate.now().minusYears(120), LocalDate.now().plusYears(2) };

	private Customer customer;

	@BeforeEach
	void setUp() {
		customer = new Customer(ids[0], names[0], dates[0]);
	}

	@Test
	void testCustomerSuccess() {
		assertNotNull(customer);
	}

	@Test
	void testCustomerException() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(ids[0], names[0], dates[2]));
		assertThrows(IllegalArgumentException.class, () -> new Customer(ids[0], names[0], dates[3]));
	}

	@Test
	void testSetIdSuccess() {
		CustomerService cs = new CustomerService();
		cs.addCustomer(customer);
		assertNotNull(cs.findOlderThan(10));
	}
}
