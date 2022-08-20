
/**
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 * There are gas stations along the way. The gas stations are represented as an array stations where
 * stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting
 * position and has fueli liters of gas.
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
 * It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel,
 * transferring all the gas from the station into the car.
 * Return the minimum number of refueling stops the car must make in order to reach its destination.
 * If it cannot reach the destination, return -1.
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
 * If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 * */
public class _871_MinimumNumberofRefuelingStops {
//    public int minRefuelStops(int target, int startFuel, int[][] stations) {
//        int curFuel = startFuel;
//        int stop = 0;
//        int prev = 0;
//        int prevPrev = 0;
//        int prevPrevPrev = 0;
//        for (int i = 0; i < stations.length; i++) {
//            int station = stations[i][0];
//            int fuel = stations[i][1];
//            if (curFuel < station) {
//                return -1;
//            }
//            curFuel -= station;
//            if (curFuel < 0) {
//                stop++;
//                curFuel = prevPrevPrev + prevPrev + prev + fuel;
//                prevPrevPrev = prevPrev;
//                prevPrev = prev;
//                prev = fuel;
//            }
//        }
//        return stop;
//    }

    /**
     * Intuition
     * Let's determine dp[i], the farthest location we can get to using i refueling stops. This is motivated by the fact that we want the smallest i for which dp[i] >= target.
     * Algorithm
     * Let's update dp as we consider each station in order. With no stations, clearly we can get a maximum distance of startFuel with 0 refueling stops.
     * Now let's look at the update step. When adding a station station[i] = (location, capacity), any time we could reach this station with t refueling stops, we can now reach capacity further with t+1 refueling stops.
     * For example, if we could reach a distance of 15 with 1 refueling stop, and now we added a station at location 10 with 30 liters of fuel, then we could potentially reach a distance of 45 with 2 refueling stops.
     * */
    public int DP_minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        // dp[i] is the farthest location we can get to using i refueling stops.
        // <=> fuel from zero to des
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for (int i = 0; i < N; ++i){
            for (int t = i; t >= 0; --t){
                //have enough fuel to reach station[i]
                if (dp[t] >= stations[i][0])
                {
                    dp[t+1] = Math.max(dp[t+1], dp[t] + (long) stations[i][1]);
                }
            }
        }
        for (int i = 0; i <= N; ++i)
            if (dp[i] >= target) return i;
        return -1;
    }
}
