package org.example.pricing;

import org.example.model.Location;
import org.example.model.VehicleType;

public class PricingStrategyImpl implements PricingStrategy{
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
        double v = distance * baseRatePerKm;
        return v;
    }
}
