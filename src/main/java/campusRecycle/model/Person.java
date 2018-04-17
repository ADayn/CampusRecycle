package campusRecycle.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@MappedSuperclass
public abstract class Person implements UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String email;
	private String password;
	private String username;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> col = new ArrayList<>(1);
		col.add(new SimpleGrantedAuthority("ROLE_" + this.getRole()));
		return col;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	abstract String getRole();

	public void setUsername(String username) {
		this.username = username;
	}

}

