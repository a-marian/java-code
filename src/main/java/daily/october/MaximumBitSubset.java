package daily.october;

public class MaximumBitSubset {
    int maxOr=0, count=0;
    public int countMaxOrSubsets(int[] nums){
        //find the maximum OR value that can be achieved
        for(int num: nums){
            maxOr |= num;
        }
        // Start backtracking to count the subsets with the maximum OR value
        backtrack(nums, 0,0);
        return count;
    }

    private void backtrack(int[] nums, int index, int currentOr){
        if(index == nums.length){
            // If the OR of this subset equals the maximum OR, increment the count
            if(currentOr == maxOr){
                count++;
            }
            return;
        }

        //Include the current number in the subset
        backtrack(nums, index+1, currentOr | nums[index]);
        //Exclude the current number in the subset
        backtrack(nums, index+1, currentOr);
    }


}
