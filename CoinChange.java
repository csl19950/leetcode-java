//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics广度优先搜索 | 数组 | 动态规划 
//
// 👍 2056, 👎 0 
//
//
//
//

import java.lang.reflect.Array;
import java.util.Arrays;

//Java：零钱兑换
public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        // TO TEST
        int[] coins = new int[]{1, 2, 3, 4, 5};
        int amount = 9;
        int result = solution.coinChange(coins,amount);
        System.out.println(result);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int coinChange(int[] coins, int amount) {
//        if(amount == 0) return 0;
//        if(amount < 0) return -1;
//
//        int result = Integer.MAX_VALUE;
//        for(int coin : coins) {
//            int subresult = coinChange(coins, amount - coin);
//            if(subresult == -1) continue;
//            result = Math.min(result, subresult + 1);
//        }
//        return result == Integer.MAX_VALUE ? -1 : result;
//    }

        int mem[];

        
//        public int coinChange(int[] coins, int amount) {
//            mem = new int[amount+1];
//            Arrays.fill(mem,-2);
//            return dp(coins, amount);
//        }


//        public int dp(int[] coins, int amount){
//            if (amount == 0) return 0;
//            if (amount < 0) return -1;
//
//            if(mem[amount] != -2) return mem[amount];
//
//            int result = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                int subresult = dp(coins, amount - coin);
//                if (subresult == -1) continue;
//                result = Math.min(result, subresult + 1);
//            }
//            mem[amount] = (result == Integer.MAX_VALUE ? -1 : result);
//            return mem[amount];
//        }

        public int coinChange(int[] coins, int amount) {
            int dp[] = new int[amount+1];
            Arrays.fill(dp, amount+2);

            dp[0] = 0;

            for(int i = 0; i < dp.length; i++){
                for(int coin : coins){
                    if(i - coin < 0) continue;
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }

            return (dp[amount] == amount+2) ? -1 : dp[amount];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}