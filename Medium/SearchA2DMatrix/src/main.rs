struct Solution;

impl Solution {
    pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {

        let mut found: bool = false;
        let column_len: usize = matrix.len();
        
        for i in 0..column_len {
            let row_len: usize = matrix[i].len();

            if target <= matrix[i][row_len-1] && target >= matrix[i][0] {
                for x in 0..row_len {
                    if matrix[i][x] == target {
                        found = true;
                        break;
                    }
                }
                break;
            }
        }


        found
    }
}

fn main() {
    let j = Solution::search_matrix(vec![vec![1,3,5,7],vec![10,11,16,20],vec![23,30,34,60]], 3);
    println!("{}", j);
}
