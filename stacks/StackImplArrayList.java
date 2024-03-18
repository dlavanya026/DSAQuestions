package stacks;

import java.util.ArrayList;

public class StackImplArrayList {
    ArrayList<Integer> al=new ArrayList<>();
    void push(int x){
        al.add(x);
    }

    int pop(){
        int res=al.get(al.size()-1);
        al.remove(al.size()-1);
        return res;
    }

    int peek(){
        return al.get(al.size()-1);
    }

    int size(){
        return al.size();
    }

    boolean isEmpty(){
        return al.isEmpty();
    }
    public static void main (String[] args)
    {
        StackImplArrayList s=new StackImplArrayList();
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());
    }
}
