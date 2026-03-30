class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j=i+1;
            int z=nums.length-1;
            while(z>j){
                int k = nums[i] + nums[j] + nums[z];
                if(k>0){
                    z--;
                } 
                else if(k<0){
                    j++;
                }
                else{
                    l.add(Arrays.asList(nums[i], nums[j], nums[z]));
                    j++;
                    z--;
                     while ( j < z && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return l;
    }
}
