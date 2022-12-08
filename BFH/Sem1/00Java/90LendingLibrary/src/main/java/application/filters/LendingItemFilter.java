package application.filters;

/*
 * Interface for LendingItem filters
 */
import data.LendingItem;

public interface LendingItemFilter {
	LendingItem filter(LendingItem lendingItem);

}

