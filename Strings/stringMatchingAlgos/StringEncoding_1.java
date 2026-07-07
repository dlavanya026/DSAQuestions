package Strings.stringMatchingAlgos;

//Pattern :- Two Pointer Time Complexity :- O(N)
public class StringEncoding_1 {
    //input :- aabbbcccccc
    //output :- 2a3b6c
    public static void main(String[] args) {
        String encodedString=encode("aabbbbcccccccc");
        System.out.println("Encoded String is :- "+encodedString);

    }

    private static String encode(String originalString) {
        if(originalString==null){
            return null;
        }

        StringBuilder sb=new StringBuilder();
        int curIndex=0;
        //walk through the string
        //Pattern is Two Pointer
        while(curIndex<originalString.length()){
            char currChar=originalString.charAt(curIndex);
            int alphaCount=0;
            int index=curIndex;

            while(index<originalString.length() && currChar==originalString.charAt(index)){
                index++;
                alphaCount++;
            }
            sb.append(alphaCount);
            sb.append(currChar);
            curIndex=index;

        }

        return sb.toString();
    }
}
