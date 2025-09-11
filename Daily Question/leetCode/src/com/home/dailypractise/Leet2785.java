package com.home.dailypractise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leet2785 {
    public static void main(String[] args) {


        System.out.println(sortVowels("lEetcOde"));
        System.out.println(sortVowels1("lYmpH"));
    }

    public static String sortVowels(String s) {

        List<Character> charArray = new ArrayList<>();
        char[] sChar = s.toCharArray();
        int[] index = new int[s.length()];
        String str = "aeiouAEIOU";
        //insert all vowels into charArray
        //Maintain another int array for index
        int j =0;
        for (int i = 0; i < sChar.length; i++) {

            if (str.indexOf(sChar[i]) != -1) {
                charArray.add(sChar[i]);
                index[j] = i;
                j++;
            }
        }
        //sort the array with Ascii values in asc order
        Collections.sort(charArray);
        //Run loop on charArray and insert the data String s
        for (int i = 0; i < charArray.size(); i++) {
            sChar[index[i]] = charArray.get(i);
        }
        return String.valueOf(sChar);
    }


    public static  String sortVowels1(String s) {
        char[] vowels = {'A','E','I','O','U','a','e','i','o','u'};
        int[] stringCharCount = new int[128];
        char[] sChars = s.toCharArray();
        for(char ch : sChars){
            stringCharCount[ch]++;
        }
        boolean found = false;
        for(char ch : vowels){
            found |= stringCharCount[ch]>0;
        }
        if(!found) return s;

        boolean[] isVowels = new boolean[128];
        for(char ch : vowels){
            if(stringCharCount[ch]>0) isVowels[ch] = true;
        }
        int left = 0;
        for(char v : vowels){
            while(stringCharCount[v]>0){
                char ch = sChars[left];
                stringCharCount[v] -= isVowels[ch]?1:0;
                sChars[left] = isVowels[ch]?v:ch;
                left++;
            }
        }
        return new String(sChars);
    }

}
