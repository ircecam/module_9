package main;

import java.util.Arrays;


public class MyArrayList<T> {

    private T [] arr;
    private int size;

    public MyArrayList(){
        size = 0;
        arr = (T[]) new Object[size];
    }

    private T[] growArr(T [] array, int s){
        T [] newArr = Arrays.copyOf(array,s + 1);
        array = newArr;
        return array;
    }

    public void add(T value){
        if(size == arr.length){
            arr = growArr(arr,size);
        }
        arr[size] = value;
        size = size + 1;
    }

    public void remove(int index){
        if(getSize() > 0){
            if(isIndexInArray(index)){
                for (int i = index; i < size - 1; i++){
                    arr[i] = arr[i+1];
                }
                size--;
                arr[size] = null;
            }
            else{
                throw new IndexOutOfBoundsException("Illegal index: " + index);
            }
        }
        else{
            throw new IndexOutOfBoundsException("Array is empty");
        }
    }

    private boolean isIndexInArray(int index){
        boolean res = false;
        if(index >= 0 && index < size){
            res = true;
        }
        return res;
    }

    public int getSize(){
        return size;
    }

    public T getByIndex(int index){
        if(isIndexInArray(index)){
            return arr[index];
        }
        else{
            throw new IndexOutOfBoundsException("Illegal index: " + index);
        }

    }
    public void clear(){
        size = 0;
        arr = (T[]) new Object[size];
    }


    @Override
    public String toString(){
        StringBuffer res =  new StringBuffer("[");
        for(int i = 0; i < size; i++){
            res.append(arr[i].toString()).append(", ");
        }
        if(res.length() > 2){
            res.delete(res.length() - 2, res.length());
        }
        return res.toString() + "]";
    }


}
