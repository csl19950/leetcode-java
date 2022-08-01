package src.test;

public class StringTest {

    void test(){
        String s1 = "test";

        char c = s1.charAt(2);
        char[] chars = s1.toCharArray();
        chars[1] = 'a';

        String s2 = new String(chars);

        boolean flag = s1.equals(s2);

        String s3 = s1 + "123";

        //Java 的字符串不能直接修改，要用 toCharArray 转化成 char[] 的数组进行修改，然后再转换回 String 类型
        //字符串支持用 + 进行拼接，但是效率并不高，并不建议在 for 循环中使用。如果需要进行频繁的字符串拼接，推荐使用 StringBuilder
        StringBuilder sb = new StringBuilder();
        for(char d = 'a'; c < 'f'; d++){
            sb.append(d);
        }
        sb.append('g').append("hjc").append(123);
        String res = sb.toString();
    }





}
