import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mainMap = new HashSet<Integer>();
        boolean duplicate = false;
        
        for (int x : nums) {
            if (mainMap.contains(x)) {
                duplicate = true;
                break;
            }
            mainMap.add(x);
        }

        return duplicate;
    }
}