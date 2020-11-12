package payroll.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import payroll.Status;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order {
    private @Id @GeneratedValue Long id;

    private String description;
    private Status status;
    
    private ArrayList<String> items;
    private ArrayList<Integer> quantities;
    private Date pickup_time;

    Order() {
    }

    Order(String description, Status status, ArrayList<String> items, ArrayList<Integer> quantities,Date pickupTime) {
        this.description = description;
        this.status = status;
        this.items = items;
        this.quantities = quantities;
        this.pickup_time = pickupTime;
    }

    public Long getId() {
        return this.id;
    }

    public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	public ArrayList<Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(ArrayList<Integer> quantities) {
		this.quantities = quantities;
	}

	public Date getPickup_time() {
		return pickup_time;
	}

	public void setPickup_time(Date pickup_time) {
		this.pickup_time = pickup_time;
	}

	public String getDescription() {
        return this.description;
    }

    public Status getStatus() {
        return this.status;
    }
    
    public Date getPickupTime() {
    	return this.pickup_time;
    	
    }
    
    public void setPickupTime(Date d) {
    	this.pickup_time = d;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public void completeOrder() {
    	this.status = Status.COMPLETED;
    }


    @Override
	public int hashCode() {
		return Objects.hash(description, id, items, pickup_time, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Order))
			return false;
		Order other = (Order) obj;
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(items, other.items) && Objects.equals(pickup_time, other.pickup_time)
				&& status == other.status;
	}

	@Override
    public String toString() {
        return "Order{" + "id=" + this.id + ", description='" + this.description + '\'' + ", status=" + this.status + 
        		", status=" + this.items.toString() + 
        		", pickupTime=" + this.pickup_time.toString() +'}';
    }
}