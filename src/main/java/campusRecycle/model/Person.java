package ooad;

import java.awt.event.ItemEvent;
import java.util.List;

public class Person {

	String email;
	char[] password;
	String username;
	
	public void sendEmail(Person person, String msg) {
		
	}
}

class User extends Person{
	List<Integer> ratings;
	 
	public void addRating(int rate) {
		
	}
	
	public int calcAverageRating() {
		return 0;
	}
}

class Admin extends Person{
	User user;
	Item it;
	
	public void sendApprovalEmail(User user,Item it) {
		
	}
	
	public void sendDenialEmail(User user,Item it) {
		
	}
	
	public void sendUserDeletionEmail(User user) {
		
	}
}

