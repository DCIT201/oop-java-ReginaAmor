package src;

public final class Truck extends Vehicle implements src.Rentable {
    private final double cargoCapacity;

    public Truck(String vehicleId, String model, double baseRentalRate, double cargoCapacity) {
        super(vehicleId, model, baseRentalRate);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days + (cargoCapacity * 2); // Additional cost based on cargo capacity
    }

    @Override
    public boolean rent(Customer customer, int days) {
        if (isAvailable()) {
            setAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnVehicle() {
        if (!isAvailable()) {
            setAvailable(true);
            return true;
        }
        return false;
    }
}

