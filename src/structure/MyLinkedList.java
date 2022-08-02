package src.structure;

import java.util.Iterator;
import java.util.NoSuchElementException;

//双链表实现linkedlist
public class MyLinkedList<E> implements Iterable<E> {

    final private Node<E> head,tail;
    private int size;

    public  MyLinkedList(){
        this.head = new Node<>(null);
        this.tail = new Node<>(null);

        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }


    public void addLast(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = tail.prev;
        //temp <-> tail
        temp.next = x;
        x.prev = temp;

        x.next = tail;
        tail.prev = x;
        //temp <-> x <-> tail
        size++;
    }

    public void addFirst(E e){
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        //temp<->temp
        temp.prev = x;
        x.next = temp;

        head.next = x;
        x.prev = head;
        //head<->x<->temp
        size++;
    }


    public void add(int index, E element){
        checkPostionIndex(index);
        if(index == size){
            addLast(element);
            return;
        }
        //寻找index对应的Node
        Node<E> p = getNode(index);
        Node<E> temp = p.prev;
        //temp<->p
        //要插入的Node
        Node<E> x = new Node<>(element);

        p.prev = x;
        temp.next = x;

        x.prev = temp;
        x.next = p;
        //temp<->x<->p
        size++;
    }

    public E removeLast(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        Node<E> x = tail.prev;
        Node<E> temp = tail.prev.prev;
        //temp<->x<->tail
        tail.prev = temp;
        temp.next = tail;

        x.prev = null;
        x.next = null;
        //temp<->tail
        size--;
        return x.val;
    }


    public E removeFirst(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        //无需考虑空指针(虚拟头尾节点)
        Node<E> x = head.next;
        Node<E> temp = head.next.next;
        //head<->x<->temp
        head.next = temp;
        temp.prev = head;

        x.prev = null;
        x.next = null;
        //head<->temp

        size--;
        return x.val;
    }

    public E remove(int index){
        checkElementIndex(index);
        //找到对应的Node
        Node<E> x = getNode(index);
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        //prev<->x<->next
        prev.next = next;
        next.prev = prev;
        x.prev = null;
        x.next = null;
        //prev<->next
        size--;
        return x.val;
    }

    //查
    public E get(int index){
        checkElementIndex(index);
        Node<E> p = getNode(index);
        return p.val;
    }

    public E getFirst(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast(){
        if(size < 1){
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }


    //改
    public E set(int index, E val){
        checkElementIndex(index);
        Node<E> p = getNode(index);
        E oldVal = p.val;
        p.val = val;
        return oldVal;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private Node<E> getNode(int index){
        checkElementIndex(index);
        Node<E> p = head.next;
        //可以优化，通过index判断是从head还是tail进行遍历
        for(int i = 0; i < index; i++){
            p = p.next;
        }
        return p;
    }

    private boolean isElementIndex(int index){
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index){
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index){
        if(!isElementIndex(index)){
            throw new IndexOutOfBoundsException("Index:" + index + "size: " + size);
        }
    }

    private void checkPostionIndex(int index){
        if(!isPositionIndex(index)){
            throw new IndexOutOfBoundsException("Index:" + index + "size: " + size);
        }
    }

    private void display(){
        System.out.println("size= " + size);
        for(Node<E> p = head.next; p != tail; p = p.next){
            System.out.println(p.val + "->");
        }
        System.out.println("null");
        System.out.println();
    }


    private static class Node<E>{
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val){
            this.val = val;
        }
    }





    public Iterator<E> iterator(){
        return new Iterator<>(){
            Node<E> p = head.next;

            public boolean hasNext(){
                return p != tail;
            }

            public E next(){
                E val = p.val;
                p = p.next;
                return val;
            }
        };
    }
}
