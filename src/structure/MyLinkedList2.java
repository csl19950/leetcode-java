package src.structure;


import javax.print.DocFlavor;
import java.util.NoSuchElementException;

//单链表实现linkedlist
public class MyLinkedList2<E>{

    private static class Node<E>{
        E val;
        Node<E> next;
        Node(E val){
            this.val = val;
        }
    }

    private final Node<E> head,tail;

    private int size;

    public MyLinkedList2(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        this.size = 0;
    }

    //增
    public void addFirst(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        //head->temp
        x = head.next;
        x.next = temp;

        //head->x->temp
        size++;
    }

    public void addLast(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp;
        if(size-1 >= 0){
            temp = getNode(size-1);
        }else {
            temp = head.next;
        }
        //temp->tail
        x.next = tail;
        temp.next = x;
        //temp->x->tail
        size++;
    }

    public void add(int index,E element){
        checkPositionIndex(index);
        if(index == size){
            addLast(element);
            return;
        }
        Node<E> x = new Node<>(element);
        Node<E> p = getNode(index);
        Node<E> temp;
        if(index - 1 >= 0){
            temp = p;
        }else {
            temp = head;
        }
        x.next = p;
        temp.next = x;
        size++;
    }

    //删除
    public E removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<E> x= head.next;
        head.next = head.next.next;
        x.next = null;
        size--;
        return x.val;
    }

    public E removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<E> x = getNode(size-1);
        Node<E> temp;
        if(size - 2 >= 0){
            temp = getNode(size-2);
        }else {
            temp = head;
        }
        temp.next = tail;
        x.next = null;
        size--;
        return x.val;
    }

    public E remove(int index){
        checkElementIndex(index);
        Node<E> p = getNode(index);
        Node<E> prev;
        if(index - 1 >= 0){
            prev = getNode(index-1);
        }else {
            prev = head;
        }
        Node<E> next = p.next;
        prev.next = next;
        p.next = null;
        size--;
        return p.val;
    }

    //查
    public E getFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return getNode(size-1).val;
    }

    public E get(int index){
        checkElementIndex(index);
        return getNode(index).val;
    }

    //改
    public E set(int index, E element){
        checkElementIndex(index);
        Node<E> p = getNode(index);
        E oldVal = p.val;
        p.val = element;
        return oldVal;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isElementIndex(int index){
        return index > 0 && index < size;
    }

    public boolean isPositionIndex(int index){
        return index > 0 && index <= size;
    }

    public void checkElementIndex(int index){
        if(!isElementIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public void checkPositionIndex(int index){
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node<E> getNode(int index){
        Node<E> p = head.next;
        for (int i = 0; i < size; i++)
        {
            p = p.next;
        }
        return p;
    }

}
