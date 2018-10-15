package queue;


import List.ListExt;

public class Queue<T> extends ListExt<T> {
    public void enqueue(T e){
        insertAsLast(e);
    }

    T dequeue(){
        return remove(first());
    }

    T font(){
        return first().getData();
    }
}
