public class _278_FirstBadVersion {

    public static void main(String[] args) {
       int a[] = {1,2,3,4,5};
         System.out.println(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        int res = -1;
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (!isBadVersion(mid))
                low = mid + 1;
            else if (isBadVersion(mid)){
                res = mid;
                high = mid - 1;
            }


        }
        return res;  // key not found.
    }

    private static boolean isBadVersion(int mid) {
        if(mid == 4 ) return true;
        return false;
    }

}
