import java.awt.*;
import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ifElse {

    public static void main(String[] args) {
        System.out.println("Enter an age: ");
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();

        if (age >= 0 && age <= 5) {
            System.out.println("baby");
        } else if (age >= 6 && age <= 11) {
            System.out.println("kid");
        } else if (age >= 12 && age <= 17) {
            System.out.println("teen");
        } else if (age >= 18) {
            System.out.println("adult");
        } else {
            System.out.println("invalid");
        }

        System.out.println("Thanks for using this program!");
    }
}