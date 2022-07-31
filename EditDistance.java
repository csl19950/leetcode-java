//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
// Related Topics字符串 | 动态规划 
//
// 👍 2501, 👎 0 
//
//
//
//

//Java：编辑距离
public class EditDistance{
    public static void main(String[] args) {
        Solution solution = new EditDistance().new Solution();
        // TO TEST
        String word1 = "word";
        String word2 = "";
        int result = solution.minDistance(word1, word2);
        System.out.println(result);
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        byte[]s1 =  word1.getBytes();
        byte[]s2 =  word2.getBytes();

        return dp(s1,s2);
    }

    public int dp(byte[] s1, byte[] s2) {
        int i = s1[0];
        int j = s2[0];
        if(i == -1) return  j + 1;
        if(j == -1) return  i + 1;

        return 0;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}