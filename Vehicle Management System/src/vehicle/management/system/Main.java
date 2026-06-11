/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vehicle.management.system;

import java.util.ArrayList;

/**
 *
 * @author andries
 */
public class Main {

    // Vehicles Storage Array
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {

        addTestData();
        displayMenu();

    }

    // Display Menu
    public static void displayMenu() {

        int option;

        do {
            System.out.print("\n\tMENU"
                    + "\n______________________\n"
                    + "\n1 • LIST VEHICLES"
                    + "\n2 • VIEW VEHICLE"
                    + "\n3 • ADD VEHICLE"
                    + "\n4 • EDIT VEHICLE"
                    + "\n5 • DELETE VEHICLE"
                    + "\n0 • EXIT"
                    + "\n______________________");

            option = Input.readIntInRange("\n\n➤ Enter your option: ", 0, 5);

            switch (option) {

                //Exit
                case 0:
                    System.out.println("Exiting...");
                    break;

                // List Vehicles
                case 1:
                    listVehicles();
                    break;

                // View Vehicle
                case 2:
                    viewVehicle();
                    break;

                // Add Vehicle
                case 3:
                    addVehicle();
                    break;

                // Edit Vehicle
                case 4:
                    editVehicle();
                    break;

                //Delete Vehicle
                case 5:
                    deleteVehicle();
                    break;
            }
        } while (option != 0);

    }

    // Test Data
    public static void addTestData() {

        //Cars
        vehicles.add(new Car("Toyota", "N123456W", 50000, "White"));
        vehicles.add(new Car("Kia", "N78910W", 4000, "Red"));

        //Trucks
        vehicles.add(new Truck("Iveco", "N877419W", 75000, 13600));
        vehicles.add(new Truck("Volvo", "N265317W", 89000, 15000));

    }

    // List Vehicles
    public static void listVehicles() {
        System.out.println("\nLIST OF VEHICLES");

        for (int i = 0; i < vehicles.size(); i++) {

            Vehicle vehicle = vehicles.get(i);

            System.out.println("\n🟡 VEHICLE " + (i + 1) + "\t\t" + vehicle.getMake() + "\t\t" + vehicle.getRegistration() + "\n_______________________________________________________");

        }
    }

    // View Vehicles
    public static void viewVehicle() {
        listVehicles();
        int option = Input.readIntInRange("\n\n➤ Enter the number of the vehicle you want to view: ", 1, vehicles.size());

        System.out.println("\n🚘 VEHICLE DETAILS");
        System.out.println(vehicles.get(option - 1));

    }

    // Add Vehicle
    public static void addVehicle() {
        System.out.print("\nChoose the type of vehicle to add");
        int option = Input.readIntInRange("\n\n 1 • Car \n 2 • Truck \n\n➤ Enter choice: ", 1, 2);

        switch (option) {

            case 1:
                System.out.println("\n\t  ADDING NEW CAR" + "\n___________________________________");

                // Make
                String make = Input.readString("\n➤ Enter car make: ");
                // Registration
                String registration = Input.readString("\n➤ Enter car registration: ");
                // Odo
                int odo = Input.readPositiveInt("\n➤ Enter car odometer: ");

                // Colur
                String colour = Input.readString("\n➤ Enter car colour: ");

                System.out.print("\n___________________________________" + "\n\n✅ New Car Successfully Added");

                // Adding new car to array
                vehicles.add(new Car(make, registration, odo, colour));
                break;

            case 2:
                System.out.println("\n\t  ADDING NEW TRUCK" + "\n___________________________________");

                // Make
                String truckMake = Input.readString("\n➤ Enter truck make: ");
                // Registration
                String truckRegistration = Input.readString("\n➤ Enter truck registration: ");
                // Odo
                int truckOdo = Input.readPositiveInt("\n➤ Enter truck odometer: ");

                // Tonnage
                double tonnage = Input.readPositiveDouble("\n➤ Enter truck tonnage: ");

                System.out.print("\n___________________________________" + "\n\n✅ New Truck"
                        + " Successfully Added\n");

                // Adding new truck to array
                vehicles.add(new Truck(truckMake, truckRegistration, truckOdo, tonnage));
        }
    }

    // Edit Vehicle
    public static void editVehicle() {
        listVehicles();
        int option = Input.readIntInRange("\n\n➤ Enter the number of the vehicle you want to edit: ", 1, vehicles.size());

        Vehicle selectedVehicle = vehicles.get(option - 1);

        System.out.println("\n\tEDITING\n" + selectedVehicle);

        try {

            // Make
            String make = Input.readString("\n➤ Enter new make • (Leave empty to keep the current data): ");
            if (make.isBlank()) {
                make = selectedVehicle.getMake();
            }

            // Registration
            String registration = Input.readString("\n➤ Enter new registration • (Leave empty to keep the current data): ");
            if (registration.isBlank()) {
                registration = selectedVehicle.getRegistration();
            }

            // Odo
            int odo;

            while (true) {
                odo = Input.readInt("\n➤ Enter new odometer • (Enter -1 to keep the current data): ");

                // Keep Current Data
                if (odo == -1) {
                    odo = selectedVehicle.getOdo();
                    break;
                } // Validate New Odometer
                else if (odo > 0) {
                    break;
                } else {
                    System.out.println("\n❌ Odometer must be greater than 0");
                }
            }

            // Car Editing
            if (selectedVehicle instanceof Car) {
                String colour = Input.readString("\n➤ Enter new colour • (Leave empty to keep the current data): ");
                if (colour.isBlank()) {
                    colour = ((Car) selectedVehicle).getColour();
                }

                Car editedCar = new Car(make, registration, odo, colour);

                vehicles.set(option - 1, editedCar);

                System.out.println("\n✅ Car Edited Successfully");
            }

            // Truck Editing
            if (selectedVehicle instanceof Truck) {

                double tonnage;

                while (true) {

                    tonnage = Input.readDouble("\n➤ Enter new tonnage • (Enter -1 to keep the current data):");
                    // Keep Current Data
                    if (tonnage == -1) {
                        tonnage = ((Truck) selectedVehicle).getTonnage();
                        break;
                    } // Validate New Tonnage
                    else if (tonnage > 0) {
                        break;
                    } else {
                        System.out.println("\n❌ Tonnage must be greater than 0");
                    }

                }

                Truck editedTruck = new Truck(make, registration, odo, tonnage);

                vehicles.set(option - 1, editedTruck);

                System.out.println("\n✅ Truck Edited Successfully");
            }

        } catch (IllegalArgumentException e) {

            System.out.println("\n❌ INVALID DATA: " + e.getMessage());
        }
    }

    // Delete Vehicle
    public static void deleteVehicle() {
        listVehicles();
        int option = Input.readIntInRange("\n\n➤ Enter the number of the vehicle you want to delete: ", 1, vehicles.size());

        System.out.println("\nAre you sure you want to delete \n" + vehicles.get(option - 1));

        int confirm = Input.readIntInRange("\n\n 1 • Confirm \n 0 • Cancel \n\n➤ Enter your choice: ", 0, 1);

        if (confirm == 1) {
            vehicles.remove(option - 1);
            System.out.println("\n ✅ Deletion Successfull");
        } else {
            System.out.println("\n❌ Deletion Canceled");
        }
    }
}
