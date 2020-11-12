package payroll.GroceryStore;

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
@Table(name = "ADDRESS")
@Access(value=AccessType.FIELD)
public class Address {



	@Id
	@GeneratedValue(generator = "gen")
	private long id;

	private String addressLine;

	private String zipcode;

	private String city;

	@OneToOne
	@PrimaryKeyJoinColumn
	private GroceryStore grocery_store;

	public Address() {
	}

	public Address(String addressLine, String zipcode, String city) {
		this.addressLine = addressLine;
		this.zipcode = zipcode;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine = addressLine1;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public GroceryStore getGroceryStore() {
		return grocery_store;
	}

	public void setGroceryStore(GroceryStore groceryStore) {
		this.grocery_store = groceryStore;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(addressLine, city, grocery_store, id, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressLine, other.addressLine) && Objects.equals(city, other.city)
				&& Objects.equals(grocery_store, other.grocery_store) && id == other.id
				&& Objects.equals(zipcode, other.zipcode);
	}

	@Override
	public String toString() {
		return "Address {id=" + id + ", addressLine=" + addressLine + ", zipcode=" + zipcode + ", city=" + city
				+ ", grocery_store=" + grocery_store + "}";
	}


}
