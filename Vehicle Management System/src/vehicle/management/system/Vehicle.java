/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.management.system;

/**
 *
 * @author andries
 */
public abstract class Vehicle {

    private String make;
    private String registration;
    private int odo;

    public Vehicle(String make, String registration, int odo) {

        this.make = make;
        this.registration = registration;

        if (odo > 0) {
            this.odo = odo;
        } else {
            System.out.println("❌ Odometer must be greater than 0");
        }
    }

    // Make
    public String getMake() {
        return make;
    }

    // Registration
    public String getRegistration() {
        return registration;
    }

    // Odo
    public void setOdo(int odo) {

        if (odo > 0) {
            this.odo = odo;
        } else {
            System.out.println("❌ Odometer must be greater than 0");
        }
    }

    public int getOdo() {
        return odo;
    }

    @Override
    public String toString() {
        return "___________________________________\n"
                + "\nMAKE:\t\t" + make
                + "\nREGISTRATION:\t" + registration
                + "\nODOMETER:\t" + odo + " km";
    }
}
