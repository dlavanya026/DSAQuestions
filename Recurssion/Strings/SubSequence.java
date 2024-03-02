package Recurssion.Strings;

import java.util.ArrayList;//input :- abc-->o/p :- a,b,c,ab,bc,ac,abc
public class SubSequence {
    public static void main(String[] args) {
        //subSeq("","abc");
        ArrayList<String> list=subSeq1("","abc",new ArrayList<String>());
        for(String l:list){
            System.out.print(l+":");
        }
        System.out.println();
        ArrayList<String> list1=subSeq2("","abc");
        for(String l:list1){
            System.out.print(l+":");
        }
    }

    private static void subSeq(String ans, String input) {
        if(input.isEmpty()){
            System.out.println(ans);
            return;
        }
        char ch=input.charAt(0);
        subSeq(ans+ch, input.substring(1));
        subSeq(ans,input.substring(1));
    }



    public static ArrayList<String> subSeq1(String ans, String input,ArrayList<String> list){
        if(input.isEmpty()){
            list.add(ans);
            return list;
        }
        char ch=input.charAt(0);
        subSeq1(ans+ch,input.substring(1),list);
        subSeq1(ans,input.substring(1),list);
        return list;
    }

    //Return ArrayList from function body
    public static ArrayList<String> subSeq2(String ans, String input){
        if(input.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(ans);
            return list;
        }
        char ch=input.charAt(0);
        ArrayList<String> left=subSeq2(ans+ch,input.substring(1));
        ArrayList<String> right=subSeq2(ans,input.substring(1));
        left.addAll(right);
        return left;

    }
}


