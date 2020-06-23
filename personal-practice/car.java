import java.awt.*;
import java.awt.Color;

public class car {

    // Data Types: 
    // int
    // double (float)
    // string
    // Color (from awt library)
    // boolean

    double averageMilesPerGallon;
    String licensePlate;
    Color paintColor;
    boolean areTaillightsWorking;

    public car(double inputAverageMPG, 
    String inputLicensePlate, 
    Color inputPaintColor, 
    boolean inputAreTaillightsWorking) {
        this.averageMilesPerGallon = inputAverageMPG;
        this.licensePlate = inputLicensePlate;
        this.paintColor = inputPaintColor;
        this.areTaillightsWorking = inputAreTaillightsWorking;
    }

    public void changePaintColor(Color newPaintColor) {
        this.paintColor = newPaintColor;
    }

    public double speedingUp(double currentSpeed) {
        currentSpeed += 100;
        return currentSpeed;

    }
}