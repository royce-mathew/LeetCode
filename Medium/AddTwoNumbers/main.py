# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

"""
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers 
    and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
"""

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        current_node = ListNode();
        node_head = current_node
        carry = 0
        l1_val, l2_val = l1.val, l2.val

        while True:
            try: # Need to use try and except because it keeps throwing stupid exceptions while looping through the linkedlist
                added_vals = l1_val + l2_val # Add both values
                mod = added_vals % 10 # Get the last integer
                carry =  (added_vals + current_node.val) // 10 # Carry to add to next node
                
                current_node.val = (mod + current_node.val) % 10
                
                print(f"ADDED: {added_vals}, MOD: {mod}, CARRY: {carry}")

                if l1.next is None and l2.next is None and carry == 0:
                    current_node.next = None
                    break
                else:
                    current_node.next = ListNode()
                    current_node.next.val = carry

                current_node = current_node.next

                if l1.next is None:
                    l1_val = 0
                else:
                    l1 = l1.next
                    l1_val = l1.val
                    
                if l2.next is None:
                    l2_val = 0
                else:
                    l2 = l2.next
                    l2_val = l2.val
                    
                
            except AttributeError:
                break;


        return node_head