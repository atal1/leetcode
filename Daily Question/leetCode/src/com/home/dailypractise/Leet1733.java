package com.home.dailypractise;

import java.util.*;

public class Leet1733 {
    public static void main(String[] args) {
        int n = 2;
        int[][] languages = {{1}, {2}, {1, 2}};
        int[][] friendship = {{1, 2}, {1, 3}, {2, 3}};


        System.out.println(minimumTeachings(n, languages, friendship));
        System.out.println(minimumTeachings1(n,languages,friendship));
    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {


        // Convert each user's language list to a Set for fast lookup
        List<Set<Integer>> userLangs = new ArrayList<>();
        for (int[] langList : languages) {
            Set<Integer> set = new HashSet<>();
            for (int lang : langList) {
                set.add(lang);
            }
            userLangs.add(set);
        }

        // Step 1: Identify users in problematic friendships
        Set<Integer> needHelp = new HashSet<>();
        for (int[] pair : friendships) {
            int u = pair[0] - 1;
            int v = pair[1] - 1;
            Set<Integer> langsU = userLangs.get(u);
            Set<Integer> langsV = userLangs.get(v);
            boolean canCommunicate = false;
            for (int lang : langsU) {
                if (langsV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                needHelp.add(u);
                needHelp.add(v);
            }
        }

        // Step 2: Try teaching each language and count how many users need to learn it
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int teachCount = 0;
            for (int user : needHelp) {
                if (!userLangs.get(user).contains(lang)) {
                    teachCount++;
                }
            }
            minTeach = Math.min(minTeach, teachCount);
        }

        return minTeach;
    }

    public static int minimumTeachings1(int n, int[][] L, int[][] F) {

        /*  Creates an array of BitSets, one for each user.
            Each BitSet represents the languages known by that user.
         */
        BitSet[] bit = new BitSet[L.length];
        //Sets the bits corresponding to the languages each user knows.
        Arrays.setAll(bit, o -> new BitSet(n + 1));
        for (int i = 0; i < L.length; i++) {
            for (int l : L[i]) {
                bit[i].set(l);
            }
        }

        //Identify Problematic Friendships
        Set<Integer> teach = new HashSet<>();
        for (int[] f : F) {
            BitSet t = (BitSet) bit[f[0] - 1].clone();
            t.and(bit[f[1] - 1]);
            if (t.isEmpty()) {
                teach.add(f[0] - 1);
                teach.add(f[1] - 1);
            }
        }
        //Count Language Frequencies Among Users Needing Help
        int[] count = new int[n + 1];
        for (int person : teach) {
            for (int l : L[person]) {
                count[l]++;
            }
        }

        //The best language to teach is the one already known by the most users in teach

        return teach.size() - Arrays.stream(count).max().getAsInt();
    }
}
