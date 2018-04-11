package campusRecycle.model;
import java.util.*;
import java.util.stream.Collectors;

public class ItemList implements Iterable<Item> {
	private List<Item> items;

	public ItemList(List<Item> items) {
		this.items = items;
	}

	public List<Item> getSorted(SortKey key){
		Comparator<Item> comparator=new ItemPriceComparator();
		List<Item> sortedItems = new ArrayList<Item>(items);
		if(key == SortKey.PRICE) {
			comparator=new ItemPriceComparator();
		}
		Collections.sort(sortedItems,comparator);
		return sortedItems;
	}
	
	//a simple version, just match keywords with (
	public List<Item> search(String keyword){
		List<Item> foundItems = new LinkedList<Item>();
		// TODO: Sort better (multiple key words)
		return foundItems
				.stream()
				.filter(item -> item.getTitle().contains(keyword) || item.getDescription().contains(keyword))
				.collect(Collectors.toList());
	}
	
	public List<Item> getByCategory(String cat){
		List<Item> foundItems = new LinkedList<Item>();
		for (Item item: items) {
			if(item.getCategory().equals(cat)) {
				foundItems.add(item);
			}
		}
		return foundItems;
	}
	
	public List<Item> getBySeller(User seller){
		List<Item> foundItems = new LinkedList<Item>();
		for(Item item: items) {
			if(item.getSeller().equals(seller)) {
				foundItems.add(item);
			}
		}
		return foundItems;
	}
	
	public List<Item> getByBuyer(User buyer){
		List<Item> foundItems = new LinkedList<Item>();
		for(Item item: items) {
			if(item.getBuyer().equals(buyer)) {
				foundItems.add(item);
			}
		}
		return foundItems;
	}
	
	public Item getByItemId(int id){
		for (Item item: items) {
			if(item.getId() == id)
				return item;
		}
		return null;
	}
	
	public boolean addItem(Item item) {
		items.add(item);
		return true;
	}

	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}
}
