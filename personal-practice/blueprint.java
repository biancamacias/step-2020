import java.awt.*;

public class blueprint {

    String name;
    int ageInHumanYears;
    Color furColor;
    String size;

    public Dog(String inputName, int inputAge, Color inputFurColor, String inputSize) {
        this.name = inputName;
        this.ageInHumanYears = inputAge;
        this.furColor = inputFurColor;
        this.size = inputSize;
    }

    public void changeDogAge(int newAge) {
        this.ageInHumanYears = newAge
    }
}