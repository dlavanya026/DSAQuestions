package Strings.stringMatchingAlgos;

public class StringDecoding_2 {
    //input 1a22b1c
    public static void main(String[] args) {
        String originalString=decodeString("1a22b1c");
        System.out.println("The decoded String is :"+originalString);
    }

    private static String decodeString(String decodedString) {
        if(decodedString==null){
            return null;
        }
        StringBuilder sb=new StringBuilder();
        int digitStartIndex=0;
        int digitLastIndex=1;
        // 1a
        //22 b
        //1 c
        while (digitLastIndex<decodedString.length()){
            while(Character.isDigit(decodedString.charAt(digitLastIndex))){
                digitLastIndex++;
            }
            int charIndex=digitLastIndex;
            String numString=decodedString.substring(digitStartIndex,digitLastIndex);
            int num=Integer.valueOf(numString);
            for(int i=0;i<num;i++){
                sb.append(decodedString.charAt(charIndex));
            }
            digitStartIndex=charIndex+1;
            digitLastIndex=digitStartIndex+1;
        }

        return sb.toString();
    }
}
