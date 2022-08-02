package src.structure;

public class MyLinkedStack<E>{
    private MyLinkedList<E> list = new MyLinkedList<>();

    //栈顶增加元素
    public void push(E e){
        list.addLast(e);
    }

    //栈顶弹出元素
    public E pop(){
        return list.removeLast();
    }

    //查看栈顶元素
    public E peek(){
        return list.getLast();
    }

}
