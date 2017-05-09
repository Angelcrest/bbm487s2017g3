import java.io.*;
import java.util.*;
import java.lang.*;

public class Record {

	private static ArrayList<Person> member = new ArrayList<Person>();
	private static ArrayList<Librarian> librarians = new ArrayList<Librarian>();
	private static ArrayList<Book> books = new ArrayList<Book>();
	private static ArrayList<Reserved> reserved = new ArrayList<Reserved>();
	private static ArrayList<Waiting> waiting = new ArrayList<Waiting>();
	
	public static ArrayList<Book> getBooks() {
		return books;
	}

	public static ArrayList<Person> getMember() {
		return member;
	}

	public static ArrayList<Librarian> getLibrarians() {
		return librarians;
	}

	public static ArrayList<Reserved> getReserved() {
		return reserved;
	}

	static void read_member(ArrayList<Person> m, String f) throws IOException {
		BufferedReader br = null;

		try {

			String line;
			br = new BufferedReader(new FileReader(f));

			while ((line = br.readLine()) != null) {
				String[] part = line.split("\"?( |$)(?=(([^\"]*\"){2})*[^\"]*$)\"?");
				Person temp = new Person(Integer.parseInt(part[0]), part[1], part[2], part[3], part[4], part[5],
						Double.parseDouble(part[6]), part[7]);
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

	static void read_reserved(String f) {
		BufferedReader br = null;

		try {

			String line;
			br = new BufferedReader(new FileReader(f));

			while ((line = br.readLine()) != null) {
				String[] part = line.split(" ");

				int person = Integer.parseInt(part[0]);
				int book = Integer.parseInt(part[1]);
				String time = part[2];

				int index_p = 0, index_b = 0;
				boolean p_r = false;

				/* if user exist in reserved */
				while (index_p < getReserved().size()) {
					if (getReserved().get(index_p).getP().getP_id() == person) {
						while (index_b < getBooks().size()) {
							if (getBooks().get(index_b).getId() == book) {
								getBooks().get(index_b).setTime(time);
								getReserved().get(index_p).getB().add(getBooks().get(index_b));
								break;
							}
							index_b++;
						}
						p_r = true;
						break;
					}

					index_p++;
				}

				/* if user not exist in reserved */
				if (p_r == false) {
					index_p = 0;
					index_b = 0;
					while (index_p < getMember().size()) {
						if (getMember().get(index_p).getP_id() == person) {
							while (index_b < getBooks().size()) {
								if (getBooks().get(index_b).getId() == book) {
									ArrayList<Book> b = new ArrayList<Book>();
									getBooks().get(index_b).setTime(time);
									b.add(getBooks().get(index_b));
									getReserved().add(new Reserved(getMember().get(index_p), b));
									break;
								}
								index_b++;
							}
							break;
						}
						index_p++;
					}
				}

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
					+ temp.getFine()+ "\" \"" + temp.getTime()  + "\"");

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
						+ temp.getFine() + "\" \"" + temp.getTime() + "\"");
				bw.write("\n");

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

	static void write_reserved(Person p, Book b, String time, String f) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(f));

			int index_p = 0, index_b=0;
			boolean p_r = false;
			/* if user exist in reserved */
			while (index_p < getReserved().size()) {
				if (getReserved().get(index_p).getP().equals(p)) {
					getReserved().get(index_p).getB().add(b);
					while (index_b < getReserved().get(index_p).getB().size()) {
						if (getReserved().get(index_p).getB().get(index_b).equals(b)) {
							getReserved().get(index_p).getB().get(index_b).setTime(time);
							break;
						}
						index_b++;
					}
					p_r = true;
					break;
				}
				index_p++;
			}
			/* if user not exist in reserved */
			if (p_r == false) {
				index_p = 0; index_b=0;
				while (index_p < getMember().size()) {
					if (getMember().get(index_p).equals(p)) {
						ArrayList<Book> books = new ArrayList<Book>();
						b.setTime(time);
						books.add(b);
						getReserved().add(new Reserved(getMember().get(index_p), books));
					}
					index_p++;
				}
			}
			for (Reserved r : getReserved()) {
				int i = 0;
				while (i < r.getB().size()) {
					bw.write(r.getP().getP_id() + " " + r.getB().get(i).getId() + " " + r.getB().get(i).getTime() + "\n");
					i++;
				}
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void delete_reserved(Person p, Book b, String f) {
		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(f));

			int index_p = 0, index_b = 0;

			while (index_p < getReserved().size()) {
				if (getReserved().get(index_p).getP().equals(p)) {
					while (index_b < getReserved().get(index_p).getB().size()) {
						if (getReserved().get(index_p).getB().get(index_b).equals(b)) {
							getReserved().get(index_p).getB().get(index_b).setTime(null);
							getReserved().get(index_p).getB().remove(index_b);
							break;
						}
						index_b++;
					}

					break;
				}

				index_p++;
			}

			for (Reserved r : getReserved()) {
				int i = 0;
				while (i < r.getB().size()) {
					bw.write(r.getP().getP_id() + " " + r.getB().get(i).getId() + " " + r.getB().get(i).getTime() + "\n");
					i++;
				}
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
		read_reserved("reserved.txt");
		Login.main(null);
	}

}
