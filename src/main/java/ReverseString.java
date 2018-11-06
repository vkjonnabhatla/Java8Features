public class ReverseString {

    public static void main(String[] args){

        int ij = (8 >> 1);

        String str = "Nisum";
        StringBuffer sb = new StringBuffer("VenkataKri");

        char[] charArr = sb.toString().toCharArray();
        int count = sb.length() - 1;

        for(int j = (sb.length()/2 - 1); j >= 0; j--){
            int k = count -j;
            char ch1 = charArr[j];
            char ch2 = charArr[k];
            charArr[j] = ch2;
            charArr[k] = ch1;
        }

        System.out.println(charArr.toString());



        StringBuffer str1 = sb.reverse();
        System.out.println("Reverse String is: "+ str1);
        char[] seq = str.toCharArray();
        for(int i = seq.length - 1; i >= 0; i--){
            sb.append(seq[i]);
        }
        //System.out.println("Reverse String is: "+ sb.reverse());
    }
}
