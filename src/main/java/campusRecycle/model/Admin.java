package campusRecycle.model;

import campusRecycle.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.event.ItemEvent;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Admins")
public class Admin extends Person{
	public void sendApprovalEmail(User user,Item it) {
		
	}
	
	public void sendDenialEmail(User user,Item it) {
		
	}
	
	public void sendUserDeletionEmail(User user) {
		
	}
}
