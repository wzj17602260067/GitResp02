package com.yidong.yun.util;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList<E> extends AbstractList<E> implements List<E> {


    private static final Object[]  EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    private static final int MAX_ARRAY_SIZE =Integer.MAX_VALUE - 8;

    private Object[]  date;

    private int size;



    public MyArrayList(){
        date = EMPTY_ELEMENTDATA;
    }





    public E remove(int index){

            rangeCheck(index);
            E e = (E) date[index];

            int numMoved = size - index - 1;

            if (numMoved > 0)
                System.arraycopy(date,index+1,date,index,numMoved);
            date[--size] = null;
            return e;
    }

    private void rangeCheck(int index) {

         if (index >= size){
              throw  new IndexOutOfBoundsException(OutOfBoundMsg(index));
         }
    }


    public String OutOfBoundMsg(int index){
        return "index" + index + "size" + size;

    }



    public boolean add(E e){
        //  根据size 大小 来看 是否扩容
        ensureCapacityInternal(size + 1);

        date[size++] = e;

        return true;
    }



    public void ensureCapacityInternal(int minCapacity){
          ensureExplicitCapacity(calculateCapacity(date,minCapacity));
    }


    public int calculateCapacity(Object[] element,int minCapacity){
          if (element == EMPTY_ELEMENTDATA){
              return Math.max(DEFAULT_CAPACITY,minCapacity);
          }
          return minCapacity;
    }


    public void ensureExplicitCapacity(int minCapacity){


        if (minCapacity - date.length > 0){
            get(minCapacity);
        }


    }



    public void grow(int minCapacity){

        int oldCapacity = date.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);


        if (newCapacity - minCapacity < 0){
            newCapacity = minCapacity;
        }

        if (newCapacity - MAX_ARRAY_SIZE > 0){
            newCapacity = hugeCapacity(minCapacity);
        }

        date = Arrays.copyOf(date, newCapacity);
    }

    public int hugeCapacity(int minCapacity){

         if (minCapacity < 0 ){
             throw  new OutOfMemoryError("内存溢出");
         }

         return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;


    }



    public int defaultSize(Object[] elementDate,int size){
         if (elementDate == EMPTY_ELEMENTDATA){
             return Math.max(DEFAULT_CAPACITY,size);
         }
         return size;
    }




    @Override
    public int size() {
        return this.size;
    }

    @Override
    public E get(int index) {
        return  (E)date[index];
    }


    public static void main(String[] args) {


        int size = 10;

        int[] a = new int[size];

        for (int i=0;i<a.length;i++){
            a[i] = i;
        }

        System.out.println(Arrays.toString(a));


        int num = 10 - 5 - 1;

        System.arraycopy(a,6,a,5,num);

        a[--size] = 0;

        System.out.println(Arrays.toString(a));


    }


}
