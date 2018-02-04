package application.model;

public class Item {
	private String name;
	
	private String item;
	
	private String price;
	
	public Item(String name, String item, String price) {
		this.name = name;
		this.item = item;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
