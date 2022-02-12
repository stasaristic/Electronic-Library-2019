package onlinelib;
import java.io.Serializable;
import java.util.*;


public class Library implements Serializable{
	
	private List<Book> collection;
	
	public Library() {
		List<Book> collection = new ArrayList<Book>();
	}
	
	public void addBook(Book book) {
		collection.add(book);
	}
	
	public void removeBook(Book book) {
		collection.remove(book);
	}
	@Override
	public String toString() {
		String total = "\n";
		
		Iterator<Book> i = collection.iterator();
		while(i.hasNext()) {
			Book b = (Book) i.next();
			total = total + b.toString();
		}
		
		
		return total;
	}

}
