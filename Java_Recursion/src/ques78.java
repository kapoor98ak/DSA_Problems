import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{5,2,4});
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets_helper(0, nums, new ArrayList<Integer>(), result);
        return result;
    }
    private static void subsets_helper(int index, int[] nums, List<Integer> subset, List<List<Integer>> result){
        if(index >= nums.length){
            System.out.println("Base case reached!" + subset);
            result.add(new ArrayList<>(subset));
            System.out.println("Result: " + result + "\n");
            return;
        }
        // Include the element at the index.
        subset.add(nums[index]);
        // Call the recursion.
        subsets_helper(index+1, nums, subset, result);
        // Exclude the element that we appended.
        subset.remove(subset.indexOf(nums[index]));
        // Call the recursion again.
        subsets_helper(index+1, nums, subset, result);
    }
}