class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> h = new HashMap<>();

       for(int i = 0; i < nums.length;i++){
        int check = target - nums[i];
        if(h.containsKey(check)){
            return new int[]{h.get(check) , i};
        }
        h.put(nums[i] , i);
       }
       return new int[]{};
    }
}
