package List;

public class ListExt<T> extends List<T> {

    public ListExt() { init(); } //默认
    //整体复制列表L
    public ListExt ( ListExt<T>  L ){

    };
    //复制列表L中自第r项起的n项
    public ListExt ( ListExt<T>  L, int r, int n ){

    }
    //复制列表中自位置p起的n项
    public ListExt ( ListNode<T> p, int n ){

    }
    @Override
    public void init() {
        header= new ListNode<T>();
        trailer = new ListNode<T>();
        trailer=this.header.getSucc();
        ListNode<T> listNode1=header.getPred();
        listNode1=null;
        header=trailer.getPred();
        ListNode<T> listNode2= trailer.getSucc();
        listNode2=null;
        _size=0;
    }

    @Override
    public ListNode<T> get(int r) {
        if(r<=0||r> _size)
            return null;
        ListNode<T> p =null;
        if(r<_size>>1){
            p=first();
            while (0<r--)
                p=p.getSucc();
        }else {
            p=last();
            while (0<r--)
                p=p.getPred();
        }
        return p;
    }

    @Override
    public int clear() {
        int oldSize= _size;
        while (0<_size)
            remove(header.getSucc());
        return oldSize;
    }

    @Override
    public void copyNodes(ListNode<T> p,int n) {
        init();
        while(n-->0){
           insertAsLast(p.getData());
           p=p.getSucc();
        }
    }

    @Override
    public void merge(ListNode<T> node1, int l1, List<T> node2, ListNode<T> node3, int l2) {

    }

    @Override
    public void mergeSort(ListNode<T> p, int n) {

    }

    @Override
    public void selectionSort(ListNode<T> p, int n) {
        ListNode<T> head = p.getPred();
        ListNode<T> tail = p;
        for (int i=0;i<n;i++){
            tail =tail.getSucc();
        }
        while (1<n){
            insertB(tail,remove(selectMax(head.getSucc(),n)));
            tail = tail.getPred();
            n--;
        }
    }

    @Override
    public void insertionSort(ListNode<T> p, int n) {
         for (int r=0;r<n;r++){
             insertA(search(p.getData(),r,p),p.getData());//查找+插入
             p= p.getSucc();
             remove(p.getPred());
         }
    }



    @Override
    public int disordered() {
        return 0;
    }

    @Override
    public ListNode<T> find(T e, int n, ListNode<T> p) {
        while(0<n--)
            if(e==((p=p.getPred()).getData()))
                return p;
        return null;
    }

    @Override
    public ListNode<T> search(T e, int n, ListNode<T> p) {
        while(0<n--)
            if(lt((p=p.getPred()).getData(),e))
                break;
        return p;
    }

    @Override
    public ListNode<T> selectMax(ListNode<T> p, int n) {
        ListNode<T> max =p;
        for (ListNode<T> cur=p;1<n;n--)
            if (!lt((cur= cur.getSucc()).getData(),max.getData()))
             max =cur;
        return max;
    }

    //less than
    private boolean lt(T data, T data1) {
        if (data instanceof Integer && data1 instanceof Integer)
            return (Integer)data<(Integer) data1;
        return false;
    }


    @Override
    public ListNode<T> insertAsFirst(T e) {
        return insertA(header,e);
    }

    @Override
    public ListNode<T> insertAsLast(T e) {
        return insertB(trailer,e);
    }

    @Override
    public ListNode<T> insertA(ListNode<T> p, T e) {
        _size++;
        return p.insertAsPred(e);
    }

    @Override
    public ListNode<T> insertB(ListNode<T> p, T e) {
        _size++;
        return p.insertAsSucc(e);
    }

    @Override
    public T remove(ListNode<T> p) {
        T e = p.getData();
        ListNode<T> listNode1=p.getPred().getSucc();
        listNode1 = p.getSucc();
        ListNode<T> listNode2=p.getSucc().getPred();
        listNode2 = p.getPred();
        p=null;
        _size--;
        return e;
    }

    @Override
    public void sort(ListNode<T> p, int n) {

    }

    @Override
    public int deduplicate() {
        if (_size<2)
            return 0;
        int oldSize = _size;
        ListNode<T> p =first();
        int r= 1;
        while (trailer!=(p=p.getSucc())){
            ListNode<T> q= find(p.getData(),r,p);
            if (q != null) {
                remove(q);
            } else {
                r++;
            }
        }
        return oldSize-_size;
    }

    @Override
    public int uniquify() {
        if (_size<2)
            return 0;
        int oldSize = _size;
        ListNode<T> p =first();//p为各区段起点，q为其后继
        ListNode<T> q;
        while (trailer!=(q=p.getSucc())){
            if (p.getData() != q.getData()) {
                p=q;
            } else {
                remove(q);
            }
        }
        return oldSize-_size;
    }

    @Override
    public void reverse() {

    }

    @Override
    public void traverse() {

    }
}
