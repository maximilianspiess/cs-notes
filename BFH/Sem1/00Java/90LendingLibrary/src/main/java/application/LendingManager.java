package application;

import java.time.LocalDate;
import java.util.ArrayList;

import data.*;

public class LendingManager {
	private final ArrayList<Lending> lendings = new ArrayList<>();
	
	public Lending lendItem(Customer customer, LendingItem lendingItem) {
		if(lendingItem.getState() == State.AVAILABLE)  {
			lendingItem.setState(State.LENT);
			Lending l = new Lending(customer, lendingItem);
			lendings.add(l);
			return l;
		}
		else {
			return null;
		}
	}
	
    public Lending findLending(LendingItem item) {
        for (int i = lendings.size() - 1; i >= 0; i--) {
            if (lendings.get(i).getItem().getId() == item.getId()) {
                return lendings.get(i);
            }
        }
        return null;
    }

    public Lending returnItem(LendingItem item) {
    	Lending lent = findLending(item);
        if (lent != null) {
            if (lent.getItem().getState() == State.LENT) {
            	item.setState(State.AVAILABLE);
                lent.setReturnDate(LocalDate.now());
                return lent;
            }
        }
        return null;
    }

	public int getNbOfLendings() {
		return lendings.size();
	}
}
