package models;

import controllers.api.BookingAPI;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="booking")
public class BookingModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    protected int id;

    @Column(name="roomNumber")
    protected String roomNumber;

    @Column(name="guestID")
    protected String guestID;

    @Column(name="checkIn")
    protected Date checkIn;

    @Column(name="checkOut")
    protected Date checkOut;

    @Column(name="numberOfNight")
    protected int numberOfNight;

    @Column(name="totalPrice")
    protected float totalPrice;

    public BookingModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getGuestID() {
        return guestID;
    }

    public void setGuestID(String guestID) {
        this.guestID = guestID;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getNumberOfNight() {
        return numberOfNight;
    }

    public void setNumberOfNight(int numberOfNight) {
        this.numberOfNight = numberOfNight;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BookingModel)) {
            return false;
        }
        BookingModel bookingModel = (BookingModel)obj;
        return this.id == bookingModel.getId()
                && this.roomNumber.equals(bookingModel.getRoomNumber())
                && this.guestID.equals(bookingModel.getGuestID());
    }

    @Override
    public String toString() {
        return String.format("Booking number: %d" +
                "Room: %s" +
                "Guest: %s" +
                "Check in: %s" +
                "Check out: %s", this.id, this.roomNumber, this.guestID, this.checkIn, this.checkOut);
    }
}
