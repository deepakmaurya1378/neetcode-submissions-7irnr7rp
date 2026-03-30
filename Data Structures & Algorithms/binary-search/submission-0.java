class Solution {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length -1;

        while(j >= i){
            int mid = (i+j)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return -1;
    }
}
