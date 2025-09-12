package com.home.dailypractise;

public class Leet3227 {
    public static void main(String[] args) {

//        System.out.println(doesAliceWin("leetcoder"));
//        System.out.println(doesAliceWin("bbcd"));
//        System.out.println(doesAliceWin("ifld"));
        System.out.println(doesAliceWin("aeiou"));
        System.out.println(doesAliceWin1("aeiou"));
    }


    //This is wrong answer, Alice always wins, as long as there is one vowel at least
    public static boolean doesAliceWin(String s) {

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        boolean[] isVowel = new boolean[128];
        for (char v : vowels) {
            isVowel[v] = true;
        }
        int vowelCounter = 0;
        for (char c : s.toCharArray()) {
            if (isVowel[c])
                vowelCounter++;
        }

        if (vowelCounter == 0)
            return false;
        if(vowelCounter ==1)
            return true;

        //total odd, then check if end is vowel else Alice loses
        boolean odd = vowelCounter % 2 != 0;
        if (odd) {
            return vowelCounter != s.length();
        }
        return true;

    }

    public static boolean doesAliceWin1(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a','e','i','o','u':
                    return true;
            }
        }

        return false;
    }

}
