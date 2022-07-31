//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics递归 | 记忆化搜索 | 数学 | 动态规划 
//
// 👍 503, 👎 0 
//
//
//
//

//Java：斐波那契数
public class FibonacciNumber{
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        // TO TEST
        int x = solution.fib(4);
        System.out.println(x);

    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int fib(int n) {
//        if(n == 0 || n == 1){
//            return n;
//        }else{
//            return fib(n-1) + fib(n-2);
//        }
//    }

/*        public int fib(int n) {
            //recode remaining elements
            int[] mem = new int[n+1];
            return memory(mem,n);

        }
        private int memory(int[]mem, int n){
            if(n == 0 || n == 1){
                return n;
            }
            if(mem[n] != 0){
                return mem[n];
            }
            mem[n] = memory(mem,n-1) + memory(mem,n-2);
            return mem[n];
        }*/

//    public int fib(int n) {
//        if(n == 0 ){
//            return n;
//        }
//        int dp[] = new int[n+1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i = 2; i <= n; i++){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }

        public int fib(int n) {
            if(n == 0 || n == 1){
                return n;
            }
            int pre = 0, curr = 1;
            for(int i = 2;i <= n;i++){
                int sum = pre + curr;
                pre = curr;
                curr = sum;
            }
            return curr;

        }


}
//leetcode submit region end(Prohibit modification and deletion)

}