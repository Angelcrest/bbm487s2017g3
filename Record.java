import java.io.*;
import java.util.*;

public class Record {

	private static ArrayList<Person> member = new ArrayList<Person>();
	private static ArrayList<Librarian> librarians = new ArrayList<Librarian>();
	private static ArrayList<Book> books = new ArrayList<Book>();

	public static ArrayList<Book> getBooks() {
		return books;
	}

	public static ArrayList<Person> getMember() {
		return member;
	}

	public static ArrayList<Librarian> getLibrarians() {
		return librarians;
	}

	static void read_member(ArrayList<Person> m, String f) throws IOException {
		BufferedReader br = null;

		try {

			String line;
			br = new BufferedReader(new FileReader(f));

			while ((line = br.readLine()) != null) {
				String[] part = line.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
				Person temp = new Person(Integer.parseInt(part[0]), part[1], part[2], part[3], part[4], part[5],
						Double.parseDouble(part[6]));
				getMember().add(temp);

			}
			br.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void read_librarian(ArrayList<Librarian> m, String f) throws IOException {
		BufferedReader br = null;

		try {

			String line;
			br = new BufferedReader(new FileReader(f));

			while ((line = br.readLine()) != null) {
				String[] part = line.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
				Librarian temp = new Librarian(Integer.parseInt(part[0]), part[1], part[2], part[3], part[4], part[5],
						part[6]);
				getLibrarians().add(temp);

			}
			br.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void read_book(ArrayList<Book> m, String f) throws IOException {
		BufferedReader br = null;

		try {

			String line;
			br = new BufferedReader(new FileReader(f));

			while ((line = br.readLine()) != null) {
				String[] part = line.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
				Book temp = new Book(Integer.parseInt(part[0]), part[1], part[2], part[3], part[4],
						Boolean.valueOf(part[5]));
				getBooks().add(temp);

			}
			br.close();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void write_member(Person temp, String f) {
		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(f, true));
			bw.write("\n" + temp.getP_id() + " \"" + temp.getName() + "\" \"" + temp.getSurname() + "\" \""
					+ temp.getEmail() + "\" \"" + temp.getUsername() + "\" \"" + temp.getPass() + "\" \""
					+ temp.getFine() + "\"");

			bw.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void write_member(ArrayList<Person> m, String f) {
		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(f));
			for (Person temp : m) {
				bw.write(temp.getP_id() + " \"" + temp.getName() + "\" \"" + temp.getSurname() + "\" \""
						+ temp.getEmail() + "\" \"" + temp.getUsername() + "\" \"" + temp.getPass() + "\" \""
						+ temp.getFine() + "\"");

			}
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void write_librarian(Librarian temp, String f) {
		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(f));
			bw.write("\n" + temp.getP_id() + " \"" + temp.getName() + "\" \"" + temp.getSurname() + "\" \""
					+ temp.getEmail() + "\" \"" + temp.getPhone() + "\" \"" + temp.getUsername() + "\" \""
					+ temp.getPass() + "\"");
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void write_librarian(ArrayList<Librarian> l, String f) {
		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(f));
			for (Librarian temp : l) {
				bw.write(temp.getP_id() + " \"" + temp.getName() + "\" \"" + temp.getSurname() + "\" \""
						+ temp.getEmail() + "\" \"" + temp.getPhone() + "\" \"" + temp.getUsername() + "\" \""
						+ temp.getPass() + "\"\n");

			}
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void write_book(Book temp, String f) {
		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(f));
			bw.write("\n" + temp.getId() + " \"" + temp.getName() + "\" \"" + temp.getAuthor() + "\" \""
					+ temp.getYear() + "\" \"" + temp.getBarcode() + "\" " + temp.isBorrowed());

			bw.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void write_book(ArrayList<Book> b, String f) {
		BufferedWriter bw = null;

		try {

			bw = new BufferedWriter(new FileWriter(f));
			for (Book temp : b) {
				bw.write(temp.getId() + " \"" + temp.getName() + "\" \"" + temp.getAuthor() + "\" \"" + temp.getYear()
						+ "\" \"" + temp.getBarcode() + "\" " + temp.isBorrowed() + "\n");
			}

			bw.close();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		read_member(getMember(), "members.txt");
		read_librarian(getLibrarians(), "librarians.txt");
		read_book(getBooks(), "books.txt");
		Login.main(null);
	}

}
