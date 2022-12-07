package linkedlist;

/**
 * 142. Linked List Cycle II
 * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
 * following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
 * is connected to (0-indexed). It is -1 if there is no cycle.
 * Note that pos is not passed as a parameter.
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * */
public class LinkedListCycleII {

    //Based on Floyd’s Cycle Finding Algorithm
    public static ListNode detectCycle(ListNode head) {
        ListNode slowPointer= head;
        ListNode fastPointer = head;

        while (slowPointer != null
                && fastPointer != null
                && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer){
                slowPointer = head;
                while (slowPointer != fastPointer){
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                return fastPointer;
            }
        }
        return null;
    }
}
