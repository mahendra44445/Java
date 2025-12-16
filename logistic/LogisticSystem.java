package logistic;

import java.util.HashMap;
import java.util.Map;

public class LogisticSystem {

    /* ---------------- Shipment Class ---------------- */
    static class Shipment {
        private String shipmentId;
        private String status;
        private String location;

        public Shipment(String shipmentId, String location) {
            this.shipmentId = shipmentId;
            this.location = location;
            this.status = "In Transit";
        }

        public void updateLocation(String newLocation) {
            this.location = newLocation;
        }

        public void updateStatus(String status) {
            this.status = status;
        }

        public void display() {
            System.out.println("Shipment ID: " + shipmentId +
                    ", Status: " + status +
                    ", Location: " + location);
        }
    }

    /* ---------------- Vehicle Class ---------------- */
    static class Vehicle {
        private String vehicleId;
        private String driverName;
        private boolean available;

        public Vehicle(String vehicleId, String driverName) {
            this.vehicleId = vehicleId;
            this.driverName = driverName;
            this.available = true;
        }

        public void assign() {
            available = false;
        }

        public void release() {
            available = true;
        }

        public boolean isAvailable() {
            return available;
        }

        public void display() {
            System.out.println("Vehicle ID: " + vehicleId +
                    ", Driver: " + driverName +
                    ", Available: " + available);
        }
    }

    /* ---------------- Warehouse Class ---------------- */
    static class Warehouse {
        private Map<String, Integer> inventory = new HashMap<>();

        public void addItem(String item, int quantity) {
            inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
        }

        public void removeItem(String item, int quantity) {
            inventory.put(item, inventory.get(item) - quantity);
        }

        public void displayInventory() {
            System.out.println("Warehouse Inventory:");
            inventory.forEach((item, qty) ->
                    System.out.println(item + ": " + qty));
        }
    }

    /* ---------------- Route Optimizer ---------------- */
    static class RouteOptimizer {
        public static String getOptimalRoute(String source, String destination) {
            return "Optimized route from " + source + " to " + destination;
        }
    }

    /* ---------------- Main Method ---------------- */
    public static void main(String[] args) {

        // Create warehouse and inventory
        Warehouse warehouse = new Warehouse();
        warehouse.addItem("Laptop", 50);
        warehouse.addItem("Phone", 100);

        // Create shipment
        Shipment shipment = new Shipment("SHP001", "Warehouse A");

        // Create vehicle
        Vehicle vehicle = new Vehicle("VH101", "John");

        // Display initial state
        System.out.println("Initial State:");
        warehouse.displayInventory();
        shipment.display();
        vehicle.display();

        // Assign vehicle
        if (vehicle.isAvailable()) {
            vehicle.assign();
            System.out.println("\nVehicle assigned to shipment.");
        }

        // Optimize route
        String route = RouteOptimizer.getOptimalRoute("Warehouse A", "Customer B");
        System.out.println(route);

        // Update shipment tracking
        shipment.updateLocation("On Route");
        shipment.updateStatus("Out for Delivery");

        // Update warehouse inventory
        warehouse.removeItem("Laptop", 1);

        // Final state
        System.out.println("\nAfter Updates:");
        shipment.display();
        vehicle.display();
        warehouse.displayInventory();
    }
}