package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "guest")
public class GuestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @Column(name = "firstName")
    protected String firstName;

    @Column(name = "lastName")
    protected String lastName;

    @Column(name = "address")
    protected String address;

    @Column(name = "email")
    protected String email;

    @Column(name = "phoneNumber")
    protected String phoneNumber;

    @Column(name = "dob")
    protected Date dob;

    public GuestModel() {
    }

    public GuestModel(String firstName, String lastName, String address, String email, String phoneNumber, Date dob) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GuestModel)) {
            return false;
        }
        GuestModel guestModel = (GuestModel) obj;
        return this.id == guestModel.getId();
    }

    @Override
    public String toString() {
        return String.format("Guest Id: %d" +
                        "First Name: %s" +
                        "Last Name: %s" +
                        "Address: %s" +
                        "Email: %s" +
                        "Phone Number: %s" +
                        "Date of Birth: %s",
                this.id, this.firstName, this.lastName, this.address, this.email, this.phoneNumber, this.dob);
    }
}
