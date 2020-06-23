import java.awt.*;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class arrays {

    public static void main(String[] args) {
        // 21, 45, 22, 98, 10
        int[] numbers = new int[5];

        numbers[0] = 31;
        numbers[1] = 45;
        numbers[2] = 22;
        numbers[3] = 98;
        numbers[4] = 10;

        int[] numbers2 = {31, 45, 22, 98, 10};
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));

        String[] myFavoriteCandyBars = {"Twix", "Hersheys", "Crunch"};
        System.out.println("Index 2: " + myFavoriteCandyBars[2]);
        myFavoriteCandyBars[2] = "Butterfinger";
        System.out.println("Index 2: " + myFavoriteCandyBars[2]);
        System.out.println("Length: " + myFavoriteCandyBars.length);
    }
}