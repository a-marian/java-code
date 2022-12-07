package linkedlist;

/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Example 1
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * */
public class RemoveNnodeFromEndList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode slowPointer = start;
        ListNode fastPointer = start;

        for(int i = 1; i <= n; ++i)
            fastPointer = fastPointer.next;

        while(fastPointer.next != null ){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        slowPointer.next = slowPointer.next.next;

        return start.next;
    }
}
/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * */
