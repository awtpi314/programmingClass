package chapter5;

import java.util.Scanner;

public class Exercise49 {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String inString = sc.nextLine();
        sc.close();

        int vowels = 0;
        int consonants = 0;

        for(int i = 0; i < inString.length(); i++) {
            if (Character.isAlphabetic(inString.charAt(i))) {
                if (isVowel(inString.charAt(i))) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.printf("The number of vowels is %d\n", vowels);
        System.out.printf("The number of consonants is %d\n", consonants);
    }

    private static boolean isVowel(Character c) {
        char cUpper = Character.toUpperCase(c);
        return cUpper == 'A' || cUpper == 'E' || cUpper == 'I' || cUpper == 'O' || cUpper == 'U';
    }
}
