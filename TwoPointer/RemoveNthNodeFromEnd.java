package TwoPointer;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        int[] arr={23,28,10,5,67,39,70,28};
        int n=2;
        LinkedList < Integer > inputLinkedList = new LinkedList < Integer > ();
        inputLinkedList.createLinkedList(arr);
        PrintList.printListWithForwardArrow(inputLinkedList.head);
        System.out.println();
        PrintList.printListWithForwardArrow(removeNthLastNode(inputLinkedList.head, n));
    }

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {

        // Replace this placeholder return statement with your code
        LinkedListNode left=head;
        LinkedListNode right=head;
        int i=0;
            while(right.next!=null && i<n ){
                right=right.next;
                i++;
            }

        while(right.next!=null){
            right=right.next;
            left=left.next;
        }

        left.next=left.next.next;

        return head;
    }
}
