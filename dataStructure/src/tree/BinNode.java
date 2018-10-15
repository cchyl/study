package tree;

public class BinNode<T> {
    private BinNode<T> parent,lChild,rChild;
    private T data;
    private int height;
    public BinNode(T e,BinNode binNode){

    }
    public int size(){//后代总数
        int size = 1;
        if (lChild!=null)
            size+=lChild.size();
        if (rChild!=null)
            size+=rChild.size();
        return size;
    }
    public BinNode<T> insertAsLc(T e){
        return lChild = new BinNode(e,this);
    }
    BinNode<T> insertAsRc(T e){
        return rChild = new BinNode<>(e,this);
    }
    BinNode<T> succ();//直接后继
    void travLevel();//层次遍历
    void travPre();//先序遍历
    void travIn();//中序遍历
    void travPost();//后序遍历
}
