package linkedlist;

/**
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * Example 1
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.val <= list2.val){
            merged = list1;
            merged.next = mergeTwoLists(list1.next, list2);
        } else {
            merged = list2;
            merged.next = mergeTwoLists(list1, list2.next);
        }
        return merged;
    }
}
/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 * */
