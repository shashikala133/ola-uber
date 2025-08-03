package org.example.pricing;

import org.example.model.Location;
import org.example.model.VehicleType;

public class SurgePricingStrategy implements PricingStrategy{

    private final double demand;

    public SurgePricingStrategy(double demand) {
        this.demand = demand;
    }

    @Override
    public double calculatePricePerVehicleType(VehicleType type, Location from, Location to) {
        double baseRatePerKm=switch (type){
            case BIKE ->  2.0;
            case AUTO -> 4.0;
            case SEDAN -> 6.0;
            case SUV -> 8.0;
            default -> 1.0;
        };

        double distance = from.distance(to);
        double surgingCount = 1+ (demand/10.0);
        return distance * baseRatePerKm * surgingCount;

    }
}
