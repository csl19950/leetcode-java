package src.test;

import java.util.HashMap;

public class HashMapTest {
    void test(){
        HashMap<Integer,String> map = new HashMap<>();
        HashMap<String,int[]> maps = new HashMap<>();


        boolean exist = map.containsKey(1);
        String res = map.get(1);
        String res1 = map.put(1,"1");
        String res2 = map.remove(1);
    }
}
