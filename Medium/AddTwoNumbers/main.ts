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

class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val===undefined ? 0 : val)
        this.next = (next===undefined ? null : next)
    }
}

// Iterate through list1 and prepend it before the finalNode linked list
function setCarrySingle(list1: ListNode | null, finalNode: ListNode | null, carry: number) {
    while (list1 !== null) {
        let sum = list1.val + carry;

        if (sum > 9) {
            carry = 1;
            sum -= 10;
        } else {
            carry = 0;
        }

        let tempNode = new ListNode(sum);
        tempNode.next = finalNode;
        
        finalNode = tempNode;
        
        list1 = list1.next;
    }

    return finalNode;
}

/*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    let finalNode: ListNode | null = null; // The node that will be returned
    let carry = 0; // The carry value

    // Iterate through both linked lists
    while (l1 !== null && l2 !== null) {
        let sum = l1.val + l2.val + carry; // Add the values of the nodes
        if (sum > 9) { // Check if we should carry
            carry = 1;
            sum -= 10;
        } else { // Reset carry
            carry = 0;
        }

        // Create the next node for the final linked list
        let tempNode = new ListNode(sum);
        tempNode.next = finalNode;
        finalNode = tempNode;
        
        // Move to the next node
        l1 = l1.next;
        l2 = l2.next;
    }

    // Check if we have any remaining nodes
    if (l1 !== null) {
        finalNode = setCarrySingle(l1, finalNode, carry);
    } else if (l2 !== null) {
        finalNode = setCarrySingle(l2, finalNode, carry);
    }

    // Check if we should still carry
    if (carry === 1) {
        let tempNode = new ListNode(1);
        tempNode.next = finalNode;
        finalNode = tempNode;
    }


    // Reverse the linked list
    let prevNode: ListNode | null = null;
    let currNode: ListNode | null = finalNode;
    let nextNode: ListNode | null = null;
    while (currNode !== null) {
        nextNode = currNode.next;
        currNode.next = prevNode;
        prevNode = currNode;
        currNode = nextNode;
    }
    finalNode = prevNode;  

    return finalNode;
};


// TESTS
// let l1 = new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(3))));
// let l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
// let l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
// let l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
// let finalList = addTwoNumbers(l1, l2);

// while (finalList !== undefined && finalList !== null) {
//     console.log(finalList.val);
//     finalList = finalList.next;
// }