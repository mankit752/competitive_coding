package com.coding_practice.more_adhoc;

import java.util.Scanner;

public class RemoveCharacters2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        char c1 = s.next().charAt(0);
        char c2 = s.next().charAt(0);
        System.out.println(replaceCharacter(input, c1, c2));
    }

    private static String replaceCharacter(String input, char c1, char c2) {
        if(input.length() == 0) {
            return input;
        }
        if(input.charAt(0) == c1) {
            return c2 + replaceCharacter(input.substring(1), c1, c2);
        } else{
            return input.charAt(0) + replaceCharacter(input.substring(1), c1, c2);
        }
    }

}
