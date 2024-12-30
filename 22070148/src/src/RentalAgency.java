package src;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentalAgency {
    private final List<Vehicle> vehicles;
    private final List<RentalTransaction> transactions;

    public RentalAgency() {
        this.vehicles = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public RentalTransaction rentVehicle(String vehicleId, Customer customer, int days) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailable()) {
                vehicle.setAvailable(false);
                double totalCost = vehicle.calculateRentalCost(days);
                RentalTransaction transaction = new RentalTransaction(
                        UUID.randomUUID().toString(),
                        vehicle,
                        customer,
                        LocalDate.now(),
                        LocalDate.now().plusDays(days),
                        totalCost
                );
                transactions.add(transaction); // Add the transaction to the list
                customer.addRentalHistory(vehicle); // Track the vehicle in the customer's history
                return transaction;
            }
        }
        return null; // Vehicle not available
    }

    public boolean returnVehicle(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId) && !vehicle.isAvailable()) {
                vehicle.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public List<RentalTransaction> getTransactions() {
        return new ArrayList<>(transactions); // Return a copy for immutability
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (RentalTransaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

