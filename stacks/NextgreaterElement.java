package stacks;
import java.io.*;
import java.util.*;
//O/p :- 15 18 12 12 12 18 18 -1
public class NextgreaterElement {
    public static void printGreater(int arr[],int n){

        for(int i=0;i<n;i++){
            int j;
            for(j=i+1;j<n;j++){
                if(arr[j]>arr[i]){
                    System.out.print(arr[j]+" ");
                    break;
                }
            }
            if(j==n)
                System.out.print(-1+" ");
        }
    }

    public static ArrayList<Integer> nextGreaterEfficient(int arr[],int n){
        ArrayList<Integer> v=new ArrayList<>();
        Stack <Integer> s=new Stack<>();
        s.add(arr[n-1]);v.add(-1);
        for(int i=n-2;i>=0;i--){
            while(s.isEmpty()==false && s.peek()<=arr[i])
                s.pop();
            int ng=s.isEmpty()?-1:s.peek();
            v.add(ng);
            s.add(arr[i]);
        }
        Collections.reverse(v);
        return v;
    }
    public static void main (String[] args) {

        int[] arr=new int[]{5,15,10,8,6,12,9,18};

        printGreater(arr,arr.length);

        int[] arr1=new int[]{5,15,10,8,6,12,9,18};

        for(int x: nextGreaterEfficient(arr1,arr1.length)){
            System.out.print(x + " ");
        }

    }
}
