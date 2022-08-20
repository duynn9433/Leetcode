import java.util.Arrays;

public class _35_Search_Insert_Position {

    public static void main(String[] args) {

    }

    public static int searchInsert(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if(i>=0) {
            return i;
        }else {
            return -(i+1);
        }
    }
}
