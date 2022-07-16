package org.leetcode.challenges.easy;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(sqrt(3));
    }


    public static int sqrt1(int x){

        long start = 1, end = x;
        if(x < 2) return x;

        while(start <= end){
            long mid = ( start + end ) / 2;
            if(mid * mid == x){
                return (int)mid;
            }else if(mid * mid < x){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return (int)(start - 1);
    }


    public static int sqrt(int x){

        long start = 1, end = x, mid = 0;
        if(x < 2){
            return x;
        }

        while(start <= end){
            mid = (start + end) / 2;

            if(mid * mid == x) {
                return (int)mid;
            }else if(mid * mid < x){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return (int)(start - 1);
    }

}
