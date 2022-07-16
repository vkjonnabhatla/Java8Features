package org.leetcode.challenges.easy;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Sha256 {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        String message = "krishna"; //scanner.nextLine()"";
        //scanner.close();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(message.getBytes());
            byte[] hash = messageDigest.digest();
            for(byte b : hash){
                //System.out.println(b);
                System.out.printf("%02x", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }
}
