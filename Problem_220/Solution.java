package Problem_220;

import java.util.TreeSet;

// Sliding Window で解いた実装例
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            // nums[i] 以下で最大のものを探す。
            final Integer lowerMax = window.floor(nums[i]);

            // nums[i] 以上で最小のものを探す。
            final Integer higherMin = window.ceiling(nums[i]);

            // lowerMax ～ nums[i] ～ higherMin
            if ((higherMin != null && (long)higherMin - nums[i] <= t)
                    || (lowerMax != null && (long)nums[i] - lowerMax <= t)) {
                return true;
            }

            // window を右に一つスライドさせる。
            window.add(nums[i]);
            if (i >= k) {
                // 左端を削る。
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}