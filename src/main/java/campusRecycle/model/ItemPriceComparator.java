package campusRecycle.model;

import java.util.Comparator;

public class ItemPriceComparator implements Comparator<Item>{
	public int compare(Item item1, Item item2) {
		if(item1.getPrice() > item2.getPrice()) return 1;
		if(item1.getPrice() == item2.getPrice()) return 0;
		return -1;
	}

}
