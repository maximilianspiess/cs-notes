package application;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Actor;
import data.Author;
import data.Book;
import data.LendingItem;
import data.Movie;


class CatalogLookupTest {
	private DataProvider dataProvider;
	private CatalogLookup catalogLookup;
	private LendingManager lendingMananger;
	
	@BeforeEach
	void setup() {
		lendingMananger = new LendingManager();
		dataProvider= new DataProvider();
		dataProvider.initData();
		dataProvider.initLendings(lendingMananger);
		catalogLookup = new CatalogLookup(dataProvider);
	}

	@Test
	void testfindItemId() {
		long id = 784655423;
		assertNotNull(catalogLookup.findItems(id));
		LendingItem item = catalogLookup.findItems(id).get(0);
		assertEquals(id, item.getId());
		id = 5612345;
		assertNotNull(catalogLookup.findItems(id));
		item = catalogLookup.findItems(id).get(0);
		assertNotNull(item);
		assertEquals(id, item.getId());
	}

	@Test
	void testFindItemIdInvalid() {
		assertTrue(catalogLookup.findItems(15).isEmpty());
	}

	@Test
	void testfindItemTitle() {
		String title = "Der Zauberberg";
		assertFalse(catalogLookup.findItems(title).isEmpty());
		assertTrue(catalogLookup.findItems(title).get(0) instanceof Book);
		title = "Erde";
		assertFalse(catalogLookup.findItems(title).isEmpty());
		assertTrue(catalogLookup.findItems(title).get(0) instanceof Movie);
	}

	@Test
	void testFindItemTitleInvalid() {
		String title = "Zauberberg";
		assertTrue(catalogLookup.findItems(title).isEmpty());
	}

	@Test
	void testfindBookAuthor() {
		Author author = new Author("Franz", "Kafka");
		assertTrue(catalogLookup.findItems(author).size()==3);
		assertTrue(catalogLookup.findItems(author).get(0) instanceof Book);
		Book book = (Book)catalogLookup.findItems(author).get(0);
		assertTrue(book.getAuthor().equals(author));
	}
	@Test
	void testfindMovieActor() {
	
		Actor actor = new Actor("Anna", "Beta");
		assertTrue(catalogLookup.findItems(actor).size()==3);
		assertTrue(catalogLookup.findItems(actor).get(0) instanceof Movie);
		Movie movie = (Movie)catalogLookup.findItems(actor).get(0);
		assertTrue(movie.getActors().contains(actor));
	}

	@Test
	void testFindItemPersonInvalid() {
		assertTrue(catalogLookup.findItems(new Author("A", "B")).isEmpty());
	}
}

