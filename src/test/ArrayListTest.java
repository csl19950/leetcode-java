package src.test;

import java.util.ArrayList;

public class ArrayListTest {

    void test(){
        //底层是数组
        ArrayList<String> nums = new ArrayList<>();
        ArrayList<Integer> ints = new ArrayList<>();

        boolean flag = nums.isEmpty();
        int size = nums.size();
        String s1 = nums.get(1);
        boolean result = nums.add("123");
    }


}
