class Solution:
    def maxLength(self, arr: list[str]) -> int:
        len_arr = len(arr)
        currentMax = 0

        if len_arr <= 1:
            return len(arr[0])
        
        for i in range(len_arr):
            word = arr[i]
            found_dup = False
            
            for x in range(i+1, len_arr):
                temp_word = word + arr[x]
                
                for char in temp_word:
                    if temp_word.count(char) > 1:
                        found_dup = True
                        break
                        
                if not found_dup:
                    word += arr[x]   
                else:
                    word = ""

            print(found_dup)
            
            if currentMax < len(word) and not found_dup:
                currentMax = len(word)
        
        return currentMax

# How to make this work with input ["aa", "bb"] where return value is supposed to be 0

c = Solution()
print(c.maxLength(
    ["aa", "bb"]
))