package src;

public abstract class Vehicle {
    private final String vehicleId;
    private final String model;
    private final double baseRentalRate;
    private boolean isAvailable;

    public Vehicle(final String vehicleId, final String model, final double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
    }

    public final String getVehicleId() {
        return vehicleId;
    }

    public final String getModel() {
        return model;
    }

    public final double getBaseRentalRate() {
        return baseRentalRate;
    }

    public final boolean isAvailable() {
        return isAvailable;
    }

    public final void setAvailable(final boolean available) {
        isAvailable = available;
    }

    public abstract double calculateRentalCost(final int days);
}

