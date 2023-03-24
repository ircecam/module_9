package main;

import java.util.Map;
import java.util.Objects;

public class MyHashMap <K,V>{

    private static class MyNode<K,V>{
        private final K key;
        private V value;
        MyNode next;

        MyNode(K key, V value, MyHashMap.MyNode<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
        public final K getKey(){
            return key;
        }
        public final V getValue(){
            return value;
        }
        public final MyNode<K,V> getNext(){
            return next;
        }
        public void setNext(MyNode<K,V> newNode){
            next = newNode;
        }
        public final String toString(){
            return "[" +  key + " = " + value + "]";
        }
        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }

    private final int DEFAULT_CAPACITY = 16;

    MyNode<K,V> table[] = new MyNode[3];
    private int size;

    public MyHashMap(){
        table = new MyNode[DEFAULT_CAPACITY];
        size = 0;
    }
    public MyHashMap(int capacity){
        if(capacity > 0){
            table = new MyNode[capacity];
            size = 0;
        }
        else throw new IllegalArgumentException();
    }

    private final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void put(K key, V value){
        float loadFactor = (size + 1) / table.length;
        if(loadFactor > 0.75f){
            table = resizeTable();
            System.out.println(table.length);
            if(key != null && value != null)
                table = add(new MyNode<>(key,value,null),table);
        }
        else{
            table = add(new MyNode<>(key,value,null),table);
        }
        size++;
    }
    private MyNode<K,V> [] add(MyNode<K,V> newNode, MyNode<K,V> newTable []) {
        K key = newNode.getKey();
        V value = newNode.getValue();
        int index = Math.abs(hash(key) % newTable.length);
        if (newTable[index] == null) {
            newTable[index] = newNode;
        } else {
            MyNode<K, V> current = newTable[index];
            if(current.getKey().equals(key)){
                current.setValue(value);
            }
            else{
                while(current.getNext() != null){
                    if(current.getKey().equals(key)){
                        current.setValue(value);
                        break;
                    }
                    current = current.getNext();
                }
                current.setNext(newNode);
            }
        }
        return newTable;
    }
    public MyNode<K,V> [] resizeTable(){
        MyNode<K, V>[] oldTable = table;
        MyNode<K, V>[] newTable = new MyNode[oldTable.length * 2];
        for(int i = 0; i < oldTable.length; i++){
            MyNode<K,V> current = oldTable[i];
            while(current != null){
                newTable = add(current,newTable);
                current = current.getNext();
            }
        }
        return newTable;
    }
    public V get(K key){
        int index = Math.abs(hash(key) % table.length);
        V value = null;
        MyNode<K,V> current = table[index];
        if(current != null){
            while (current != null){
                if(current.getKey().equals(key)){
                    value = current.getValue();
                    break;
                }
                current = current.getNext();
            }
        }
        return value;
    }
    public void remove(K key){
        int index = Math.abs(hash(key) % table.length);
        MyNode<K,V> current = table[index];
        MyNode<K,V> prev = null;
        if(current != null){
            while (current != null){
                if(current.getKey().equals(key)){
                    if(prev != null){
                        prev.setNext(current.getNext());
                    }
                    else{
                        table[index] = current.getNext();
                    }
                }
                prev = current;
                current = current.getNext();
            }
            current = null;
            size--;
        }

    }

    public String toString(){
        StringBuilder res = new StringBuilder("");
        for(int i = 0; i < table.length; i++){
            MyNode<K,V> current = table[i];
            while(current != null){
                res.append(current + "\n");
                current = current.getNext();
            }
        }
        return res.toString();
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }
    public void clear(){
        table = new MyNode [DEFAULT_CAPACITY];
        size = 0;
    }

}
