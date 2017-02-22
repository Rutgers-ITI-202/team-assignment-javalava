package adventure;

public class Inventory {

	public static InventoryCollection <Item> itemCollection ; 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		itemCollection = new ItemCollection<Item>();
		int defaultValue = 50;
		Item shirt = new Item(0, "Shirt", defaultValue);
		Item gum = new Item(1, "gum", defaultValue);
		Item key = new Item(2, "key", defaultValue);
		Item shoes = new Item(3, "shoes", defaultValue);
		Item item = new Item(4, "item", defaultValue);

		itemCollection.add(shirt); itemCollection.add(shirt);
		itemCollection.add(gum); itemCollection.add(gum);
		itemCollection.add(key);
		
	}
	
}
		
	}

}
