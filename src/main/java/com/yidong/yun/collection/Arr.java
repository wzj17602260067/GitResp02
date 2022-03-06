package com.yidong.yun.collection;

import org.checkerframework.checker.units.qual.A;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;

public class Arr  extends AbstractList<Object> {





    private transient Object[] objects;
    private int size;


    public Arr(){
         this(10);
    };

    public Arr(int num){
        this.objects = new Object[num];
    }



    @Override
    public Object get(int index) {
        Object object = objects[index];

        return object;
    }

    @Override
    public int size() {
        return size;
    }

    public boolean add(Object e){

        objects[size++] = e;
        return true;
    }



    public void  ensureCapacityInternal(int size){

        int length = objects.length;

        if (size > length){
            Object[] o = new Object[size << 1];

            

        }




    }


}
