import java.util.*;

public class Record {
	 private ArrayList<Person> member = new ArrayList<Person>();
	 private ArrayList<Librarians> librarians  = new ArrayList<Librarians>();
	 private ArrayList<Book> books = new ArrayList<Book>();
	 
	public ArrayList<Book> getBooks() {
		return books;
	}

	public ArrayList<Person> getMember() {
		return member;
	}
	
	public ArrayList<Librarians> getLibrarians() {
		return librarians;
	}
	
	
}
