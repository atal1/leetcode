package com.home.dailypractise;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leet2197 {
    public static void main(String[] args) {
        System.out.println(replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2}));
    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {

        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            stack.add(num);
            while (stack.size() >= 2) {
                int a = stack.get(stack.size() - 2);
                int b = stack.getLast();
                int gcd = findGCD(a, b);
                if (gcd > 1) {
                    stack.removeLast();
                    stack.removeLast();
                    stack.add(lcm(a, b));
                } else {
                    break;
                }
            }
        }

        return stack;
    }
     private static int lcm(int a, int b){
        return  a/findGCD(a,b) *b;
    }

    private static  int findGCD(int a, int b){

        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    public List<Integer> replaceNonCoprimes1(int[] nums) {

        int n = nums.length;
        int[] stack = new int[n];
        int top = -1;

        for(int num:nums){

            while(top != -1){
                int x = gcd(stack[top], num);
                if(x == 1) break;
                num *= stack[top--]/x;
            }

            stack[++top] = num;
        }

        List<Integer> result = new ArrayList<Integer>(top + 1);
        for(int i = 0; i <= top; ++i)
            result.add(stack[i]);

        return result;
    }

    public int gcd(int a, int b){
        return b == 0 ? a: gcd(b, a % b);
    }

}
