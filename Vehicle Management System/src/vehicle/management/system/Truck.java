/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehicle.management.system;

/**
 *
 * @author andries
 */
public class Truck extends Vehicle {

    double tonnage;

    public Truck(String make, String registration, int odo, double tonnage) {
        super(make, registration, odo);

        if (tonnage > 0) {
            this.tonnage = tonnage;
        } else {
            System.out.println("❌ Tonnage must be greater than 0");
        }
    }

    // Tonnage
    public double getTonnage() {
        return tonnage;
    }
    
    public void setTonnage(double tonnage){
        this.tonnage = tonnage;
    }
    
    @Override
    public String toString(){
        return super.toString()
                + "\nTONNAGE:\t" + tonnage + " kg"
                + "\n___________________________________\n";
    }
}
