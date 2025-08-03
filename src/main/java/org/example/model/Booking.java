package org.example.model;

import java.time.LocalDateTime;

public class Booking {

    private final Rider rider;
    private final Cab cab;
    private final Location pickUpLocation;
    private final Location dropLocation;
    private final LocalDateTime bookingTime;
    private LocalDateTime rideStartTime;
    private LocalDateTime rideEndTime;
    private double fare;
    private BookingStatus status;
    private final String otp;

    public Booking(Rider rider, Cab cab, Location pickUpLocation, Location dropLocation, double fare) {
        this.rider = rider;
        this.cab = cab;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.otp = generateOtp();
        this.bookingTime = LocalDateTime.now();
        this.fare=fare;
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

    public LocalDateTime getRideStartTime() {
        return rideStartTime;
    }

    public void setRideStartTime(LocalDateTime rideStartTime) {
        this.rideStartTime = rideStartTime;
    }

    public LocalDateTime getRideEndTime() {
        return rideEndTime;
    }

    public void setRideEndTime(LocalDateTime rideEndTime) {
        this.rideEndTime = rideEndTime;
    }

    public String generateOtp(){
        int otp=1000+  (int) (Math.random()*9000);
        return String.valueOf(otp);
    }

    public String getOtp() {
        return otp;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "rider=" + rider +
                ", cab=" + cab +
                ", pickUpLocation=" + pickUpLocation +
                ", dropLocation=" + dropLocation +
                ", bookingTime=" + bookingTime +
                ", rideStartTime=" + rideStartTime +
                ", rideEndTime=" + rideEndTime +
                ", fare=" + fare +
                ", status=" + status +
                '}';
    }
}
