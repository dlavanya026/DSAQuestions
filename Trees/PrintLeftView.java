package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftView {
    public static void main(String args[])
    {
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.right.left=new Node(40);
        root.right.right=new Node(50);

        printLeftView(root);
    }

    static int maxLevel=0;
    public static void printLeft(Node root,int level){
        if(root==null)
            return;
        if(maxLevel<level){
            System.out.print(root.key+" ");
            maxLevel=level;
        }
        printLeft(root.left,level+1);
        printLeft(root.right,level+1);
    }

    public static void printLeftView(Node root){
        printLeft(root,1);
    }

    //Iterative Solution:-
    public static void printLeftIterative(Node root){
        if(root==null)
            return;
        Queue<Node > q=new LinkedList<>();q.add(root);
        while(q.isEmpty()==false){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                if(i==0)
                    System.out.print(curr.key+" ");
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
    }
}
