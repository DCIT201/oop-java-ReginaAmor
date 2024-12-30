package src;


import java.time.LocalDate;

public record RentalTransaction(String transactionId, Vehicle vehicle, Customer customer, LocalDate rentalDate,
                                LocalDate returnDate, double totalCost) {

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                "\nCustomer: " + customer.getName() +
                "\nVehicle: " + vehicle.getModel() +
                "\nRental Period: " + rentalDate + " to " + returnDate +
                "\nTotal Cost: $" + totalCost;
    }
}

