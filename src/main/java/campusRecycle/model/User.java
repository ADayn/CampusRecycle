package campusRecycle.model;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Users")
public class User extends Person {
    
	@ElementCollection
	@CollectionTable(name="User_Ratings", joinColumns=@JoinColumn(name="user_id"))
	@Column(name="ratings")
	List<Integer> ratings;
	
    @Column(name="deleted")
    private boolean deleted=false;

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public void addRating(Integer rate) {
		ratings.add(rate);
	}
		 
	public List<Integer> getRatings() {
		return ratings;
	}

	public void setRatings(List<Integer> ratings) {
		this.ratings = ratings;
	}

	public float calcAverageRating() {
		if(ratings.size()==0)
			return 0;
		float avg=0;
		for (Integer rating: ratings)
			avg+=rating;
		avg=avg/ratings.size();
		return avg;
	}

	@Override
	public String getRole() {
		return "USER";
	}
}
