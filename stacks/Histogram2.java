package stacks;

import java.util.Stack;

public class Histogram2 {
    public static int getMaxArea(int arr[],int n){
        Stack<Integer> s=new Stack<>();
        int res=0;
        int tp;
        int curr;
        for(int i=0;i<n;i++){
            while(s.isEmpty()==false && arr[s.peek()]>=arr[i]){
                tp=s.peek();s.pop();
                curr=arr[tp]* (s.isEmpty() ? i : i - s.peek() - 1);
                res=Math.max(res,curr);
            }
            s.add(i);
        }
        while(s.isEmpty()==false){
            tp=s.peek();s.pop();
            curr=arr[tp]* (s.isEmpty() ? n : n - s.peek() - 1);
            res=Math.max(res,curr);
        }

        return res;

    }
    public static void main (String[] args) {

        int[] arr=new int[]{6,2,5,4,1,5,6};

        System.out.print("Maximum Area: "+getMaxArea(arr,arr.length));

    }

}
