package com.home.dailyPractise;

import java.util.Arrays;

public class Leet2966 {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        var currenttime = System.currentTimeMillis();
        //Call all that is needed here
        int [] arr = {1,3,4,8,7,9,3,5,1};//{2,4,2,2,5,2};//{4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11};//
        int[][] m = Leet2966.divideArray(arr,2);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println(); // move to next line after each row
        }

        var totalTime= System.currentTimeMillis()-currenttime;




        System.out.println("Total time taken  : "+ totalTime);
    }


    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int d = n/3;
        int [][] result = new int[d][3];
        Arrays.sort(nums);
        for(int i =0 ; i < d ;i++) {
            if (nums[i+2] - nums[i] > k) {
                return new int[0][];
            }
        }

        for(int i =0, j=0 , l =0 ; i <n ; i++,l++){
            result[j][l] = nums[i];
            if(l == 2)
            {
                l = -1 ;
                j++;
            }

        }


        return result;
    }
}
