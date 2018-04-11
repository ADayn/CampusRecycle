package campusRecycle.model;

import campusRecycle.model.Item;

import java.awt.event.ItemEvent;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Users")
public class User extends Person{
    
	@ElementCollection
	@CollectionTable(name="User_Ratings", joinColumns=@JoinColumn(name="user_id"))
	@Column(name="ratings")
	List<Integer> ratings;
	 
	public void addRating(int rate) {
		ratings.add(rate);
	}
		
	public List<Integer> getRatings() {
		return ratings;
	}

	public void setRatings(List<Integer> ratings) {
		this.ratings = ratings;
	}

	public float calcAverageRating() {
		float avg=0;
		for (Integer rating: ratings)
			avg+=rating;
		avg=avg/ratings.size();
		return avg;
	}
}
