package Recurssion.Strings;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class PhonePad {

    public static void main(String[] args) {
        ArrayList<String> list= (ArrayList<String>) letterCombinations("23");
        for (String s:list){
            System.out.print(s+":");
        }
    }
    public static List<String> letterCombinations(String digits) {
        String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return  padRet("",digits,mapping);
    }
    static ArrayList<String> padRet(String p, String up, String[] mapping) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            if(!p.isEmpty())
                list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'; // this will convert '2' into 2
        String value = mapping[digit];

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < value.length(); i++) {
            char ch = (char) value.charAt(i);
            list.addAll(padRet(p + ch, up.substring(1),mapping));
        }
        return list;
    }
}
