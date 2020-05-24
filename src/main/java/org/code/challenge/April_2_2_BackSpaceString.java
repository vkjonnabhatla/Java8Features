package org.code.challenge;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 */
public class April_2_2_BackSpaceString {

    public static void main(String[] args) {
        //System.out.println(backspaceCompare("a#c", "b"));
        //System.out.println(backspaceCompare("a##c", "#a#c"));
        //System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("ab#cd", "ad#cb"));
    }

    public static boolean backspaceCompare_my_approach(String S, String T) {
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '#'){
                S = S.substring(0, i < 0 ? 0 : i) + S.substring(i + 1, S.length()) ;
                i = i - 2;
                i = i < 0 ? -1 : i;
            }
        }
        for(int i = 0; i < T.length(); i++){
            if(T.charAt(i) == '#'){
                T = T.substring(0, i - 1) + T.substring(i + 1, T.length());
                i = i - 2;
                i = i < 0 ? -1 : i;
            }
        }
        if(S.equals(T)){ return true; } return false;
    }

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(S.charAt(i) == '#'){
                    skipS++; i--;
                }else if(skipS > 0) {
                    skipS--; i--;
                }else{
                    break;
                }
            }
            while(j >= 0){
                if(T.charAt(j) == '#'){
                    skipT++; j--;
                }else if(skipT > 0){
                    skipT--; j--;
                }else{
                    break;
                }
            }
            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)){
                return false;
            }

            if((i >= 0) != (j >= 0)){
                return false;
            }
            i--; j--;
        }
        return true;
    }

    /**
     * Using stack approach
     * @return
     */
    public static boolean compareStrings(String S, String T){
        return build(S).equals(build(T));
    }

    public static String build(String S){
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(c != '#'){
                stack.push(c);
            }else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return stack.toString();
    }

}
