import java.awt.*;
import java.lang.Math;
import java.util.Random;

public class diceMain {
    
    public static void main(String[] args) {
        Dice dice = new Dice();
        System.out.println(dice.roll());
        System.out.println(dice.roll());
        System.out.println("Previous: " + dice.previousRoll);
    }
}