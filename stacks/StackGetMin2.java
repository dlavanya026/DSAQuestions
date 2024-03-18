package stacks;

import java.util.Stack;

//with O(1) auxialliry space
//Design a Stack with getMin() in O(1) Space


//Works with positive and Negative
class MyStack {

    Stack<Integer> s;
    int min;

    MyStack(){
        s=new Stack<>();
    }

    void push(int x) {

        if(s.isEmpty() ) {
            min=x;
            s.add(x);
        }
        else if(x<=min){
            s.add(2*x-min);
            min=x;
        }else{
            s.add(x);
        }
    }

    int pop() {

        int t=s.peek();s.pop();
        if(t<=min){
            int res=min;
            min=2*min-t;
            return res;
        }else{
            return t;
        }
    }

    int peek() {
        int t=s.peek();
        return ((t<=min)? min : t);
    }

    int getMin() {
        return min;
    }
}


public class StackGetMin2 {
    Stack<Integer> s;
    int min;

    StackGetMin2(){
        s=new Stack<>();
    }

    void push(int x) {

        if(s.isEmpty() ) {
            min=x;
            s.add(x);
        }
        else if(x<=min){
            s.add(x-min);
            min=x;
        }else{
            s.add(x);
        }
    }

    int pop() {

        int t=s.peek();s.pop();
        if(t<=0){
            int res=min;
            min=min-t;
            return res;
        }else{
            return t;
        }
    }

    int peek() {
        int t=s.peek();
        return ((t<=0)? min : t);
    }

    int getMin() {
        return min;
    }
}

class GFG {

    public static void main(String[] args)
    {
        StackGetMin2 s=new StackGetMin2();;
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.print(" Minimum Element from Stack: " + s.getMin() );
        MyStack s1=new MyStack();;
        s1.push(-4);
        s1.push(5);
        s1.push(8);
        s1.push(1);
        s1.pop();

        System.out.print(" Minimum Element from Stack1: " + s1.getMin() );
    }
}