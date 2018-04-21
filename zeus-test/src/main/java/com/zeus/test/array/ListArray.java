package com.zeus.test.array;

import groovy.transform.builder.DefaultStrategy;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author keven
 * @date 2018-03-30 上午10:27
 * @Description 线性表的数组 实现
 */
public class ListArray implements List {

    private final int LEN = 8;


    private int size;

    private Object[] elements;


    public ListArray() {
        size = 0;
        elements = new Object[LEN];
    }

    //返回线性表的大小，即数据元素的个数
    public int getSize() {
        return size;
    }


    @Override
    public int size() {
        return 0;
    }


    // 如果 线性表为空 返回 true. 否则返回false
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    //判断线性表 是否 包含 数据元素 e
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elements.length; i++) {
            return elements[i].equals(o);
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }


    //将 数据元素e 插入到 线性表中 i 的位置
    public void insert(int i, Object e) {
        if (i<0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("");
        }
        if (size >= elements.length) {
            //进行扩容操作();
        }
        for (int j = size; j> i; j--) {
            elements[j] = elements[j -1];
            elements[i] = e;
            size ++;
        }
    }
}
