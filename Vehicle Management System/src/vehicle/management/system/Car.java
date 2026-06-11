/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.management.system;

/**
 *
 * @author andries
 */
public class Car extends Vehicle {

    private String colour;

    public Car(String make, String registration, int odo, String colour) {
        super(make, registration, odo);
        this.colour = colour;
    }

    // Colour
    public String getColour() {
        return colour;
    }

    public void setcolour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nCOLOUR:\t\t" + colour
                + "\n___________________________________\n";
    }
}
