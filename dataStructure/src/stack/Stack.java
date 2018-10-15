package stack;


import vector.Vector;

public class Stack<T> extends Vector<T> {
    void push(T e){
        insert(size(),e);
    }
    T pop(){
        return remove(size()-1);
    }
    T top(){
        return this.get(size()-1);
    }

}
