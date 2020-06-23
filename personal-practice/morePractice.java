import java.awt.*;

public class morePractice {
    
    public static void main(String[] args) {
        String userInput = "entertainment";
        String uppercased = userInput.toUpperCase();
        System.out.println(uppercased);
        System.out.println(userInput);

        char firstCharacter = userInput.charAt(0);
        System.out.println(firstCharacter);

        System.out.println("Contains: " + userInput.contains("enter"));
    }
}