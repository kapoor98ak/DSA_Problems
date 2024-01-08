import java.util.*;
class ques1498 {
    public static void main(String[] args) {
        System.out.println("Result" + numSubseq(new int[]{3,5,6,7}, 9));
    }
    public static int numSubseq(int[] nums, int target) {
        int result = numSubseq_helper(0, nums, new ArrayList<Integer>(), target, 0);
        return result;
    }
    private static int numSubseq_helper(int index, int[] nums, ArrayList<Integer> subset, int target, int result){
        if (index >= nums.length){
            int sum = 0;
            for(int i = 0 ; i < subset.size() && sum<=target; i++){
                sum+=subset.get(i);
            }
            if(sum == target){
                System.out.println(subset);
                result++;
            }
            return result;
        }

        subset.add(nums[index]);
        result = numSubseq_helper(index+1, nums, subset, target, result);

        subset.remove(subset.indexOf(nums[index]));
        result = numSubseq_helper(index+1, nums, subset, target, result);

        return result;
    }
}