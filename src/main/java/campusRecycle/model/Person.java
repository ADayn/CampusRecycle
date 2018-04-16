package campusRecycle.model;

import campusRecycle.model.Item;

import java.awt.event.ItemEvent;
import java.util.List;
import javax.persistence.*;


@MappedSuperclass
public abstract class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String email;
	private char[] password;
	private String username;
//	private String confirmationToken;
	
	public void sendEmail(Person person, String msg) {
		// TODO
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public String getConfirmationToken() {
//		return confirmationToken;
//	}
//
//	public void setConfirmationToken(String confirmationToken) {
//		this.confirmationToken = confirmationToken;
//	}
}

