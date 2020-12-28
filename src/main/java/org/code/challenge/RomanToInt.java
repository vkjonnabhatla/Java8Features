package org.code.challenge;

public class RomanToInt {
    public static void main(String[] args) {
        RomanToInt obj = new RomanToInt();
        int result = obj.romanToInt("IV");
        System.out.println(result);
    }

    public int romanToInt(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int result = 0;
        char[] ch = s.toCharArray();

        for(int i = 0; i < ch.length; i++){

            /*if(ch[i] == 'I' && (ch.length > (i + 1) && (ch[i + 1] == 'V' || ch[i + 1] == 'X'))){
                result = result + getRomanEquivalentInt(ch[i + 1]) - getRomanEquivalentInt(ch[i]);
                i++;
            }else if(ch[i] == 'X' && (ch.length > (i + 1) && (ch[i + 1] == 'L' || ch[i + 1] == 'C'))){
                result = result + getRomanEquivalentInt(ch[i + 1]) - getRomanEquivalentInt(ch[i]);
                i++;
            }else if(ch[i] == 'C' && (ch.length > (i + 1) && (ch[i + 1] == 'D' || ch[i + 1] == 'M'))){
                result = result + getRomanEquivalentInt(ch[i + 1]) - getRomanEquivalentInt(ch[i]);
                i++;
            }else{
                result = result + getRomanEquivalentInt(ch[i]);
            }*/

            if(ch.length > i + 1 && getRomanEquivalentInt(ch[i]) < getRomanEquivalentInt(ch[i + 1])){
                result = result + getRomanEquivalentInt(ch[i + 1]) - getRomanEquivalentInt(ch[i]);
                i++;
            }else{
                result = result + getRomanEquivalentInt(ch[i]);
            }
        }
        return result;
    }

    public int getRomanEquivalentInt(char ch){
        switch(ch){
            case 'M' : return 1000;
            case 'D' : return 500;
            case 'C' : return 100;
            case 'L' : return 50;
            case 'X' : return 10;
            case 'V' : return 5;
            case 'I' : return 1;
        }
        return 0;
    }
}
