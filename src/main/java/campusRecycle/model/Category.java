package campusRecycle.model;

import javax.persistence.*;

@Entity
@Table(name="Categories")
public class Category {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
