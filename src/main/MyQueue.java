package main;

import java.util.Arrays;

public class MyQueue <T>{
    private T [] arr;
    private int first;
    private int top;
    private int capacity;

    public MyQueue(int initialCapacity){
        capacity = initialCapacity;
        arr = (T[]) new Object[capacity];
        first = 0;
        top = -1;
    }

    public MyQueue(){
        this(0);
    }
    private T[] growArr(T [] array, int capacity, int intendedCapacity){
        int growValue = (intendedCapacity - capacity);
        T [] newArr = Arrays.copyOf(array,capacity + growValue);
        array = newArr;
        this.capacity = capacity + growValue;
        return array;
    }

    public void trimToSize(){
        arr = growArr(arr,capacity,top + 1);
    }

    public void push(T value){
        if(top + 1 == capacity || top <= first){
            arr = growArr(arr,capacity,capacity + 1);
        }
        arr[++top] = value;
    }




    private boolean isIndexInArray(int index){
        boolean res = index >= first && index <= top;
        return res;
    }
    public T peek(){
        if(first <= -1){
            throw new ArrayIndexOutOfBoundsException();
        }
        return arr[first];
    }

    public T pop(){
        T deletedValue = peek();
        arr[first] = null;
        first++;
        return deletedValue;
    }



    @Override
    public String toString(){
        StringBuilder res =  new StringBuilder();
        for(int i = first; i <= top; i++){
            res.append(arr[i].toString()).append(" -> ");
        }
        if(res.length() > 4){
            res.delete(res.length() - 4, res.length());
        }
        return res.toString();
    }

}
