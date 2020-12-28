package org.leetcode.challenges.easy;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinaryNew("110010", "10111"));
    }

    // My own logic --> not working
    public String addBinary(String a, String b) {

        if ((a == null && b == null) || (a.length() == 0 && b.length() == 0)) {
            return "";
        } else if ((a == null || a.length() == 0) && b != null) {
            return b;
        } else if (a != null && (b == null || b.length() == 0)) {
            return a;
        }

        int i = a.length();
        int j = b.length();

        int k = 0;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (k < i && k < j) {
            int sum = Character.getNumericValue(a.charAt((a.length() - 1 - k)))
                    + Character.getNumericValue(b.charAt((b.length() - 1 - k)));
            if (sum == 2) {
                result.append(carry == 1 ? carry : 0);
                carry = 1;
            } else {
                if((sum + carry) == 2){
                    result.append("0");
                    carry = 1;
                }else{
                    result.append(sum);
                    carry = 0;
                }
            }
            k++;
        }

        while (k < i) {
            int sum = Character.getNumericValue(a.charAt((a.length() - 1 - k)))
                    + carry;
            if (sum == 2) {
                carry = 1;
                result.append("0");
            } else {
                carry = 0;
                result.append(sum);
            }
            k++;
        }

        while (k < j) {
            int sum = Character.getNumericValue(b.charAt((b.length() - 1 - k)))
                    + carry;
            if (sum == 2) {
                carry = 1;
                result.append("0");
            } else {
                carry = 0;
                result.append(sum);
            }
            k++;
        }

        if (carry == 1) result.append(carry);
        return result.reverse().toString();
    }

    public String addBinaryNew(String a, String b){
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while(i >= 0 || j >= 0){
            sum = carry;

            if(i >= 0){
                sum += a.charAt(i--) - '0';
            }

            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }

            sb.insert(0, sum % 2);
            carry = sum / 2;
        }

        if(carry > 0){
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
