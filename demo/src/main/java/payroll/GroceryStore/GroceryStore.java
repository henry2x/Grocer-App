package payroll.GroceryStore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import payroll.Manager.Manager;
import payroll.Order.Order;

@Entity
@Table(name = "Grocery_Store")
@Access(value=AccessType.FIELD)
public class GroceryStore {

	private @Id @GeneratedValue Long id;
	
	ArrayList<Manager> managers;
	ArrayList<Order> orders;
	
	
	@OneToOne(mappedBy = "grocery_store" , cascade = CascadeType.ALL)
	Address address;
	
	
	@OneToOne(mappedBy = "grocery_store" , cascade = CascadeType.ALL)
	Inventory inventory;
	
	public GroceryStore() {		
	}
	
	
	public GroceryStore(Address address) {
		managers = new ArrayList<Manager>();
		orders = new ArrayList<Order>();
		this.inventory = new Inventory();
		this.address = address;
		
		
	}
	
	
	public Inventory getInventory() {
		return inventory;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}


	public GroceryStore(Address address,List<Manager> managers, List<Order> orders, Inventory inventory) {
		super();
		for(Manager m : managers) this.managers.add(m);	
		for(Order o : orders) this.orders.add(o);
		this.address = address;
		this.inventory = inventory;
		
			
	}
	
	@JsonIgnore
	public Address getAddress() {
		return this.address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public int hashCode() {
		return Objects.hash(address, id, managers, orders);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof GroceryStore))
			return false;
		GroceryStore other = (GroceryStore) obj;
		return Objects.equals(address, other.address) && Objects.equals(id, other.id)
				&& Objects.equals(managers, other.managers) && Objects.equals(orders, other.orders);
	}


	public void setManagers(List<Manager> managers) {
		managers = new ArrayList<Manager>();
		for(Manager m : managers) 
		this.managers.add(m);
	}
	public List<Manager> getManagers() {
		return managers;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id2) {
		this.id = id2;
		
	}


	public void setManagers(ArrayList<Manager> managers) {
		this.managers = managers;
	}


	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "GroceryStore [id=" + id + ", managers=" + managers + ", orders=" + orders + ", address=" + address
				+ "]";
	}
	
	
	
}
