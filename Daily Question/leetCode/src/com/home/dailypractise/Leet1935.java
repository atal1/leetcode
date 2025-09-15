package com.home.dailypractise;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class Leet1935 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(canBeTypedWords1("hello world", "ad"));
        System.out.println(canBeTypedWords1("We cannot type either word because the", "ee"));

        System.out.print("Total time taken  :  ");
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        int counter = 0;
// set of brokenletters
        //Loop
        Set<Character> broken = new HashSet<>();

        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }
        //Stream   --this take more time then Loop almost double
        /*broken = brokenLetters.chars()
                .mapToObj( c -> (char) c)
        .collect(Collectors.toCollection(HashSet::new));*/
        //split the text into String array
        String[] allWords = text.split(" ");
        for (String str : allWords) {
            boolean possible = true;
            //Convert each String to charArray and check for each char
            for (char c : str.toCharArray()) {
                if (broken.contains(c)) {
                    possible = false;
                    break;
                }
            }
            if (possible)
                counter++;
        }
        //Convert each String to charArray and check for each char
        //update the counter if successful else continue the next

        return counter;
    }

    // Way faster then SET
    public static int canBeTypedWords1(String text, String brokenLetters) {
        int counter = 0;
        boolean[] broken = new boolean[128];
        for (char c : brokenLetters.toCharArray()) {
            broken[c] = true;
        }
        boolean possible = true;
        char[] textArrray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            if (textArrray[i] == ' ') {
                if (possible)
                    counter++;
                else
                    possible = true;
            } else if (broken[textArrray[i]]) {
                possible = false;
            }
        }
        if (possible)
            counter++;

        return counter;
    }
}
