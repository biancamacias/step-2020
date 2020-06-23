import java.awt.*;

public class car {

    // Data Types: 
    // int
    // double (float)
    // string
    // Color (from awt library)
    // boolean

    int averageMilesPerGallon;
    String licensePlate;
    Color paintColor;
    boolean areTaillightsWorking;

    public Car(int inputAverageMPG, 
    String inputLicensePlate, 
    Color inputPaintColor, 
    boolean inputAreTaillightsWorking) {
        this.averageMilesPerGallon = inputAverageMPG;
        this.licensePlate = inputLicensePlate;
        this.paintColor = inputPaintColor;
        this.areTaillightsWorking = inputAreTaillightsWorking;
    }
}