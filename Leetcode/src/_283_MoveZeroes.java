import java.util.Arrays;

public class _283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int temp[] = nums.clone();

        int j = 0;
        for(int i = 0;i<nums.length;i++) {
            if(temp[i] != 0) {
                nums[j++] = temp[i];
            }
        }
        for(;j<nums.length;j++) {
            nums[j] = 0;
        }
    }
}
