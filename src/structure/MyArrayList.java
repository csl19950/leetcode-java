package src.structure;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements Iterable<E> {
        //存储数据的底层数组
        private E[] data;

        //记录当前元素个数
        private int size;

        //默认初始容量
        private static final int INIT_CAP = 1;

        public MyArrayList(){
            this(INIT_CAP);
        }

        public MyArrayList(int initCapacity){
            data = (E[]) new Object[initCapacity];
            size = 0;
        }

        //增加元素
        public void addLast(E e){
            int cap = data.length;
            //数组容量不够，扩容
            if(size == cap){
                resize(2 * cap);
            }
            data[size] = e;
            size++;
        }

        //指定位置插入数据
        public void add(int index,E e){
            //检查索引是否越界
            checkPositionIndex(index);

            int cap = data.length;
            //数组容量不够，扩容
            if(size == cap){
                resize(2 * cap);
            }
            //移动数据
            System.arraycopy(data,index,data,index+1,size-index);
            data[index] = e;
            size++;
        }

        public void addFirst(E e){
            add(0,e);
        }

        //删除最后的元素
        public E removeLast(){
            if(size == 0){
                throw new NoSuchElementException();
            }
            int cap = data.length;
            //判断是否缩容，提高空间使用率
            if(size == cap/4) {
                resize(cap/2);
            }
            E deletedVal = data[size-1];
            data[size-1] = null;
            size--;
            return deletedVal;
        }

        //删除指定位置元素
        public E remove(int index){
            //检查索引越界
            checkElementIndex(index);
            int cap = data.length;
            //缩容，提高空间利用率
            if(size == cap/4){
                resize(cap/2);
            }
            E deletedVal = data[index];
            System.arraycopy(data,index+1,data,index,size-index-1);
            data[size-1] = null;
            size--;
            return deletedVal;
        }

        public E removeFirst(){
            return remove(0);
        }

        //获取
        public E get(int index){
            checkElementIndex(index);
            return data[index];
        }

        //修改
        public E set(int index,E element){
            checkElementIndex(index);
            E oldvalue = data[index];
            data[index] = element;
            return oldvalue;
        }

        //工具方法
        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size == 0;
        }


        //重新设置空间容量
        private void resize(int newCap){
            if(size > newCap){
                return;
            }
            E[] temp = (E[])new Object[newCap];
//            for(int i = 0; i < size; i++){
//                temp[i] = data[i];
//            }
            System.arraycopy(data,0,temp,0,size);
            data = temp;
        }

        private boolean isElementIndex(int index){
            return index >= 0 && index < size;
        }

        private boolean isPositionIndex(int index){
            return index >= 0 && index <= size;
        }

        //检查index索引位置是否可以存在元素
        private void checkElementIndex(int index){
            if(!isElementIndex(index)){
                throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
            }
        }

        //检查索引是否越界
        public void checkPositionIndex(int index) {
            if (!isPositionIndex(index)) {
                throw new IndexOutOfBoundsException("Index:" + index + ",Size:" + size);
            }
        }

        public Iterator<E> iterator(){
            return new Iterator<E>() {
                private int p = 0;
                public boolean hasNext(){
                    return p != size;
                }
                public E next(){
                    return data[p++];
                }
            };
        }

        private void display(){
            System.out.println("size="+size+" cap=" + data.length);
            System.out.println(Arrays.toString(data));
        }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>(3);
        //add 5 element
        for(int i = 0; i <= 5; i++){
            arr.addLast(i);
        }
        arr.remove(3);
        arr.add(1,9);
        arr.addFirst(100);
        int var = arr.removeLast();
        for(int j = 0; j < arr.size(); j++) {
            System.out.println(arr.get(j));
        }

    }

}
