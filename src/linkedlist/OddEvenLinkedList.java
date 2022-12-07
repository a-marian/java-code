package linkedlist;

/**
 * 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes.
 * Please note here we are talking about the node number and not the value in the nodes.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * */
public class OddEvenLinkedList {

    public  static ListNode oddEvenList(ListNode head) {
        // Corner case
        if (head == null || head.next == null)
            return head;

        // Initialize first nodes of even and odd lists
        ListNode evenFirst = head.next;
        ListNode odd = head;
        ListNode even = head.next;

        while (odd.next != null && even.next != null)
        {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = evenFirst;
        return head;
    }

}

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * https://leetcode.com/problems/odd-even-linked-list/
 * */
