pub struct Solution {}

use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        /*
            There are two ways to approach this, one wau uses O(n^2) time complexity

            ```
                for (index, value) in nums.iter().enumerate() {
                    for j in index..nums.len() {
                        if value + nums[j] == target {
                            return vec![*value as i32, nums[j] as i32];
                        }
                    }
                }
            ```

            This way was actually something I didnt think about earlier. When looking at more optimized code I found the rust version of the TwoSum problem.
            Source: https://github.com/aylei/leetcode-rust/blob/master/src/solution/s0001_two_sum.rs
            Since I don't really know how rust works that well, I'm just trying to learn the format and how stuff works around rust.
            Especially passing the addresses and pointers everywhere << this is something im not used to yet
        */
        
        // Create new hashmap
        let mut map = HashMap::new();
        

        // Iterate through passed vector
        for (index, value) in nums.iter().enumerate() {

            // See if target - value exists in the hashmap
            match map.get(&(target - value)) {
                None => {
                    // Target - current_value does not exist in hashmap
                    map.insert(value, index);
                }
                // Exists in hashmap
                Some(value_of_key) => return vec![*value_of_key as i32, index as i32],
            }
        }        
        vec![]
    }
}


fn main() {
    println!("{:?}", Solution::two_sum(vec![2,7,11,15], 9i32));
}
