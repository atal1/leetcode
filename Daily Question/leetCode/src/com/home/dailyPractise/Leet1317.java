package com.home.dailyPractise;

public class Leet1317 {

    public static void main(String[] args) {

        int[] n = {11, 2, 34, 45, 45};
        for (int i = 0; i < n.length; i++) {
            int[] arr = getNoZeroIntegers(n[i]);
            System.out.println(arr[0]+"  "+arr[1]);
        }
    }

    public static int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];

        for (int i = 1, j = n - 1; i < n; i++, j--) {

            if (noZero(i)&& noZero(j)) {
                arr[0] = i;
                arr[1] = j;
                return arr;
            }
        }


        return arr;

    }

    public static boolean noZero(int i ){
        while(i >0 ){
            if(i%10==0)
                return  false;
            i/=10;
        }

        return true;
    }


}
