import java.awt.*;

public class intro {

    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("Bianca");

        car myCar = new car(25.5, 
        "1BC32B", 
        Color.BLUE, 
        true);

        car sallyCar = new car(13.9, 
        "3D2OBN", 
        Color.BLACK, 
        false);

        double myCarSpeed = 50;
        myCarSpeed = myCar.speedingUp(myCarSpeed);

        System.out.println(myCarSpeed);
    }
}