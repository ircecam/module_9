package main;

import java.util.Arrays;
import java.util.EmptyStackException;


public class MyStack <T>{
    private T [] arr;
    private int top;
    private int capacity;

    public MyStack(int initialCapacity){
        capacity = initialCapacity;
        arr = (T[]) new Object[capacity];
        top = -1;
    }

    public MyStack(){
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
        if(top + 1 == capacity){
            arr = growArr(arr,capacity,capacity + 1);
        }
        arr[++top] = value;
    }

    public T peek(){
        if(top <= -1){
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public int size(){
        return top + 1;
    }
    public int getCapacity(){
        return capacity;
    }

    public void clear(){
        capacity = 0;
        arr = (T[]) new Object[capacity];
        top = -1;
    }
    public void remove(int index){
        if(top > -1){
            if(isIndexInArray(index)){
                for (int i = index; i < top; i++){
                    arr[i] = arr[i+1];
                }
                arr[top--] = null;
            }
            else{
                throw new IndexOutOfBoundsException("Illegal index: " + index);
            }
        }
        else{
            throw new EmptyStackException();
        }
    }

    private boolean isIndexInArray(int index){
        boolean res = index >= 0 && index <= top;
        return res;
    }

    public T pop(){
        T deletedValue = peek();
        remove(top);
        return deletedValue;
    }

    @Override
    public String toString(){
        StringBuilder res =  new StringBuilder();
        for(int i = 0; i <= top; i++){
            res.append(arr[i].toString()).append(" -> ");
        }
        if(res.length() > 4){
            res.delete(res.length() - 4, res.length());
        }
        return res.toString();
    }


}
