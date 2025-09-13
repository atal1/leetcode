package com.home.dailypractise;

public class Leet3541 {
    public static void main(String[] args) {
        System.out.println(maxFreqSum("successes"));
        System.out.println(maxFreqSum("aeiaeia"));
    }


    //can be done by reducing the size to only 26, and then removing boolean arrays and other
    public static int maxFreqSum(String s) {
        int maxfrequencyVowel = 0;
        int maxFrequencyConsonant = 0;
        boolean[] isVowel = new boolean[128];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] counter = new int[128];

        for (char vowel : vowels)
            isVowel[vowel] = true;

        for (char c : s.toCharArray())
            counter[c] += 1;

        for (int i = 0; i < 128; i++) {
            if (isVowel[i]) {
                maxfrequencyVowel = Math.max(maxfrequencyVowel, counter[i]);
            } else {
                maxFrequencyConsonant = Math.max(maxFrequencyConsonant, counter[i]);
            }
        }

        return maxFrequencyConsonant + maxfrequencyVowel;
    }


}
