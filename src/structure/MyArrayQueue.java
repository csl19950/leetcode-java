package src.structure;

import java.util.NoSuchElementException;

public class MyArrayQueue<E> {

    private int size;
    private E[] data;
    private final static int CAP_INIT = 1;

    private int first,last;

    public MyArrayQueue(int initCap){
        size = 0;
        data = (E[]) new Object[initCap];
        // last 是下一次应该添加元素的索引
        // first----last, [first, last)
        // 比如 first = 1，last = 3，size = 2
        first = last = 0;
    }

    public MyArrayQueue(){
        this(CAP_INIT);
    }

    //从队尾添加元素
    public void offer(E e){
        if(size == data.length){
            resize(size * 2);
        }
        data[last] = e;
        last++;
        if(last == data.length){
            last = 0;
        }
        size++;
    }

    //从队头弹出元素
    public E poll() {
         if(isEmpty()){
             throw new NoSuchElementException();
         }
         if(size == data.length / 4){
             resize(data.length/2);
         }
         E deletedVal = data[first];
         data[first] = null;
         first++;
         return deletedVal;
    }

    //查看队头元素
    public E peekFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return data[first];
    }

    //查看队尾元素
    public E peekLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(last == 0) return data[data.length-1];
        return data[last-1];
    }


    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int newCap){
        E[] temp = (E[])new Object[newCap];
        for(int i = 0; i < size; i++){
            temp[i] = data[(first+i) % data.length];
        }
        first = 0;
        last = size;
        data = temp;
    }
}
