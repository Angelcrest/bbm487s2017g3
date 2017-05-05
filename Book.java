
public class Book {
	private int id;
	private String name;
	private String author;
	private String year;
	private String barcode;
	private boolean borrowed;

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean situation) {
		this.borrowed = situation;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Book(int id, String name, String author, String year, String barcode, boolean st) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.year = year;
		this.barcode = barcode;
		this.borrowed = st;
	}

}
