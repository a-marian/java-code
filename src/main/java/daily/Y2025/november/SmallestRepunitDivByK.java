package daily.Y2025.november;
/**
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/
 * 1015. Smallest integer divisible by k
 * */
public class SmallestRepunitDivByK {

    public int smallestRepunitDivByK(int k) {
        int res = 0;
        for(int i = 1; i <= k; i++){
            res = (res*10+1)%k;
            if(res == 0){
                return i;
            }
        }
        return -1;
    }
}
/**
 * Explanation
 * res -> traacks the remainder when the current repunt is divided by k
 *  loop to iterate from 1 to k, building repunits incremetally
 *   res = (res*10+1)%k:
 *      multiples previous remainder by 10 and adds 1 to simulate adding another digit '1'
 *      takes modulo k to keep only the remainder
 * if (r == 0): When remainder is 0, the repunit is divisible by k
 * Returns: The length of the smallest repunit, or -1 if none exists within k digits
 * */
