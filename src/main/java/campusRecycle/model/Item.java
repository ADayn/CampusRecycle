package campusRecycle.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String name;
    public int getId() {
        return id;
    }

    /////////////////////////////////////////////////////////////

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
