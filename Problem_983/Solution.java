package Problem_983;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysToTravel = new HashSet<>();
        for (int day : days) {
            daysToTravel.add(day);
        }

        int feeFor1Day   = costs[0];
        int feeFor7Days  = costs[1];
        int feeFor30Days = costs[2];

        int ONE_YEAR_DAYS = 365;

        // 各 day における最小コスト。求めたいものは minCosts[365]。
        int[] minCosts = new int[ONE_YEAR_DAYS + 1];

        // DP で minCosts[365] を求める。
        for (int day = 1; day <= ONE_YEAR_DAYS; day++) {
            if (daysToTravel.contains(day)) {
                int bought1DayPass   = minCosts[Math.max(day - 1, 0)]  + feeFor1Day;
                int bought7DaysPass  = minCosts[Math.max(day - 7, 0)]  + feeFor7Days;
                int bought30DaysPass = minCosts[Math.max(day - 30, 0)] + feeFor30Days;
                minCosts[day] = Math.min(bought1DayPass, Math.min(bought7DaysPass, bought30DaysPass));
            }
            else {
                minCosts[day] = minCosts[day - 1];
            }
        }
        return minCosts[ONE_YEAR_DAYS];
    }
}