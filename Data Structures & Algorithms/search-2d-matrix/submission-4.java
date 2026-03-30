class Solution {
    public static boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length -1;

        while(j >= i){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] < target){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length-1; 
        int i = 0;
        int j = r-1;
        int mid = 0;
        while(j >= i){
            mid = (j+i)/2;
            if (target >= matrix[mid][0] && target <= matrix[mid][c]) {
                return search(matrix[mid], target);
            }
            else if (matrix[mid][c] > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return false;  
    }
}
