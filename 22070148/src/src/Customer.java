package src;


import java.util.ArrayList;
import java.util.List;

public final class Customer {
    private final String customerId;
    private final String name;
    private final List<Vehicle> rentalHistory;

    public Customer(final String customerId, final String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public  List<Vehicle> getRentalHistory() {
        return new ArrayList<>(rentalHistory); // Return a copy to ensure immutability
    }

    public void addRentalHistory(final Vehicle vehicle) {
        rentalHistory.add(vehicle);
    }
}
