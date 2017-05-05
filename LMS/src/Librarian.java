
public class Librarian extends Person {
	private static String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Librarian(int p_id, String name, String surname, String email,String phone, String username,  String pass) {
		// TODO Auto-generated constructor stub
		//super();
		super.setP_id(p_id);
		super.setName(name);
		super.setSurname(surname);
		super.setEmail(email);
		super.setUsername(username);
		super.setPass(pass);
		this.setPhone(phone);
	}
	

}
