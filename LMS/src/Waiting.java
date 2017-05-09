import java.util.ArrayList;

public class Waiting {
	private Book b;
	private ArrayList<Person> p = new ArrayList<Person>();

	public Waiting(Book b, ArrayList<Person> p) {
		super();
		this.b = b;
		this.p = p;
	}

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public ArrayList<Person> getP() {
		return p;
	}

	public void setP(ArrayList<Person> p) {
		this.p = p;
	}

}
