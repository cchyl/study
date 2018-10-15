package List;

public abstract class List<T> {
    protected int _size;
    protected ListNode header, trailer; //规模、头哨兵、尾哨兵
    public abstract void init(); //列表创建时的初始化
    public abstract int clear(); //清除所有节点
    public abstract void copyNodes ( ListNode<T> p,int n); //复制列表中自位置p起的n项
    public abstract void merge ( ListNode<T> node1, int l1, List<T> node2, ListNode<T> node3, int l2 ); //归并
    public abstract void mergeSort ( ListNode<T> p, int n); //对从p开始连续的n个节点归并排序
    public abstract void selectionSort ( ListNode<T> p, int n); //对从p开始连续的n个节点选择排序
    public abstract void insertionSort ( ListNode<T> p, int n); //对从p开始连续的n个节点插入排序

    public abstract ListNode<T> get(int r);
 // 只读访问接口
    public int size()  { return _size; } //规模
    public boolean empty()  { return _size <=0 ; } //判空
    public ListNode<T> first()  { return header.getSucc(); } //首节点位置
    public ListNode<T> last()  { return trailer.getPred(); } //末节点位置
    public boolean valid ( ListNode<T> p ) //判断位置p是否对外合法
                    { return p!=null && ( trailer != p ) && ( header != p ); } //将头、尾节点等同于NULL
    public abstract int disordered() ; //判断列表是否已排序
    public ListNode<T> find ( T  e )  //无序列表查找
    { return find ( e, _size, trailer ); }
    public abstract ListNode<T> find ( T  e, int n, ListNode<T> p ) ; //无序区间查找
    public ListNode<T> search ( T  e )  //有序列表查找
                    { return search ( e, _size, trailer ); }
    public abstract     ListNode<T> search ( T  e, int n, ListNode<T> p ) ; //有序区间查找
    public abstract ListNode<T> selectMax ( ListNode<T> p, int n ); //在p及其n-个后继中选出最大者
    public ListNode<T> selectMax() { return selectMax ( header.getSucc(), _size ); } //整体最大者
 // 可写访问接口
    public abstract ListNode<T> insertAsFirst ( T  e ); //将e当作首节点插入
    public abstract ListNode<T> insertAsLast ( T  e ); //将e当作末节点插入
    public abstract ListNode<T> insertA ( ListNode<T> p, T  e ); //将e当作p的后继插入（After）
    public abstract ListNode<T> insertB ( ListNode<T> p, T  e ); //将e当作p的前驱插入（Before）
    public abstract T remove ( ListNode<T> p ); //删除合法位置p处的节点,返回被删除节点
    public void merge ( List<T> L ) { merge ( first(), size(), L, L.first(), L._size ); } //全列表归并
    public abstract void sort ( ListNode<T> p, int n ); //列表区间排序
    public void sort() { sort ( first(), _size ); } //列表整体排序
    public abstract int deduplicate(); //无序去重
    public abstract int uniquify(); //有序去重
    public abstract void reverse(); //前后倒置（习题）
    public abstract void traverse();
/* // 遍历
            void traverse ( void (* ) ( T& ) ); //遍历，依次实施visit操作（函数指针，只读或局部性修改）
    template <typename VST> //操作器
                    void traverse ( VST& ); //遍历，依次实施visit操作（函数对象，可全局性修改）*/

}
