package src;


public interface Rentable {
    boolean rent(final Customer customer, final int days);
    boolean returnVehicle();
}

