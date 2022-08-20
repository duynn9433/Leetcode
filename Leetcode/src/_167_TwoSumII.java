import java.util.Arrays;

public class _167_TwoSumII {
    public static void main(String[] args) {
        int[] nums = {5,25,75};
        int target = 100;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        for(int i=0;i<numbers.length-1;i++){
            int findNum = target - numbers[i];
            int findIndex = Arrays.binarySearch(numbers, i + 1, numbers.length, findNum) ;
            if(findIndex >= 0) {
                res[0] = i+1;
                res[1] = findIndex+1;
                break;
            }
        }
        return res;
    }
}
