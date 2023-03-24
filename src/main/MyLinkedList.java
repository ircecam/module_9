package main;


public class MyLinkedList <T>{
    private static class MyNode<T> {
        T item;
        MyNode<T> next;
        MyNode<T> prev;

        MyNode(MyNode<T> prev, T element, MyNode<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
        @Override
        public String toString(){
            return item.toString();
        }
    }
    private int size = 0;
    private MyNode<T> first;
    private MyNode<T> last;

    public void add(T element){
        final MyNode<T> l = last;
        final MyNode<T> newNode = new MyNode<>(l,element,null);
        last = newNode;
        if(l == null){
            first = newNode;
        }
        else
            l.next = newNode;
        size++;
    }

    public T get(int index){
        MyNode<T> currentNode = first;
        if(index > 0){
            for(int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
        }
        return currentNode.item;
    }

    public void remove(int index){
        MyNode<T> currentNode = first;
        if(index > 0){
            for(int i = 0; i < index; i++){
                currentNode = currentNode.next;
            }
        }
        MyNode<T> prevNode;
        if(currentNode != first && currentNode != last){
            prevNode = currentNode.prev;
            MyNode<T> nextNode = currentNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            currentNode = null;
        }
        else if(currentNode == first){
            first = first.next;
            first.prev = null;
        }
        else{
            last = last.prev;
            last.next = null;
        }
        size--;
    }

    public String toString(){
            StringBuilder res =  new StringBuilder();
            MyNode<T> currentNode = first;
            for(int i = 0; i < size; i++){
                res.append(currentNode.toString()).append(" -> ");
                currentNode = currentNode.next;
            }
            if(res.length() > 4){
                res.delete(res.length() - 4, res.length());
            }
            return res.toString();
    }
    public int getSize(){
        return size;
    }
    public void clear(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null && last == null;
    }


}
