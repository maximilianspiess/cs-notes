/*
 * Administration class
 */
package application;

import java.util.ArrayList;

import application.filters.BookPersonFilter;
import application.filters.IdFilter;
import application.filters.LendingItemFilter;
import application.filters.MoviePersonFilter;
import application.filters.TitleFilter;
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

	public LendingItem findItem(LendingItemFilter filter) {
		LendingItem found = null;
		for (LendingItem lendingItem : dataProvider.getItems()) {
			found = filter.filter(lendingItem);
			if (found != null) {
				break;
			}
		}
		return found;
	}

	public LendingItem findItem(long id) {
		return findItem(new IdFilter(id));
	}

	public LendingItem findItem(String title) {
		return findItem(new TitleFilter(title));
	}

	public LendingItem findItem(Person person) {
		LendingItem found = null;
		LendingItemFilter authorFilter = new BookPersonFilter(person);
		LendingItemFilter actorFilter = new MoviePersonFilter(person);
		for (LendingItem lendingItem : dataProvider.getItems()) {
			found = authorFilter.filter(lendingItem);
			if (found != null) {
				break;
			}
			found = actorFilter.filter(lendingItem);
			if (found != null) {
				break;
			}
		}
		return found;
	}
}
