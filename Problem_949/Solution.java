package Problem_949;

public class Solution {
    public String largestTimeFromDigits(int[] A) {
        int maxTime = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 2) {
                continue;
            }
            for (int j = 0; j < A.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < A.length; k++) {
                    if (k == i || k == j || A[k] > 5) {
                        continue;
                    }
                    for (int l = 0; l < A.length; l++) {
                        if (l == i || l == j || l == k) {
                            continue;
                        }
                        // 時刻を数値にして大小比較。
                        int digit = A[i] * 1000 + A[j] * 100 + A[k] * 10 + A[l];
                        if (isValidTime(digit)) {
                            maxTime = Math.max(maxTime, digit);
                        }
                    }
                }
            }
        }
        if (maxTime == -1) {
            return "";
        }
        else {
            return String.format("%02d:%02d", maxTime / 100, maxTime % 100);
        }
    }

    boolean isValidTime(int digit) {
        int hour = digit / 100;
        int min = digit % 100;
        if (0 <= hour && hour <= 23) {
            if (0 <= min && min <= 59) {
                return true;
            }
        }
        return false;
    }
}
