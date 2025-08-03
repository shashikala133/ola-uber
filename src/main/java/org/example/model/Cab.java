package org.example.model;

public class Cab {
    private final String id;
    private final String driverName;
    private Location location;
    private Boolean isAvailable;
    private final VehicleType type;

    public Cab(String id, String driverName, VehicleType type, Location location) {
        this.id = id;
        this.driverName = driverName;
        this.type = type;
        this.isAvailable = true;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getDriverName() {
        return driverName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

//    public void setAvailable(Boolean available) {
//        isAvailable = available;
//    }

    public void availble(){
        isAvailable=false;
    }

    public VehicleType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", driverName='" + driverName + '\'' +
                ", location=" + location +
                ", isAvailable=" + isAvailable +
                ", type=" + type +
                '}';
    }
}
