package linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;

public class FindMergePointTwoList {


    // detect if there is a loop in the linked list
    boolean detectLoop(ListNode head)
    {
        ListNode slowPointer = head,
                fastPointer = head;

        while (slowPointer != null
                && fastPointer != null
                && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer)
                return true;
        }

        return false;
    }


    static class SinglyLinkedList {
        public ListNode head;
        public ListNode tail;
        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }
        public void insertNode(int nodeData) {
            ListNode node = new ListNode(nodeData);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }
            this.tail = node;
        }
    }


     public   static int findMergeNode(ListNode head1, ListNode head2) {

            while (head2 != null) {
                ListNode temp = head1;
                while (temp != null){
                    if (temp == head2){
                        return head2.val;
                    }
                    temp = temp.next;
                }
                head2 = head2.next;
            }
            return head1.val;
        }

    }
