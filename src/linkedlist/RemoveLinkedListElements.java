package linkedlist;

/**
 * 203. Remove Linked List Elements
 * Given the head of a linked list and an integer val, remove all the nodes
 * of the linked list that has Node.val == val, and return the new head.
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 */
public class RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        while(head != null){
            head.next= removeElements(head.next, val);
            return (head.val == val) ? head.next : head;
        }
        return head;
    }
}
/**
 * Time complexity: O(n)
 * Space complexity: O(n)
 * https://leetcode.com/problems/remove-linked-list-elements/
 * */
