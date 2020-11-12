package payroll.Manager;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Managers")
public class Manager {

    public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String role;
    private int storeId;

    Manager() {
    }

    public Manager(String firstName, String lastName, String role,int storeId) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.storeId = storeId;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void setName(String name) {
        String[] parts = name.split(" ");
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getRole() {
        return this.role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Manager))
            return false;
        Manager manager = (Manager) o;
        return Objects.equals(this.id, manager.id) && Objects.equals(this.firstName, manager.firstName) && Objects.equals(this.lastName, manager.lastName)
                && Objects.equals(this.role, manager.role) && Objects.equals(this.storeId, manager.storeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.role);
    }

    @Override
    public String toString() {
        return "Manager{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName + '\'' + ", role='" + this.role + '\'' + '}';
    }
}