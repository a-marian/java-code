package linkedlist;

/**
 * 83. Remove Duplicates from Sorted List
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 * Example:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * */
public class RemoveDuplicatesSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}
/**
 * Time complexity: O(n)
 * Space complexity: O(n) : maximum deep of recursion generated.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * */
