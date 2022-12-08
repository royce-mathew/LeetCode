class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        main_dict = {}
        # Since dictionaries can't contain duplicate values, we use that to our advantage to 
        #       set the sorted string as a key and all the possible iterations as values inside the key

        for x in strs: # Loop through the array
            sorted_val = "".join(sorted(x))
            
            if sorted_val in main_dict: # if the sorted value is already inside the dictionary
                main_dict[sorted_val].append(x)

            else: # Create a new table for the sorted value inside the dictionary 
                main_dict[sorted_val] = [x] 

        return list(main_dict.values()) # Return a list of the dictionary's values as a list

j = Solution()
print(j.groupAnagrams(
    ["eat","tea","tan","ate","nat","bat"]
    # [""]
))