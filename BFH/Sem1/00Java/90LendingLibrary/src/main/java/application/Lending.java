package application;

import java.time.LocalDate;

import data.Customer;
import data.LendingItem;

public class Lending {
	private final LocalDate startDate;
	private LocalDate endDate;
	private final LendingItem item;
	private final Customer customer;
		
	public Lending(Customer customer, LendingItem item){
	    this.startDate = LocalDate.now();
	    this.customer = customer;
	    this.item = item;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LendingItem getItem() {
		return item;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public LocalDate getReturnDate() {
		return this.endDate;
	}
	
	public void setReturnDate(LocalDate date) {
		this.endDate = date;
	}
}
