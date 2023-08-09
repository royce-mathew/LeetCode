/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */
var ListNode = /** @class */ (function () {
    function ListNode(val, next) {
        this.val = (val === undefined ? 0 : val);
        this.next = (next === undefined ? null : next);
    }
    return ListNode;
}());
// Iterate through list1 and prepend it before the finalNode linked list
function setCarrySingle(list1, finalNode, carry) {
    while (list1 !== null) {
        var sum = list1.val + carry;
        if (sum > 9) {
            carry = 1;
            sum -= 10;
        }
        else {
            carry = 0;
        }
        var tempNode = new ListNode(sum);
        tempNode.next = finalNode;
        finalNode = tempNode;
        list1 = list1.next;
    }
    return finalNode;
}
function addTwoNumbers(l1, l2) {
    var finalNode = null; // The node that will be returned
    var carry = 0; // The carry value
    // Iterate through both linked lists
    while (l1 !== null && l2 !== null) {
        var sum = l1.val + l2.val + carry; // Add the values of the nodes
        if (sum > 9) { // Check if we should carry
            carry = 1;
            sum -= 10;
        }
        else { // Reset carry
            carry = 0;
        }
        // Create the next node for the final linked list
        var tempNode = new ListNode(sum);
        tempNode.next = finalNode;
        finalNode = tempNode;
        // Move to the next node
        l1 = l1.next;
        l2 = l2.next;
    }
    // Check if we have any remaining nodes
    if (l1 !== null) {
        finalNode = setCarrySingle(l1, finalNode, carry);
    }
    else if (l2 !== null) {
        finalNode = setCarrySingle(l2, finalNode, carry);
    }
    // Check if we should still carry
    if (carry === 1) {
        var tempNode = new ListNode(1);
        tempNode.next = finalNode;
        finalNode = tempNode;
    }
    // Reverse the linked list
    var prevNode = null;
    var currNode = finalNode;
    var nextNode = null;
    while (currNode !== null) {
        nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    finalNode = prevNode;
    return finalNode;
}
;
// let l1 = new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(3))));
// let l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
var l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
var l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
var finalList = addTwoNumbers(l1, l2);
while (finalList !== undefined && finalList !== null) {
    console.log(finalList.val);
    finalList = finalList.next;
}
