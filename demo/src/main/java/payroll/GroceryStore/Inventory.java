package payroll.GroceryStore;

import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Inventory")
@Access(value=AccessType.FIELD)
public class Inventory {

	private @Id @GeneratedValue Long id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	public Item item;
	
	
	public int quantity;
	
	public int store_id;
	
	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	private GroceryStore g;
	
	public GroceryStore getG() {
		return g;
	}

	public void setG(GroceryStore g) {
		this.g = g;
	}

	public Item getItem() {
		return item;
	}

	public Inventory() {
	}

	public void setItem(Item item) {
		this.item = item;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}




	public Inventory(Item i , int quantity, int storeid) {
		this.item = i;
		this.quantity = quantity;
		this.store_id = storeid;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



}
