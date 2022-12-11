import java.util.HashMap;

/*
    Given a string s, return true if s is a good string, or false otherwise.

    A string s is good if all the characters that appear in s have the same number of occurrences 
        (i.e., the same frequency).
*/


class Solution {

    public static boolean areOccurencesEqual(String s) {
        boolean equalOcc = true;
        HashMap <Character, Integer> mainMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            mainMap.put(c, mainMap.getOrDefault(c, 0) + 1);
        }

        int occurenceOfFirst = mainMap.get(s.charAt(0));

        for (char c : mainMap.keySet()) {
            if (mainMap.get(c) != occurenceOfFirst) {
                equalOcc = false;
                break;
            }
        }

        return equalOcc;

    }  
}