package com.zeus.test.array;

/**
 * @author keven
 * @date 2018-03-30 上午11:19
 * @Description
 */
public class Array {

    private Object[] elements;

    private Integer size;

    private Integer len = 8;

    public Array() {
        size = 0;
        elements = new Object[len];
    }

    public Integer getSize() {
        return size;
    }


    /**
     * 添加操作
     *
     * @param index 要插入的位置
     * @param e     要插入的元素
     */
    private void add(int index, Object e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("");
        }
        if (size >= elements.length) {
            //扩容操作
        }

        elements[index] = e;
        size ++;
    }


    //扩容
    private void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }


    private Object get(int index) {
        if (index < 0 || index > 0) {
            return new ArrayIndexOutOfBoundsException("");
        }
        return elements[index];
    }


    public static void main(String[] args) {

        Array array = new Array();
        array.add(0, 1);

        Object obj = array.get(0);
        System.out.println("obj :" + obj);

    }


}
