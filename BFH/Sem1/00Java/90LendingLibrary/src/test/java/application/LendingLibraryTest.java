package application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Actor;
import data.Author;
import data.Book;
import data.Customer;
import data.LendingItem;
import data.Movie;
import data.Person;
import data.State;

class LendingLibraryTest {
	private Author author;
	private Book book1;
	private Book book2;
	private Actor actor;
	private Movie movie1;
	private Movie movie2;
	private Customer customer1;
	private Customer customer2;
	private LendingManager lendingManager;

	@BeforeEach
	void setUp() {
		author = new Author("Franz", "Kafka");
		book1 = new Book(123456789, "Die Verwandlung", author);
		book2 = new Book(784655423, "XYZ", author);
		movie1 = new Movie(5612345,"Sonne");
		movie2 = new Movie(6712345,"Erde");
		actor = new Actor("A","B");
		movie1.addActor(actor);
		movie1.addActor(new Actor("C","D"));
		customer1 = new Customer("Anton", "Muster", "anton.muster@bluewin.ch");
		customer2 = new Customer("Peter", "Muster", "peter.muster@bluewin.ch");
		lendingManager = new LendingManager();
		lendingManager.lendItem(customer1, book2);
	}

	@Test
	void testItemState() {
		// check for  correct item state
		assertEquals(book1.getState(), State.AVAILABLE);
		assertEquals(movie1.getState(), State.AVAILABLE);
		
		assertEquals(book2.getState(), State.LENT);
		
		// check if a book can be lent if not available or can be lent twice
		book1.setState(State.RESERVED);
		assertNull(lendingManager.lendItem(customer1, book1));
		assertNull(lendingManager.lendItem(customer1, book2));
		movie2.setState(State.DAMAGED);
		assertNull(lendingManager.lendItem(customer1, movie2));
	}
	
	@Test
	void testLendItem() {
		Lending lending = lendingManager.lendItem(customer1, book1);
		// check if correct customer
		assertEquals(lending.getCustomer().getEmail(), customer1.getEmail());
		assertEquals(lending.getItem().getId(), book1.getId());
		assertNull(lendingManager.lendItem(customer1, book2));

		// check if book can be found in lendings
		assertEquals(lendingManager.findLending(book1).getItem().getId(), book1.getId());

		// check if a the found item is returned after a returnBook statement
		assertEquals(lendingManager.findLending(book1).getItem().getId(),
				lendingManager.returnItem(book1).getItem().getId());

		book1.setState(State.RESERVED);
		assertNull(lendingManager.lendItem(customer1, book1));
		assertNull(lendingManager.lendItem(customer1, book2));
	}

	@Test
	void testMovieActors() {
		assertEquals(2,movie1.getActors().size());
	}
	


	@Test
	void testReturnItem() {
		// lend a movie
		assertNull(lendingManager.findLending(movie1));
		lendingManager.lendItem(customer1, movie1);
		assertNull(lendingManager.findLending(movie1).getReturnDate());

		// check return date of a lent book
		assertEquals(movie1.getState(), State.LENT);

		// return book1
		lendingManager.returnItem(movie1);

		// check if returnDate has been set after a book return and check if book is
		// available
		assertNotNull(lendingManager.findLending(movie1).getReturnDate());
		assertEquals(movie1.getState(), State.AVAILABLE);
	}
	
	@Test
	void testGetNbOfBooklendings() {
		int number = lendingManager.getNbOfLendings();
		lendingManager.lendItem(customer1, book1);
		assertEquals(number + 1, lendingManager.getNbOfLendings());
	}
	
	@Test
	void testGetNbOfMovieLendings() {
		 int number = lendingManager.getNbOfLendings();
		 lendingManager.lendItem(customer1, movie1);
		 lendingManager.lendItem(customer2, movie2);
		 assertEquals(number + 2, lendingManager.getNbOfLendings());
	}
	
	@Test
	void testIsInstanceOf() {
		assertTrue(book1 instanceof LendingItem);
		assertTrue(movie1 instanceof LendingItem);
		assertTrue(customer1 instanceof Person);
		assertTrue(author instanceof Person);
		assertTrue(actor instanceof Person);
	}
	
}
