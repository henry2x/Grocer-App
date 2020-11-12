package payroll.GroceryStore;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Item {

	private @Id @GeneratedValue Long id;
	String name;
	int category;
	Date expiryDate;

	
	

	public Item(String name, int category, Date expiryDate) {
		this.name = name;
		this.category = category;
		this.expiryDate = expiryDate;
	}
	
	public Long getId() {
		return id;
	}
	

    public void setId(Long id) {
        this.id = id;
    }

	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date e) {
		expiryDate = e;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Item))
            return false;
        Item item = (Item) o;
        return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name)
        		&& Objects.equals(this.category, item.category) && 
        		Objects.equals(this.expiryDate, item.expiryDate);

    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.category, this.expiryDate);
    }
    
    @Override
    public String toString() {
        return "Item{" + "id=" + this.id + ", name='" + this.name + '\'' + ", Category ='" + this.category + '\'' + ", ExpiryDate ='" + this.expiryDate.toString() + '\'' + '}';
    }
	
}
