package com.home.dailypractise;

import java.util.*;

public class Leet966{

    public static void main(String[] args) {

        String []  wordlist = {"v","t","k","g","n","k","u","h","m","p"};
        String [] queries = {"n","g","k","q","m","h","x","t","p","p"};
        System.out.println(Arrays.toString(spellchecker(wordlist, queries)));
    }
    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            exactWords.add(word);
            caseInsensitive.putIfAbsent(word.toLowerCase(), word);
            vowelInsensitive.putIfAbsent(normalize(word), word);
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (exactWords.contains(query)) {
                result[i] = query;
            } else if (caseInsensitive.containsKey(query.toLowerCase())) {
                result[i] = caseInsensitive.get(query.toLowerCase());
            } else {
                result[i] = vowelInsensitive.getOrDefault(normalize(query), "");
            }
        }

        return result;
    }

    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static boolean[] isVowel = new boolean[128];
    static {
        for (char v : vowels) {
            isVowel[v] = true;
        }
    }

    private static String normalize(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toLowerCase().toCharArray()) {
            sb.append(isVowel[c] ? '*' : c);
        }
        return sb.toString();
    }




    //Fastest solution :
    public String[] spellcheckerFast(String[] wordlist, String[] queries) {
        int m = wordlist.length, n = queries.length;
        String[] res = new String[n];
        Map<String, Integer> caseSense = new HashMap<>();
        Map<String, Integer> caseInsense = new HashMap<>();
        Map<String, Integer> vowelErrors = new HashMap<>();
        for (int i = m - 1; i >= 0; i--) {
            String word = wordlist[i];
            caseSense.put(word, i);
            String lowerCase = word.toLowerCase();
            char[] vowelRepArr = lowerCase.toCharArray();
            for (int j = 0; j < vowelRepArr.length; j++) {
                if (vowelRepArr[j] == 'e' || vowelRepArr[j] == 'i' || vowelRepArr[j] == 'o' || vowelRepArr[j] == 'u') {
                    vowelRepArr[j] = 'a';
                }
            }
            caseInsense.put(lowerCase, i);
            vowelErrors.put(new String(vowelRepArr), i);
        }
        for (int i = 0; i < n; i++) {
            String word = queries[i];
            if (caseSense.containsKey(word)) {
                res[i] = word;
                continue;
            }

            String lowerCase = word.toLowerCase();
            if (caseInsense.containsKey(lowerCase)) {
                res[i] = wordlist[caseInsense.get(lowerCase)];
                continue;
            }

            char[] vowelRepArr = lowerCase.toCharArray();
            for (int j = 0; j < vowelRepArr.length; j++) {
                if (vowelRepArr[j] == 'e' || vowelRepArr[j] == 'i' || vowelRepArr[j] == 'o' || vowelRepArr[j] == 'u') {
                    vowelRepArr[j] = 'a';
                }
            }
            String vowelRepStr = new String(vowelRepArr);
            if (vowelErrors.containsKey(vowelRepStr)) {
                res[i] = wordlist[vowelErrors.get(vowelRepStr)];
                continue;
            }
            res[i] = "";
        }

        return res;

    }

}
