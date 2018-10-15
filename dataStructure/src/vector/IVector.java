package vector;

public interface IVector<T> {
    void copyFrom ( Object[] t, int lo, int hi ); //复制数组区间A[lo, hi)
    void expand(); //空间不足时扩容
    void shrink(); //装填因子过小时压缩
    boolean bubble ( int lo, int hi ); //扫描交换
    void bubbleSort ( int lo, int hi ); //起泡排序算法
    int max ( int lo, int hi ); //选取最大元素
    void selectionSort ( int lo, int hi ); //选择排序算法
    void merge ( int lo, int mi, int hi ); //归并算法
    void mergeSort ( int lo, int hi ); //归并排序算法
    int partition ( int lo, int hi ); //轴点构造算法
    void quickSort ( int lo, int hi ); //快速排序算法
    void heapSort ( int lo, int hi ); //堆排序（稍后结合完全堆讲解）

    // 只读访问接口
    int size(); //规模
    boolean empty(); //判空
    int disordered(); //判断向量是否已排序

    int find (T e );  //无序向量整体查找;
    int find ( T e, int lo, int hi ); //无序向量区间查找
    int search (T e ); //有序向量整体查找
    int search (T e, int lo, int hi ); //有序向量区间查找
    /*// 可写访问接口
    Object[] operator[] ( int r ); //重载下标操作符，可以类似于数组形式引用各元素
        Object[] operator[] ( int r ); //仅限于做右值的重载版本
    Vector<Object[]>  operator= ( Vector<Object[]> ); //重载赋值操作符，以便直接克隆向量*/
    T remove ( int r ); //删除秩为r的元素
    int remove ( int lo, int hi ); //删除秩在区间[lo, hi)之内的元素
    int insert ( int r, T e ); //插入元素
    int insert ( T e ) ; //默认作为末元素插入;
    void sort ( int lo, int hi ); //对[lo, hi)排序
    void sort()  ;//整体排序
    void unsort ( int lo, int hi ); //对[lo, hi)置乱
    void unsort() ; //整体置乱
    int deduplicate(); //无序去重
    int uniquify(); //有序去重
    void traverse();
    // 遍历
   /* void traverse ( void (* ) ( Object[] ) ); //遍历（使用函数指针，只读或局部性修改）
    template <typename VSObject[]> void traverse ( VSObject[] ); //遍历（使用函数对象，可全局性修改）*/
//Vector
    
}
