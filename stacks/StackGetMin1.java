package stacks;

import java.util.Stack;
// Minimum Element from Stack: 4
public class StackGetMin1 {
    Stack<Integer> ms;
    Stack<Integer> as;

    StackGetMin1(){
        ms=new Stack<>();
        as=new Stack<>();
    }

    void push(int x) {

        if(ms.isEmpty() ) {
            ms.add(x);as.add(x);return;
        }

        ms.add(x);

        if(as.peek()>=ms.peek())
            as.add(x);
    }

    void pop() {

        if(as.peek()==ms.peek())
            as.pop();
        ms.pop();

    }

    int top() {
        return ms.peek();
    }

    int getMin() {
        return as.peek();
    }

    public static void main(String[] args)
    {
        StackGetMin1 s=new StackGetMin1();;
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();

        System.out.print(" Minimum Element from Stack: " + s.getMin() );

    }
}
