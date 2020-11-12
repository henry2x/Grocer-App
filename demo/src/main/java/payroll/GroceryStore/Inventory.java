package payroll.GroceryStore;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory")
@Access(value=AccessType.FIELD)
public class Inventory {

	private @Id @GeneratedValue Long id;
	ArrayList<Item> items;
	
	ArrayList<Integer> quantities;
	
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private GroceryStore grocery_store;
	
	public Inventory() {
		items = new ArrayList<Item>();
		quantities = new ArrayList<Integer>();
	}
	
	
	public void addItem(Item i, int quantity) {
		items.add(i);
		quantities.add(quantity);
	}
	
	public void removeItem(Item i) {
		int index = items.indexOf(i);
		items.remove(index);
		quantities.remove(index);
	}
	
	public void editQuantity(Item i, int quantity){
		int index = items.indexOf(i);
		quantities.add(index, quantity);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(ArrayList<Integer> quantities) {
		this.quantities = quantities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, items, quantities);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Inventory))
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(id, other.id) && Objects.equals(items, other.items)
				&& Objects.equals(quantities, other.quantities);
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", items=" + items + ", quantities=" + quantities + "]";
	}
	
}
