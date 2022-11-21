/*
 * Main class
 */

package application;

import data.Actor;
import data.Author;

public class Main {

	public static void main(String[] args) {
		LendingManager lendingManager = new LendingManager();
		DataProvider dataProvider = new DataProvider();
		dataProvider.initData();
		dataProvider.initLendings(lendingManager);
		CatalogLookup catalogLookup = new CatalogLookup(dataProvider);
		System.out.println(catalogLookup.findItems(new Author("Franz", "Kafka")).get(0));
		System.out.println(catalogLookup.findItems(new Author("Thomas", "Mann")).get(0));
		System.out.println(catalogLookup.findItems(new Actor("Anna", "Beta")).get(0));
	}
}
