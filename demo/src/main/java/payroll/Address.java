package payroll;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
public class Address {
	
	private @Id @GeneratedValue Long id;
	String postal_code;
	@Override
	public int hashCode() {
		return Objects.hash(city, postal_code, province, street_name, street_number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(postal_code, other.postal_code)
				&& Objects.equals(province, other.province) && Objects.equals(street_name, other.street_name)
				&& street_number == other.street_number;
	}
	String city;
	String province;
	String street_name;
	int street_number;
	
	
	public Address(String postal_code, String city, String province, int street_number, String street_name) {
		super();
		this.postal_code = postal_code;
		this.city = city;
		this.province = province;
		this.street_number = street_number;
		this.street_name = street_name;
	}
	
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getStreet_number() {
		return street_number;
	}
	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_address(String street_name) {
		this.street_name = street_name;
	}
	
}
