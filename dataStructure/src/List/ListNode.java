package List;

public class ListNode<T> {
    private T data;
    private ListNode<T> pred;
    private ListNode<T> succ;
    public ListNode(){
    }
    public ListNode(T e,ListNode<T> pred,ListNode<T> succ){
        this.data=e;
        this.pred = pred;
        this.succ= succ;
    }
    public ListNode<T> insertAsPred(T e){
        ListNode<T> x = new ListNode<T>(e,pred,this);
        pred.succ= x;
        pred = x;
        return x;
    }
    public ListNode<T> insertAsSucc(T e){
        ListNode<T> x = new ListNode<T>(e,this,succ);
        succ.pred= x;
        succ= x;
        return x;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getPred() {
        return pred;
    }

    public void setPred(ListNode<T> pred) {
        this.pred = pred;
    }

    public ListNode<T> getSucc() {
        return succ;
    }

    public void setSucc(ListNode<T> succ) {
        this.succ = succ;
    }
}
