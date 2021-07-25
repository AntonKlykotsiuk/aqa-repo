package com.java.anton_klykotsiuk.java.lection3.task2;

import java.util.Scanner;

public class FinderInString {

    private static final int NUMBER_OF_WORDS = 2;

    public static void main(String[] args) {
        FinderInString finder = new FinderInString();

        finder.runFinderOfDigitWord();
    }

    public void runFinderOfDigitWord() {
        String input;
        String[] words;
        int digitWordCounter = 0;
        int wordIndex = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Input string of words: ");
        input = in.nextLine();
        System.out.println(input);
        words = input.split("\\s");

        for (int i = 0; i < words.length; i++) {

            if (words[i].matches("\\d+") && digitWordCounter < NUMBER_OF_WORDS) {
                digitWordCounter++;
                wordIndex = i;
            }
        }
        System.out.println("Word of digits: " + words[wordIndex]);
        in.close();
    }
}
