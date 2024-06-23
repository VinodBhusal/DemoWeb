package models;

public class Person {
	
	public String firstName;
	public String lastName;
	public String email;
	public	String password;
	public String confirmPassword;

	public Person(String firstName, String lastName, String email, String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", confirmPassword=" + confirmPassword + "]";
	}

}
