package src;


public final class TestVehicleRentalSystem {
    public static void main(String[] args) {
        // Step 1: Create a Rental Agency
        src.RentalAgency agency = new src.RentalAgency();

        // Step 2: Create Customers
        src.Customer john = new src.Customer("CUST001", "John Doe");
        src.Customer jane = new src.Customer("CUST002", "Jane Smith");

        // Step 3: Add Vehicles to the Agency
        Vehicle car = new src.Vehicle("CAR001", "Toyota Corolla", 50.0) {
            @Override
            public double calculateRentalCost(int days) {
                return 0;
            }
        };
        Vehicle motorcycle = new src.Vehicle("MOTO001", "Harley Davidson", 30.0) {
            @Override
            public double calculateRentalCost(int days) {
                return 0;
            }
        };
        Vehicle truck = new src.Vehicle("TRUCK001", "Ford F-150", 100.0) {
            @Override
            public double calculateRentalCost(int days) {
                return 0;
            }
        };

        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Step 4: Rent Vehicles
        System.out.println("Renting a car for John for 5 days:");
        src.RentalTransaction transaction1 = agency.rentVehicle("CAR001", john, 5);
        if (transaction1 != null) {
            System.out.println("Rental Successful!");
            System.out.println(transaction1);
        } else {
            System.out.println("Vehicle not available for rent.");
        }

        System.out.println("\nRenting a motorcycle for Jane for 3 days:");
        src.RentalTransaction transaction2 = agency.rentVehicle("MOTO001", jane, 3);
        if (transaction2 != null) {
            System.out.println("Rental Successful!");
            System.out.println(transaction2);
        } else {
            System.out.println("Vehicle not available for rent.");
        }

        // Step 5: Attempt to Rent an Already Rented Vehicle
        System.out.println("\nAttempting to rent the same car for Jane:");
        src.RentalTransaction transaction3 = agency.rentVehicle("CAR001", jane, 2);
        if (transaction3 == null) {
            System.out.println("Vehicle is already rented.");
        }

        // Step 6: Return Vehicles
        System.out.println("\nReturning the car rented by John:");
        boolean returned1 = agency.returnVehicle("CAR001");
        System.out.println("Vehicle CAR001 returned: " + returned1);

        System.out.println("\nReturning the motorcycle rented by Jane:");
        boolean returned2 = agency.returnVehicle("MOTO001");
        System.out.println("Vehicle MOTO001 returned: " + returned2);

        // Step 7: Print Transaction History
        System.out.println("\nTransaction History:");
        agency.printTransactionHistory();
    }
}
