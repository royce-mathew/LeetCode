/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode tempNode = node;
        while (tempNode.next != null) {
            tempNode.val = tempNode.next.val;
            
            if (tempNode.next.next == null) {
                tempNode.next = null;
            } else {
                tempNode = tempNode.next;

            }
        }
    }
}