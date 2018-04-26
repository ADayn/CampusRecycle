package campusRecycle.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull
    private String title;

    private String description;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    @Column(nullable = false)
    @NotNull
    private double price;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemState state;

    @ManyToOne
//    @ManyToOne(optional = false)
//    @NotNull
    @JoinColumn(name="seller_id", referencedColumnName = "id")
    private User seller;

    @ManyToOne
    @JoinColumn(name="buyer_id", referencedColumnName = "id")
    private User buyer;

//    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date datePosted;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemState getState() {
        return state;
    }

    public void setState(ItemState state) {
        this.state = state;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }
}
