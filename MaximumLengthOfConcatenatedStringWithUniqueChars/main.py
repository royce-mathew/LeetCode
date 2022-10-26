class Solution:
    def maxLength(self, arr: list[str]) -> int:
        len_arr = len(arr)
        currentMax = 0

        def find_duplicate(string: str):
            has_duplicate: bool = False

            for char in string:
                if string.count(char) > 1:
                    has_duplicate = True
                    print(f"BREAKING: {char}")
                    break
                    
    
            return has_duplicate

        if len_arr <= 1:
            return len(arr[0])
        
        for i in range(len_arr - 1):
            word = arr[i]

            print(word)
            
            for x in range(i+1, len_arr):
                # found_dup = False
                temp_word = word + arr[x]

                print(f"word: {word}; tword: {arr[x]}")
                        
                if not find_duplicate(temp_word):
                    word += arr[x]
                    print(f":):{word}")   

            print(f"\t\t{word}")
            if currentMax < len(word) and not find_duplicate(word):
                print(f"SETTING: {word}")
                currentMax = len(word)
        
        return currentMax

# How to make this work with input ["aa", "bb"] where return value is supposed to be 0
# ["ab","ba","cd","dc","ef","fe","gh","hg","ij","ji","kl","lk","mn","nm","op","po"]
c = Solution()
print(c.maxLength(
    # ["ab","ba","cd","dc","ef","fe","gh","hg","ij","ji","kl","lk","mn","nm","op","po"]
    # ["aa", "bb"]
    ["a", "abc", "d", "de", "def"]
))