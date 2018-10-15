package tree;

public class BinTree<T> {
    protected int size;
    protected BinNode<T> root;
    protected int updateHeight(BinNode<T> x){

    }

    protected void updateHeightAbove(BinNode<T> x){

    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public BinNode<T> root(){
        return root;
    }


}
