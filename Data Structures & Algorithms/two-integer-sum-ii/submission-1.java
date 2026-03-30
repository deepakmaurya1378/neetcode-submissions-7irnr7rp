class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(j>i){
            int x = numbers[i] + numbers[j];
            if( x == target){
                break;
            }
            if(x > target){
                j--;
            }
            else if(x < target){
                i++;
            }
        }
        int[] a = {i+1,j+1};
        return a;
    }
}
