struct Solution {}

impl Solution {
    /*
        @param x: 32 bit integer
        @return whether the passed integer is a palindrome
    */
    pub fn is_palindrome(x: i32) -> bool {
        /*
            Test Cases
            x: 121 -> True
            x: -121 -> False
            x: 10 -> False
        */
        let binding: String = x.to_string(); // Convert parameter to String
        let mut s: &[u8] = binding.as_bytes(); // Array of 8 bit integers
        let mut palindrome = true;

        while s.len() > 1 {
            if s[0] != s[s.len()-1] {
                palindrome = false;
                break;
            }

            s = &s[1..s.len()-1]; // Take the substring from 1 to the str[-1]
        }

        return palindrome;
    }
}

fn main() {
    print!("131 = {}\n", Solution::is_palindrome(131));
    print!("-132 = {}", Solution::is_palindrome(-132));
}
