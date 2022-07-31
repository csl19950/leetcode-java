package src.structure;

import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E> {
    //存储数据的数组
    private E[] data;
    //当前元素个数
    private int size;
    //默认初始容量
    private static final int CAP_INIT = 1;

    public MyArrayList(){
        this(CAP_INIT);
    }

    public MyArrayList(int initCapacity){
        data = (E[]) new Object[initCapacity];
        size = 0;
    }



    public Iterator<E> iterator(){
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        }
    }

}
