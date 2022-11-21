/*
 * Administration class
 */
package application;

import java.util.ArrayList;

import data.Book;
import data.LendingItem;
import data.Movie;
import data.Person;

public class CatalogLookup {
	private DataProvider dataProvider;

	public CatalogLookup(DataProvider dataProvider) {
		this.dataProvider = dataProvider;
	}

	public ArrayList<LendingItem> findItems(String title) {
		ArrayList<LendingItem> items = new ArrayList<LendingItem>();
		for (LendingItem item : dataProvider.getItems()) {
			if (item.getTitle().equals(title)) {
				items.add(item);
			}
		}
		return items;
	}

	public ArrayList<LendingItem> findItems(Person person) {
		ArrayList<LendingItem> items = new ArrayList<LendingItem>();
		for (LendingItem item : dataProvider.getItems()) {
			if (item instanceof Book book && book.getAuthor().equals(person)) {
				items.add(item);
			}
		}
		for (LendingItem item : dataProvider.getItems()) {
			if (item instanceof Movie movie && movie.getActors().contains(person)) {
				items.add(item);
			}
		}
		return items;
	}

	public ArrayList<LendingItem> findItems(long id) {
		ArrayList<LendingItem> items = new ArrayList<LendingItem>();
		for (LendingItem item : dataProvider.getItems()) {
			if (item.getId() == id) {
				items.add(item);
			}
		}
		return items;
	}
}
