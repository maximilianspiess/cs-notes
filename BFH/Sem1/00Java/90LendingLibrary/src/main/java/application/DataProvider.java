/*
 * Data Provider of the public library.
 */

package application;

import java.util.ArrayList;
import java.util.List;

import data.Actor;
import data.Author;
import data.Book;
import data.Customer;
import data.LendingItem;
import data.Movie;

public class DataProvider {
	private ArrayList<Customer> customers;
	private ArrayList<LendingItem> items;

	public DataProvider() {
		customers = new ArrayList<>();
		items = new ArrayList<>();
	}

	public void initData() {

		// add some books and movies
		Author a1 = new Author("Franz", "Kafka");
		Author a2 = new Author("Thomas", "Mann");

		List<Actor> actors = new ArrayList<>();
		actors.add(new Actor("Anna", "Beta"));
		actors.add(new Actor("Gert", "Delta"));
		actors.add(new Actor("Ian", "Klein"));

		items.add(new Book(123456789, "Die Verwandlung", a1));
		items.add(new Book(784655423, "Das Urteil", a1));
		items.add(new Book(344655421, "Das Tor", a1));

		items.add(new Movie(5612345, "Sonne", actors));
		items.add(new Movie(6712345, "Mond", actors));
		items.add(new Movie(1672345, "Erde", actors));

		items.add(new Book(23456789, "Der Tod in Venedig", a2));
		items.add(new Book(84655423, "Der Zauberberg", a2));
		items.add(new Book(44655421, "Tristan", a2));
	}

	public void initLendings(LendingManager lendingManager) {
		for (int i = 1; i < 5; i++) {
			// add some customers
			customers.add(new Customer("Anton" + i, "Muster", "anton" + i + ".muster@bluewin.ch"));
			customers.add(new Customer("Berta" + i, "Muster", "berta" + i + ".muster@google.ch"));
		}
		// lend some random books and movies
		for (int i = 3; i < 6; i++) {
			lendingManager.lendItem(customers.get(i), items.get(i));
			lendingManager.lendItem(customers.get(i + 2), items.get(i));
		}
	}

	public ArrayList<LendingItem> getItems() {
		return items;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

}
