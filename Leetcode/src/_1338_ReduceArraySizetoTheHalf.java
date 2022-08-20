import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1338_ReduceArraySizetoTheHalf {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,2,2,3};
        System.out.println(minSetSize(nums) + "");
    }

    public static int minSetSize(int[] arr) {
        int n = arr.length;
        int target = (n + 1) / 2;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int x : arr) {
            if (freqMap.get(x) == null) {
                freqMap.put(x, 1);
            } else {
                freqMap.put(x, freqMap.get(x) + 1);
            }
//            freqMap[x]++;
        }
        List<Integer> freaks = new ArrayList<>(freqMap.values());
        freaks.sort((a, b) -> b - a);
        System.out.println(freaks);

        for (int i = 0; i < n; i++) {
            target -= freaks.get(i);
            if (target <= 0) return i + 1;
        }
        return 0;
    }
}

