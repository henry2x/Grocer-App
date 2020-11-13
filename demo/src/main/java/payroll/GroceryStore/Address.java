package payroll.GroceryStore;

import java.util.Objects;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	@Column(name = "AddressLine")
	private String addressLine;
	
	@Column(name = "PostalCode")
	private String zipcode;
	
	
	public String getAddressLine() {
		return addressLine;
	}

	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	

	public GroceryStore getG() {
		return g;
	}

	public void setG(GroceryStore g) {
		this.g = g;
	}


	@Column(name = "City")
	private String city;

	@OneToOne(cascade = {CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private GroceryStore g;

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
	



}
