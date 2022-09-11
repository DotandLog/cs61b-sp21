package deque;

public class LinkedListDeque<T>{

    public Node sentinel;
    public Node temp;
    private int size;
    public class Node{
        public Node prev;
        public T item;
        public Node next;

        public Node(T newItem){
            item = newItem;
        }

    }


    public LinkedListDeque(){
        sentinel = new Node(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(LinkedListDeque other){
        sentinel = new Node(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for(int i = 0; i < other.size; i++){
            addLast((T)other.get(i));
        }

        size = other.size;
    }


    public void addFirst(T item){
        temp = new Node(item);
        if(sentinel.next == sentinel){
            sentinel.next = temp;
            temp.prev = sentinel;
            temp.next = sentinel;
            sentinel.prev = temp;
        }
        else {
            temp.next = sentinel.next.prev;
            sentinel.next = temp.prev;
        }
        size++;
    }

    public void addLast(T item){
        temp = new Node(item);
        if(sentinel.next == sentinel){
                sentinel.next = temp;
                temp.prev = sentinel;
                temp.next = sentinel;
                sentinel.prev = temp;
        }
        else {
            temp.prev = sentinel.prev;
            temp.next = sentinel;
            sentinel.prev.next = temp;
            sentinel.prev = temp;
        }
        size++;
    }

    public boolean isEmpty(){
        boolean isEmpty = false;
        if(size == 0){
            isEmpty = true;
        }
        return isEmpty;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if(sentinel.next == sentinel){
            return;
        }
        for(int i = 0; i < size; i++){
            Node temp = sentinel.next;
            System.out.println(temp.item);
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public T removeFirst(){
        if(sentinel.prev == sentinel){
            return null;
        }
        T removedItem = sentinel.next.item;
        sentinel.next= sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size--;
        return removedItem;
    }

    public T removeLast(){
        if (sentinel.prev == sentinel){
            return null;
        }
        T removedItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size--;
        return removedItem;
    }

    public T get(int index){
        temp = sentinel.next;
        if(index == 1){
            return sentinel.next.item;
        }
        for (int i = 0; i < index; i++){
            temp.next = sentinel.next.next;
        }
        return temp.next.item;
    }
}
