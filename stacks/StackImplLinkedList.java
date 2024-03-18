package stacks;

import java.util.ArrayDeque;

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

public class StackImplLinkedList {
    Node head;
    int sz;
    StackImplLinkedList(){
        head=null;
        sz=0;
    }

    void push(int x){
        Node temp=new Node(x);
        temp.next=head;
        head=temp;
        sz++;
    }

    int pop(){
        if(head==null){return Integer.MAX_VALUE;}
        int res=head.data;
        Node temp=head;
        head=head.next;
        sz--;
        return res;
    }

    int peek(){
        if(head==null){return Integer.MAX_VALUE;}
        return head.data;
    }

    int size(){
        return sz;
    }

    boolean isEmpty(){
        return head==null;
    }

    public static void main (String[] args)
    {
        StackImplLinkedList s=new StackImplLinkedList();
        s.push(5);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.size());
        System.out.println(s.peek());
        System.out.println(s.isEmpty());


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());


    }
}

