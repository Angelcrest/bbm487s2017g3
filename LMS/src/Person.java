import java.text.*;
import java.util.*;

public class Person {

	/* attribute of librarians and members */
	private String name;
	private String surname;
	private String email;
	private String username;
	private String pass;
	private double fine;
	private int P_id;
	private String time;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + P_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (P_id != other.P_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	/* getter-setter methods */

	public int getP_id() {
		return P_id;
	}

	public void setP_id(int p_id) {
		P_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Person(int p_id, String name, String surname, String email, String username, String pass) {
		P_id = p_id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.fine = 0.0;
		this.time = "01.01.2010";
	}

	public Person(int p_id, String name, String surname, String email, String username, String pass, double f,
			String t) {
		P_id = p_id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.username = username;
		this.pass = pass;
		this.fine = f;
		this.time = t;
	}

	public Person() {
	}

	static void check_fine(int id) throws ParseException {
		int index = 0;
		while (index < Record.getReserved().size()) {
			if (Record.getReserved().get(index).getP().getP_id() == id) {
				DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
				Date pay = format.parse(Record.getReserved().get(index).getP().getTime());

				int index_b = 0;
				while (index_b < Record.getReserved().get(index).getB().size()) {
					Date date1 = (Date) format.parse(Record.getReserved().get(index).getB().get(index_b).getTime());
					if ((pay.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) < 0) {
						Date date2 = format.parse(format.format(new Date()));
						int difference = (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
						if (difference > 20) {
							Record.getReserved().get(index).getP()
									.setFine(Record.getReserved().get(index).getP().getFine() + difference - 20);
						}
					}

					index_b++;
				}

			}

			index++;
		}
	}

}
