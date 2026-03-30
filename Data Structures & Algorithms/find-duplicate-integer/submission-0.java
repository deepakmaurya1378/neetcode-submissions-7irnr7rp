class Solution {
    public int findDuplicate(int[] nums) {
       int n  = nums.length;
       int i = 0;
       while(true){
        System.out.println(nums[i] + " nums[i] " + i + " i");
        if(nums[i] == 0){
            return i;
        }
        int j = nums[i];
        nums[i] = 0;
        i = j;
       }

    }
}
