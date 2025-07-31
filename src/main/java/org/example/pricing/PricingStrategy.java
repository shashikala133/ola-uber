package org.example.pricing;

import org.example.model.Location;
import org.example.model.VehicleType;

public interface PricingStrategy {
    double calculatePricePerVehicleType(VehicleType type, Location from,Location to);
}
