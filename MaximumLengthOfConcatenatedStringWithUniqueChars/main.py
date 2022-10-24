class Solution:
    def maxLength(self, arr: list[str]) -> int:
        len_arr = len(arr)
        currentMax = 0

        if len_arr <= 1:
            return len(arr[0])
        
        for i in range(len_arr):
            word = arr[i]
            
            for x in range(i+1, len_arr):
                temp_word = word + arr[x]
                found_dup = False
                
                for char in temp_word:
                    if temp_word.count(char) > 1:
                        found_dup = True
                        break
                        
                if not found_dup:
                    word += arr[x]   
                else:
                    break
            
            if currentMax < len(word):
                currentMax = len(word)

        print(word)
        
        return currentMax



c = Solution()
print(c.maxLength(
    ["aa", "bb"]
))