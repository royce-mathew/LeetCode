"""

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
"""

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        rows : list[str] = [""] * numRows # Create a list of strings which is length numRows
        finalString : str = "" # Final String that will be returned

        while True: # Loop until the string is empty
            if len(s) == 0: # Check string length
                break

            # Not ZigZag - Normal row
            for _ in range(numRows):
                if len(s) >= 1:
                    rows[_] += s[0]
                    s = s[1:]

            # Zig Zag - Zig zag happens from index (numRows - 1) to index (1)
            for _ in range(numRows - 2, 0, -1):
                if len(s) >= 1:
                    rows[_] += s[0]
                    s = s[1:]

        return "".join(rows) # Concatenate the rows list

# Cases
# "PAYPALISHIRING"
# 3

# "PAYPALISHIRING"
# 4

# "A"
# # 1


# Test
# x = Solution()
# j = x.convert("PAYPALISHIRING", 4)
# print(j)