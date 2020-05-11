package models;

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

    @Column(name="status")
    protected String status;

    public BookingModel() {
    }

    public BookingModel(String roomNumber, String guestID, Date checkIn, Date checkOut, String status) {
        super();
        this.roomNumber = roomNumber;
        this.guestID = guestID;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
