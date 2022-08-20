import java.util.LinkedHashMap;
import java.util.Map;

public class _659_SplitArrayintoConsecutiveSubsequences {

    public static void main(String[] args) {
        int nums[] = {1,2,3,3,4,4,5};
        System.out.println(isPossible(nums));
    }

    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> freqMap = new LinkedHashMap<>();
        for(int i : nums){
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }
        //đánh dấu <vị trí, có bn chuỗi thoả mãn>
        Map<Integer, Integer> subCountMap = new LinkedHashMap<>();
        for(int i :nums){
            if(freqMap.get(i) == 0){
                continue;
            }
            freqMap.put(i, freqMap.get(i) - 1);
            //add to existing subsequence
            if(subCountMap.getOrDefault(i-1, 0) > 0){
                subCountMap.put(i-1, subCountMap.get(i-1) - 1);
                subCountMap.put(i, subCountMap.getOrDefault(i, 0) + 1);
            }
            //new sub
            else if(freqMap.getOrDefault(i + 1, 0) > 0
                    && freqMap.getOrDefault(i + 2, 0) > 0){
                freqMap.put(i + 1, freqMap.get(i + 1) - 1);
                freqMap.put(i + 2, freqMap.get(i + 2) - 1);
                subCountMap.put(i+2, subCountMap.getOrDefault(i+2, 0) + 1);
            }else{
                return false;
            }
        }
        return true;
    }
}
