package src.structure;

import java.util.NoSuchElementException;

public class MyArrayStack<E> {
    private MyArrayList<E> arr = new MyArrayList<>();

    //栈顶增加元素
    public void push(E e){
        arr.addLast(e);
    }

    //栈顶弹出元素
    public E pop(){
       return arr.removeLast();
    }

    //查看栈顶元素
    public E peek(){
        if(arr.isEmpty()){
            throw new NoSuchElementException();
        }
        return arr.get(arr.size() - 1);
    }
}
