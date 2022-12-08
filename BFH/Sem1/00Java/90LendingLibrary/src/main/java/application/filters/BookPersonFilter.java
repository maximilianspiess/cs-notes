package application.filters;

/*
 * Filters LendingItems which are books and have a given author
 */

import data.Book;
import data.LendingItem;
import data.Person;

public final class BookPersonFilter implements LendingItemFilter {
	private final Person person;

	public BookPersonFilter(Person person) {
		this.person = person;
	}

	@Override
	public LendingItem filter(LendingItem lendingItem) {
		if (lendingItem instanceof Book book && book.getAuthor().equals(person)) {
			return lendingItem;
		}
		return null;
	}
}
