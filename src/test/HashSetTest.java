package src.test;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    void test(){
        Set<String> set = new HashSet<>();
        boolean res = set.add("1");
        boolean exist = set.contains("1");
        boolean rem = set.remove("1");


    }
}
