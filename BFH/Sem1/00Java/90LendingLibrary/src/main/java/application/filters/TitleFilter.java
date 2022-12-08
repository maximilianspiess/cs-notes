/*
 * Filter for LendingItems comparing titles
 */
package application.filters;

import data.LendingItem;

public final class TitleFilter implements LendingItemFilter {
	private final String title;

	public TitleFilter(String title) {
		this.title = title;
	}

	@Override
	public LendingItem filter(LendingItem lendingItem) {
		if (lendingItem.getTitle().equals(title)) {
			return lendingItem;
		} else {
			return null;
		}
	}
}

