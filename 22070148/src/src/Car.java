package src;

public final class Car extends Vehicle implements src.Rentable {
    private final boolean hasAirConditioning;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasAirConditioning) {
        super(vehicleId, model, baseRentalRate);
        this.hasAirConditioning = hasAirConditioning;
    }

    public boolean hasAirConditioning() {
        return hasAirConditioning;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getBaseRentalRate() * days;
        if (hasAirConditioning) {
            cost += 10 * days; // Additional cost for air conditioning
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

