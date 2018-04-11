package campusRecycle.model;

import java.util.Comparator;

public class ItemDateComparator implements  Comparator<Item>{
	public int compare(Item item1, Item item2) {
		if(item1.getDatePosted().compareTo(item2.getDatePosted())>0) return 1;
		if(item1.getDatePosted() == item2.getDatePosted()) return 0;
		return -1;
	}
}
