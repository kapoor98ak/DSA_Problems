import java.util.HashMap;
import java.util.Map;

public class ques560 {
    public static void main(String[] args) {
        int result = subarraySum(new int[]{3,1,2,1,4,2,2}, 4);
        System.out.println("Result: " + result);
    }
    public static int subarraySum(int[] nums, int k) {
        int tempSum = 0, result = 0;
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        // Create the sum array
        for(int i = 1 ; i < sum.length ; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }

        for(int start = 0 ; start < sum.length ; start++){
            int currSum=0;
            for(int end = start + 1 ; end < sum.length ; end++){
                currSum = sum[end] - sum[start];
                if(currSum == k) result++;
            }
        }

        return result;
    }
}