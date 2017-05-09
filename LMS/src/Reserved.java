import java.util.ArrayList;

public class Reserved {
	Person p;
	ArrayList<Book> b;
	String time;
	
	public Reserved(Person p, ArrayList<Book> b) {
		super();
		this.p = p;
		this.b = b;
		this.time = "20";
	}
	public Person getP() {
		return p;
	}
	public void setP(Person p) {
		this.p = p;
	}
	public ArrayList<Book> getB() {
		return b;
	}
	public void setB(ArrayList<Book> b) {
		this.b = b;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
