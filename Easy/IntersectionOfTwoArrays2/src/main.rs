struct Solution;

impl Solution {
    pub fn intersect(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
        /*
            Stretegy: Loop through every value in the first array
            Check if it is in second array -> Yes? Pop value from second array and add to return vec
        */
        let mut final_vec: Vec<i32> = vec![];
        let mut copy_vec = nums2.to_owned();


        for i in 0..nums1.len() {
            match copy_vec.iter().position(|&r| r == nums1[i]) {
                Some(index) => {
                    final_vec.push(copy_vec.remove(index));
                },
                None => {}
            }
            
        }


        final_vec
    }
}


fn main() {
    // [1,2,2,1] , [2,2]
    let j = Solution::intersect(vec![1,2,2,1], vec![2,2]);
    println!("{:?}", j);
}
