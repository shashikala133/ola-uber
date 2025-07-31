package org.example.model;

import java.time.LocalDateTime;

public class Booking {

    private final Rider rider;
    private final Cab cab;
    private final Location pickUpLocation;
    private final Location dropLocation;
    private final LocalDateTime bookingTime;
    private double fare;
    private BookingStatus status;

    public Booking(Rider rider, Cab cab, Location pickUpLocation, Location dropLocation, LocalDateTime bookingTime) {
        this.rider = rider;
        this.cab = cab;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.bookingTime = bookingTime;
    }

    public Rider getRider() {
        return rider;
    }

    public Cab getCab() {
        return cab;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
