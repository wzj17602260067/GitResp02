package com.yidong.yun.util;


import java.io.Serializable;
import java.util.*;

public class MyLinklist<E> extends AbstractSequentialList<E> implements List<E>,Serializable {

    private int size;

    private Node<E> first;

    private Node<E> last;

    public MyLinklist(){}


    void linkLast(E e){


//        final LinkedList.Node<E> l = last;
//        final LinkedList.Node<E> newNode = new LinkedList.Node<>(l, e, null);
//        last = newNode;
//        if (l == null)
//            first = newNode;
//        else
//            l.next = newNode;
//        size++;
//        modCount++;

        MyLinklist.Node<E> l  =  last;
        MyLinklist.Node<E> newNode = new Node<>(l, e, null);

        last = newNode;

        if (l==null){
            first = newNode;
        }else {
            l.next = newNode;
        }
        size++;
    }


    public boolean add(E e){
        linkLast(e);
        return true;
    }







    public static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev,E element,Node<E> next){
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }




    @Override
    public ListIterator<E> listIterator(int index) {
        return new ListLtr(0);
    }

    @Override
    public int size() {
        return size;
    }





    public  class ListLtr implements ListIterator<E>{

//        private LinkedList.Node<E> lastReturned;
//        private LinkedList.Node<E> next;
//        private int nextIndex;
//        private int expectedModCount = modCount;
//
        private MyLinklist.Node<E> lastReturned;
        private MyLinklist.Node<E> next;
        private int nextIndex;


        public ListLtr(int index){

              this.next = node(index);
              this.nextIndex =  index;
        }


        Node<E> node(int index){





//            if (index < (size >> 1)) {
//                LinkedList.Node<E> x = first;
//                for (int i = 0; i < index; i++)
//                    x = x.next;
//                return x;
//            } else {
//                LinkedList.Node<E> x = last;
//                for (int i = size - 1; i > index; i--)
//                    x = x.prev;
//                return x;
//            }
        // 根据下标  使用分割的方式 查找第一个
            if (index < (size >> 1)){
                  MyLinklist.Node<E> x = first;
                  for (int i=0;i<index;i++) {
                      x = x.next;
                  }
                  return x;
            }else {

                MyLinklist.Node<E> x = last;

                for (int i = size - 1;i>index;i--){
                    x = x.prev;
                }
                return x;
            }




        }

        
        
        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            
            if (!hasNext()){
                throw  new NoSuchElementException();
            }

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        
        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }


    public static void main(String[] args) {


        MyLinklist<Object> objects = new MyLinklist<>();


        objects.add(1);
        objects.add(3);
        objects.add(2);
        objects.add(2);

        for (Object o:objects
             ) {
            System.out.println(o);
        }


        Iterator<Object> iterator = objects.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }



//
//    private int size;
//
//    private transient Object[]  arr;

//    private Object[]  INIT_ARR = {};
//
//    private final static int DEFAULT_SIZE = 10;
//
//    private final static int MAX_SIZE = Integer.MAX_VALUE - 8;
//
//
//    public MyLinklist(){
//        this.arr = INIT_ARR;
//    }
//
//
//    public  boolean add(E e){
//
//        checkArrCapacity(size + 1);
//        arr[size++] = e;
//        return true;
//    }
//
//
//    public void checkArrCapacity(int capacity){
//
//          ifCapacity(returnArrSize(arr,capacity));
//
//    }
//
//
//
//    public void ifCapacity(int capacity){
//
//
//         if (capacity - arr.length > 0){
//                grow(capacity);
//         }
//
//    }
//
//
//    public void grow(int capacity){
//
//
//        int oldCapacity = arr.length;
//        int newCapacity = oldCapacity + ( oldCapacity >> 1 );
//
//
//        if (newCapacity - capacity < 0) {
//              newCapacity = capacity;
//        }
//
//        if (newCapacity > MAX_SIZE){
//            newCapacity = hun(capacity);
//        }
//    }
//
//    public int hun(int capacity){
//
//
//        if (capacity < 0 ){
//            throw  new OutOfMemoryError("内存溢出");
//        }
//
//        return capacity >  MAX_SIZE ? Integer.MAX_VALUE : MAX_SIZE;
//
//
//    }
//
//
//
//
//
//
//    public int returnArrSize(Object[] arr,int capacity){
//            if (arr == INIT_ARR){
//                 arr = new Object[DEFAULT_SIZE];
//                return Math.max(arr.length,capacity);
//            }
//            return capacity;
//    }
//
//
//
//
//
//    @Override
//    public E get(int index) {
//        return (E) arr[index];
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }












}
