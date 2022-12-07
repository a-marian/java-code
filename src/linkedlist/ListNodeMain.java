package linkedlist;

import java.util.List;

import static linkedlist.LinkedListCycleII.detectCycle;
import static linkedlist.OddEvenLinkedList.oddEvenList;
import static linkedlist.RemoveDuplicatesSortedList.deleteDuplicates;
import static linkedlist.RemoveLinkedListElements.removeElements;
import static linkedlist.RemoveNnodeFromEndList.removeNthFromEnd;
import static linkedlist.ReverseLinkedList.reverseList;

/**
 * This class was created with the purpose to test callled methods in.
 * It will create a list node sigle linked.
 * */
public class ListNodeMain {

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 9, 2, 2, 3, 4, 9, 4, 5, 5, 6, 9 };

        ListNode head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new ListNode(keys[i], head);
        }
        printLinkedList(head);
        System.out.println();

        //remove Nth node from end of list
        int value = 9;
        System.out.println("Remove given value "+value+" from linked list ");
        head = removeElements(head, 9);
        printLinkedList(head);
        System.out.println();

        //remove Nth node from end of list
        System.out.println("Remove Nth node from end of list");
        head = removeNthFromEnd(head, 2);
        printLinkedList(head);
        System.out.println();

        // remove duplicate elements in linkedList
        System.out.println("Deleting duplicates");
        head = deleteDuplicates(head);
        printLinkedList(head);
        System.out.println();

        // make aa list odd even
        System.out.println("Odd Even Linked List");
        head = oddEvenList(head);
        printLinkedList(head);
        System.out.println();

        // reverse linked list
        System.out.println("Reverse  linked list");
        head = reverseList(head);
        printLinkedList(head);
        System.out.println();

        // insert cycle
        head.next.next.next.next.next = head.next.next;

        if (detectCycle(head)  != null) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle Found");
        }
    }

    public static void printLinkedList(ListNode listNode){
        while(listNode != null){
            System.out.print(" "+listNode.val);
            listNode = listNode.next;
        }
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

