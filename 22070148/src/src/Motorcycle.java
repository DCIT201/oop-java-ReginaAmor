package src;


public final class Motorcycle extends Vehicle implements src.Rentable {
    private final boolean hasSideCar;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasSideCar) {
        super(vehicleId, model, baseRentalRate);
        this.hasSideCar = hasSideCar;
    }

    public boolean hasSideCar() {
        return hasSideCar;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasSideCar) {
            cost += 15 * days; // Additional cost for sidecar
        }
        return cost;
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
