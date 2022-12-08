package application.filters;

import data.LendingItem;

public final class IdFilter implements LendingItemFilter {
	private final long id;

	public IdFilter(long id) {
		this.id = id;
	}

	@Override
	public LendingItem filter(LendingItem lendingItem) {
		if (lendingItem.getId() == id) {
			return lendingItem;
		} else {
			return null;
		}
	}
}
