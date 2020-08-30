package PancakeSorting;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> flips = new ArrayList<>();
        int[] nums = A.clone();
        int curEnd = nums.length - 1;

        while (curEnd >= 1) {
            int flip = findIndexOfMax(nums, curEnd);
            if (flip == curEnd) {
                curEnd--;
                continue;
            }

            // max を先頭に持ってくる。
            if (flip != 0) {
                reverseSubArray(nums, flip);
                flips.add(flip + 1);
            }

            // max を 0～curEnd 内の最後に回す。
            reverseSubArray(nums, curEnd);
            flips.add(curEnd + 1);

            curEnd--;
        }
        return flips;
    }

    // array の 0～end の要素をひっくり返す。
    private void reverseSubArray(int[] array, int end) {
        int subArrayLen = end + 1;
        int count = subArrayLen / 2;
        for (int i = 0; i < count; i++) {
            int tmp = array[i];
            array[i] = array[end - i];
            array[end - i] = tmp;
        }
    }

    // array の 0～end の要素から max を探し、その インデックス を返す。
    private int findIndexOfMax(int[] array, int end) {
        int targetIndex = 0;
        int max = array[0];
        for (int i = 1; i <= end; i++) {
            if (array[i] > max) {
                max = array[i];
                targetIndex = i;
            }
        }
        return targetIndex;
    }
}
