package org.example.model;

public class VehicleFare {
    private final VehicleType vehicleType;
    private final double estimatedPrice;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public double getEstimatedPrice() {
        return estimatedPrice;
    }

    public VehicleFare(VehicleType vehicleType, double estimatedPrice) {

        this.vehicleType = vehicleType;
        this.estimatedPrice = estimatedPrice;
    }
}
