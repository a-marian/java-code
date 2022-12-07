package linkedlist;

/**
 * 876. Middle of the Linked List
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * */
public class MiddleLinkedList {

    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode mid = head;
        while(head != null){
            if((count % 2) == 1)
                mid = mid.next;
            ++count;
            head= head.next;
        }
        return mid;
    }
}
/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * */
