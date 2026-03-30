class Solution {
    private int index(int[] a){
        int left = 0;
        int right = a.length-1;

        while(right > left){
            int m = (right + left)/2;
            if(a[m] <= a[right]){
                right = m;

            }
            else{
                left = m+1;
            }
        }
        return left;
    } 

    private int search1(int[] a,int i ,int j ,int target){
        System.out.println(i + " = " + j);
        while(j >= i){
            int m = (i+j)/2;
            if(a[m] == target){
                return m;
            }
            else if(a[m] < target){
                i= m+1;
            }
            else{
              j =  m-1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int a = index(nums);
        if(nums[a] <= target && target <= nums[nums.length-1] ){
            return search1(nums , a , nums.length-1 , target);
        }
        else{
            return search1(nums, 0 , a-1, target);
        }
    }
}
