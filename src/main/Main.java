package main;

import java.util.*;

public class Main {
    public static void main(String[] args){
        menuBar();

    }
    public static void menuBar(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        boolean isActive = true;
        while(isActive && choice != 6){
            System.out.println("What exercise do you want to test?\n" +
                    "1 - ArrayList 1\n"+
                    "2 - LinkedList\n"+
                    "3 - Stack\n"+
                    "4 - Queue\n"+
                    "5 - Hashmap\n"+
                    "6 - Exit\n"+
                    "Your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1: testMyArrayList();
                case 2: testMyLinkedList();
                case 3: testMyStack();
                case 4: testMyQueue();
                case 5: testMyHashMap();
                case 6: isActive = false;
            }
        }


    }
    public static void testMyArrayList(){
        MyArrayList <Integer> list = new MyArrayList<>();
        list.add(13);
        list.add(12);
        list.add(11);
        System.out.println("list2.getByIndex(0) = " + list.getByIndex(0));
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.clear();
        System.out.println("list2.getSize() = " + list.getSize());
        System.out.println(list);

        list.add(13);
        list.remove(4);
    }
    public static void testMyStack(){
        MyStack <Integer> stack = new MyStack<>();
        for(int i = 0; i < 10; i++){
            stack.push(i);
        }

        System.out.println(stack);

        stack.pop();

        System.out.println(stack);

        stack.remove(0);
        System.out.println(stack);

        System.out.println("stack.size() = " + stack.size());
        System.out.println("stack.getCapacity() = " + stack.getCapacity());
        stack.trimToSize();
        System.out.println("stack.getCapacity() = " + stack.getCapacity());

        stack.clear();

    }
    public static void testMyQueue(){
        MyQueue <Integer> myQueue = new MyQueue<>();
        for(int i = 0; i < 10; i++){
            myQueue.push(i);
        }
        System.out.println(myQueue);
        System.out.println("myQueue.pop() = " + myQueue.pop());
        System.out.println(myQueue);

    }
    public static void testMyLinkedList(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        System.out.println("list.get(0) = " + list.get(0));
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.get(5) = " + list.get(5));
        System.out.println(list);
        list.remove(5);
        System.out.println(list);
        list.remove(8);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);

    }
    public static void testMyHashMap(){
        MyHashMap<String,Integer> myHashMap = new MyHashMap<>();

        myHashMap.put("first", 1);
        myHashMap.put("second",2);
        myHashMap.put("third",3);
        myHashMap.put("forth",4);
        myHashMap.put("fifth",5);
        System.out.println(myHashMap);
        myHashMap.remove("first");
        myHashMap.remove("third");
        myHashMap.remove("fifth");
        System.out.println();
        System.out.println(myHashMap);
        System.out.println(myHashMap.get("forth"));
    }
}

