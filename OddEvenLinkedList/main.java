/*
    Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

    The first node is considered odd, and the second node is even, and so on.

    Note that the relative order inside both the even and odd groups should remain as it was in the input.

    You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val; }
    ListNode(int val, ListNode next) {this.val = val; this.next = next; }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode iterNode = head;

        ListNode newList = new ListNode();
        ListNode newIter = newList;
        int val = 1;


        while (iterNode != null) {
            if (val % 2 == 1) {
                newIter.next = new ListNode(iterNode.val);
                newIter = newIter.next;
            }
            iterNode = iterNode.next;
            val += 1;
        }

        iterNode = head;
        val = 1;

        while (iterNode != null) {
            if (val % 2 == 0) {
                newIter.next = new ListNode(iterNode.val);
                newIter = newIter.next;
            }
            iterNode = iterNode.next;
            val += 1;
        }
        

        return newList.next;
    }
}