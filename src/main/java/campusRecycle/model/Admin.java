package campusRecycle.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Configurable
@Entity
@Table(name="Admins")
public class Admin extends Person {

//	@Autowired
//	private JavaMailSender javaMailSender;

//	private void send() {
//		MimeMessage mail = javaMailSender.createMimeMessage();
//		try {
//			MimeMessageHelper helper = new MimeMessageHelper(mail, true);
//			helper.setTo("mymail@mail.co.uk");
//			helper.setReplyTo("someone@localhost");
//			helper.setFrom("someone@localhost");
//			helper.setSubject("Lorem ipsum");
//			helper.setText("Lorem ipsum dolor sit amet [...]");
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		} finally {}
//		javaMailSender.send(mail);
//		//return helper;
//	}

	public void sendApprovalEmail(User user,Item it) {
		
	}
	
	public void sendDenialEmail(User user,Item it) {
		
	}
	
	public void sendUserDeletionEmail(User user) {
		
	}
}
