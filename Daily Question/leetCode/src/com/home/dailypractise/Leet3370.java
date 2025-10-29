package com.home.dailypractise;

public class Leet3370 {

    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
        System.out.println(smallestNumber(10));
        System.out.println(smallestNumber(4));
        System.out.println(smallestNumber(3));
    }

    public static int smallestNumber(int n) {

        int number =2;
        while(number <= n){
            number*=2;
        }
        return  number -1;
    }

    public int smallestNumberAnd(int n) {
        int x=n;
        while((x&(x+1))!=0){
            x++;
        }
        return x;
    }
}
