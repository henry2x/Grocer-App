package payroll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GroceryStore")
public class GroceryStore {

	private @Id @GeneratedValue Long id;

	ArrayList<Manager> managers;
	ArrayList<Order> orders;
	
	
	
	
	public GroceryStore() {
		super();
		managers = new ArrayList<Manager>();
		orders = new ArrayList<Order>();
		
	}
	
	
	public GroceryStore(List<Manager> managers, List<Order> orders) {
		super();
		for(Manager m : managers) this.managers.add(m);	
		for(Order o : orders) this.orders.add(o);
			
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(managers.toArray());
		result = prime * result + Arrays.hashCode(orders.toArray());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryStore other = (GroceryStore) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(managers.toArray(), other.managers.toArray()))
			return false;
		if (!Arrays.equals(orders.toArray(), other.orders.toArray()))
			return false;
		return true;
	}

	/*
	 * public Address getAddress() { return address; }
	 * 
	 * public void setAddress(Address a) { this.address = a; }
	 */
	
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
	
}
