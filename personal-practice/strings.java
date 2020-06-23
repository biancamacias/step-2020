import java.awt.*;
import java.util.Scanner;

public class morePractice {
    
    public static void main(String[] args) {
        
        System.out.println("Enter a word:");
        Scanner sc = new Scanner(System.in);

        String userInput = sc.next();

        String uppercased = userInput.toUpperCase();
        System.out.println(uppercased);
        System.out.println(userInput);

        char firstCharacter = userInput.charAt(0);
        System.out.println(firstCharacter);

        System.out.println("Contains: " + userInput.contains("enter"));
    }
}