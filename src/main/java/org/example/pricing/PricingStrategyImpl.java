package org.example.pricing;

import org.example.model.Location;
import org.example.model.VehicleType;

public class PricingStrategyImpl implements PricingStrategy{
    @Override
    public double calculatePricePerVehicleType(VehicleType type, Location from, Location to) {
      double baseRatePerKm;
      switch (type){
          case BIKE -> baseRatePerKm = 2.0;
          case AUTO -> baseRatePerKm = 4.0;
          case SEDAN -> baseRatePerKm = 6.0;
          case SUV -> baseRatePerKm =8.0;
          default -> baseRatePerKm = 1.0;
      }
      double distance = from.distance(to);
      return distance*baseRatePerKm;
    }
}
