package com.zeus.test.array;

/**
 * @author keven
 * @date 2018-03-31 下午2:26
 * @Description 自己用 数组 来实现 线性表
 */
public class ArrayList<E> {


    //数组的元素
    Object[] elements = {};

    //数组的大小
    int size;

    //保存当前为第几个元素的指标
    int current;


    public ArrayList() {
        this(10);
    }


    public ArrayList(int initalSize) {
        if (initalSize < 0) {
            throw new RuntimeException("");
        } else {
            this.elements = new Object[initalSize];
            this.current = 0;
            size = initalSize;
        }
    }

    /**
     * 添加 元素，要先判断数组的容量 是否已经满了
     *
     * @param obj 要添加的元素
     * @return 结果
     */
    public boolean add(Object obj) {
        ensureCapacity(current);
        this.elements[current] = obj;
        current++;
        size++;
        return true;
    }


    // 判断当前数组的容量是否已满, 满了的话，给当前的容量加10，然后创建一个新的数组，把老的数组的值赋值过去，然后把新的指向老的
    private void ensureCapacity(int current) {
        if (current == size) {
            this.size = this.size + 10;
            Object[] newElments = new Object[size];
            for (int i = 0; i < current; i++) {
                newElments[i] = this.elements[i];
            }
            this.elements = newElments;
        }
    }


    public E get(int index) {
        validateIndex(index);
        return (E) this.elements[index];
    }


    private void validateIndex(int index) {
        if (index < 0 || index > current) {
            throw new ArrayIndexOutOfBoundsException("");
        }
    }


    // 指定位置上 插入元素
    public boolean insert(int index, Object e) {
        validateIndex(index);
        // 用一个临时 数组作为备份
        Object[] term = new Object[size];

        for (int i = 0; i < size; i++) {
            if (i < index) {
                term[i] = this.elements[i];
            } else if (i == index) {
                term[i] = e;
            } else if (i > index) {
                term[i] = this.elements[i - 1];
            }
        }

        this.elements = term;
        return true;
    }


    // 删除指定位置的 元素
    public boolean delete(int index) {
        validateIndex(index);
        //同样用一个数组来做备份
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            if (index > i) {
                temp[i] = elements[i];
            } else if (index == i) {
                temp[i] = this.elements[i + 1];
            } else if (index < i) {
                temp[i] = elements[i + 1];
            }
        }
        this.elements = temp;
        return true;
    }



    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);

        int len = arrayList.size;
        System.out.println(len);

        arrayList.insert(2, 111);

        int num = arrayList.get(2);
    }

}
