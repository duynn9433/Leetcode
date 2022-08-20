import java.util.Arrays;
import java.util.Scanner;

public class _704_BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[100];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(search(a,n));
    }

    public static int search(int[] nums, int target) {
        int i = Arrays.binarySearch(nums, target);
        if(i>=0) {
            return i;
        }else {
            return -1;
        }
    }
}
