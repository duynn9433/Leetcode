

public class _189_RotateArray {
    public void rotate(int[] nums, int k) {
        int[] temp = nums.clone();
        int n = nums.length;
        k = k % n;
        int start = n-k;
        int i =0;
        for(; i < n; i++) {
            int realIndex = (start+i)%n;
            nums[i] = temp[realIndex];
        }
    }

    public static void main(String[] args) {
        _189_RotateArray ra = new _189_RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        ra.rotate(nums, 3);
    }
}
