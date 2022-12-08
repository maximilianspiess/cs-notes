/*
 * Filters LendingItems which are movies and have a given actor
 */
package application.filters;

import data.Actor;
import data.LendingItem;
import data.Movie;
import data.Person;

public final class MoviePersonFilter implements LendingItemFilter {
	private final Person person;

	public MoviePersonFilter(Person person) {
		this.person = person;
	}

	@Override
	public LendingItem filter(LendingItem lendingItem) {
		if (lendingItem instanceof Movie movie) {
			for (Actor actor : movie.getActors()) {
				if (actor.equals(person)) {
					return lendingItem;
				}
			}
		}
		return null;
	}
}

