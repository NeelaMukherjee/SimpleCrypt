import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

import java.io.*;
import java.util.ArrayList;

import static java.lang.Character.*;

public class ROT13 {
    private Integer difference;

    ROT13(Character cs, Character cf) {
        this.difference = cf - cs;
    }

    ROT13() {
        this.difference = 0;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        String result = "";
        char temp;
        for (int i = 0; i < text.length(); i++) {

            if (isAlphabetic(text.charAt(i))) {
                temp = text.toLowerCase().charAt(i);
                temp = (char) ((temp + difference - (int) 'a') % 26 + (int) 'a');
            } else {
                temp = text.charAt(i);
            }
            result += temp;

        }

        result = result.toUpperCase().substring(0, 1) + result.substring(1);

        return result;

    }

    public String encrypt(String text) {
        return crypt(text);

    }

    public String decrypt(String text) {
        String result = "";
        char temp;
        for (int i = 0; i < text.length(); i++) {
            if (isAlphabetic(text.charAt(i))) {
                temp = text.toLowerCase().charAt(i);
                temp = (char) ((temp - difference - (int) 'a' + 26) % 26 + (int) 'a');
            } else {
                temp = text.charAt(i);
            }
            result += temp;

        }
        result = result.toUpperCase().substring(0, 1) + result.substring(1);

        return result;
    }


    public static String rotate(String s, Character c) {
        int i = (c - (int) 'A') % s.length();
        return s.substring(i) + s.substring(0, i);
    }

}



