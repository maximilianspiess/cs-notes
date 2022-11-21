package data;

public class Book extends LendingItem {

    private Author author;
    
    //overload
    public Book(long id, String title) {
        super(id, title);
    } 
    public Book(long id, String title, Author author) {
        this(id, title);  		
        this.author = author;
    } 
   
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public String toString() {
    	return super.toString() + ", Author: " + author.toString();
    }
    
}
