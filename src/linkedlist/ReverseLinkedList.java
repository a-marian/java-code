package linkedlist;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Example
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode current = head;
        while (current != null){
            ListNode tempNode = current.next;
            current.next = result;
            result = current;
            current = tempNode;
        }
        return result;
    }

}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * https://leetcode.com/problems/reverse-linked-list/
 * */
