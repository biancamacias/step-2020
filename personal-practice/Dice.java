import java.awt.*;
import java.util.Scanner;
import java.util.concurrent.Future;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    Random rand;
    int previousRoll = -1;

    public Dice() {

    this.rand = new Random();
    }

    public int roll() {
        int currentRoll = this.rand.nextInt(6) + 1;
        this.previousRoll = currentRoll;
        return currentRoll;
    }
}