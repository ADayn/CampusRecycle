package campusRecycle.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String title;

    private String description;

    private String imagePath;

    private double price;

    // Enum TODO
//    private ItemState state;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "name")
    private User seller;

    @ManyToOne
    @JoinColumn(referencedColumnName = "name")
    private User buyer;

    /////////////////////////////////////////////////////////////


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
