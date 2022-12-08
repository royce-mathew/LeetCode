# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Optional():
    pass

class Solution(object):
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """

        # Initialize Variables
        list_len: int = 0
        index: int = 0
        temp_node: ListNode = head
        
        # Calculate List Len
        while temp_node is not None:
            list_len += 1
            temp_node = temp_node.next
            
        temp_node = head
        break_index: int = (list_len - n - 1)  # Set the break index based on the length of list


        # TEST CASES
        if list_len == 1: # If the list only consists of one element return empty
            return None
        
        if break_index < 0: # If the break_index is lesser than 0 (happens when you wanna remove the first value from the linked list)
            head = head.next # Change the head of the linked list, this automatically applies to the temp_node
        

        # Loop through linked list
        while temp_node is not None and temp_node.next is not None:
            if index == break_index: # If we are currently at the index we wanna break at
                temp_node.next = temp_node.next.next
            else:
                temp_node = temp_node.next # Iterate through the linkedlist normally
            index += 1 # Update index
                

        
        return head # Return head of linked list