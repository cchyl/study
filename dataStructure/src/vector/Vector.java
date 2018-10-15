package vector;

import java.util.Date;

public class Vector<T> implements IVector<T>{
    protected int size;//当前元素的个数
    protected int capacity;//最大容量
    protected Object[] elem;//元素
    private static final int DEFAULT=3;
    public Vector(){
        this(DEFAULT,0);
    }

    public Vector(int initCapa,int initSize){
        this.capacity = initCapa;
        this.elem=new Object[initCapa];
        this.size=initSize;
    }

    public T get(int i){
        return (T)elem[i];
    }
    @Override
    public void copyFrom(Object[] objects, int lo, int hi) {
        elem=new Object[capacity=2*(hi-lo)];
        size=0;
        while(lo<hi)
            elem[size++]=objects[lo++];
    }

    @Override
    public void expand() {
        if(size<capacity)
            return;
        capacity = max(capacity,DEFAULT);
        Object[] oldElem = elem;
        elem = new Object[capacity<<=1];
        for (int i=0;i<size;i++)
            elem[i]= oldElem[i];
    }

    @Override
    public void shrink() {
        if(capacity<DEFAULT<<1)//capa<default*2
            return;
        if(size<<2>capacity)//size*4>cap
            return;
        Object[] oldElem = elem;
        elem = new Object[capacity>>=1];//容量减半
        for (int i=0;i<size;i++)
            elem[i]= oldElem[i];
    }

    @Override
    public boolean bubble(int lo, int hi) {
        return false;
    }

    @Override
    public void bubbleSort(int lo, int hi) {

    }

    @Override
    public int max(int lo, int hi) {
        return (lo >= hi) ? lo : hi;
    }

    @Override
    public void selectionSort(int lo, int hi) {

    }

    @Override
    public void merge(int lo, int mi, int hi) {

    }

    @Override
    public void mergeSort(int lo, int hi) {

    }

    @Override
    public int partition(int lo, int hi) {
        return 0;
    }

    @Override
    public void quickSort(int lo, int hi) {

    }

    @Override
    public void heapSort(int lo, int hi) {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size==0;
    }

    @Override
    public int disordered() {
        int n =0;
        for(int i=1;i<size;i++)
            n += compareTo(elem[i - 1],elem[i]);
        return n;
    }

    private static int compareTo(Object o1,Object o2){
        if(o1 instanceof Integer&&o2 instanceof Integer)
            return (Integer)o1<(Integer)o2?-1:(Integer)o2<(Integer)o1?1:0;
        else if (o1 instanceof Double&&o2 instanceof Double)
            return (Double)o1<(Double)o2?-1:(Double)o2<(Double)o1?1:0;
        else if (o1 instanceof Float&& o2 instanceof Float)
            return (Float)o1<(Float)o2?-1:(Float)o2<(Float)o1?1:0;
        else if(o1 instanceof Date && o2 instanceof Date)
            return ((Date) o1).before((Date)o2)?-1:((Date)o2).before((Date)o1)?1:0;
        return 0;
    }
    @Override
    public int find(T e) {
        return this.find(e,0,size);
    }

    @Override
    public int find(T e, int lo, int hi) {
        while (lo<hi--&&e!=elem[hi]);
        return hi;
    }

    @Override
    public int search(T e) {
        return 0;
    }

    @Override
    public int search(T e, int lo, int hi) {
        return 0;
    }

    public int binSearch(Object[] elem,T e,int lo,int hi){
        while(lo<hi){
            int mi = (lo+hi)>>1;
            int compare = compareTo(e,elem[mi]);
            if(compare==-1)
                hi=mi;
            else if (compare==1)
                lo=mi+1;
            else
                return mi;
        }
        return -1;
    }

    public int binSearch2(int[] A,int e,int lo,int hi){
        while(1<hi-lo){
            int mi = (lo+hi)>>1;
            if(e < A[mi])
                hi=mi;
            else
                lo= mi;
        }
        return (e==A[lo])?lo:-1;
    }

    public int binSearch3(int[] A,int e,int lo,int hi){
        while(lo<hi){
            int mi = (lo+hi)>>1;
            if(e < A[mi])
                hi=mi;
            else
                lo= mi+1;
        }
        return --lo;
    }

    public int Search3(int[] A,int e,int lo,int hi){
        while(lo<hi){
            int mi = (lo+hi)>>1;
            if(e < A[mi])
                hi=mi;
            else
                lo= mi+1;
        }
        return --lo;
    }


    public int fibSearch(Object[] elem,T e,int lo,int hi){
        Fib fib=new Fib(hi-lo);//创建fib数列
        while (lo<hi){
            while(hi-lo<fib.get())
                fib.prev();
            int mi = lo+fib.get()-1;
            int compare = compareTo(e,elem[mi]);
            if(compare==-1)
                hi=mi;
            else if (compare==1)
                lo=mi+1;
            else
                return mi;
        }
        return -1;
    }

    class Fib{
        private int f,g;//f=fib(k-1).g=fib(k)
        public Fib(int n){
            f=1;
            g=0;
            while(g<n)
                next();
        }
        int get(){
            return g;
        }
        int next(){
            g+=f;
            f=g-f;
            return g;
        }
        int prev(){
            f=g-f;
            g-=f;
            return g;
        }
    }
    @Override
    public T remove(int r) {
        Object e= elem[r];
        remove(r,r+1);
        return (T)e;
    }

    @Override
    public int remove(int lo, int hi) {
        if (lo==hi)
            return 0;
        while (hi<size)
            elem[lo++]=elem[hi++];
        size=lo;
        shrink();
        return hi-lo;

    }

    @Override
    public int insert(int r, T e) {
        expand();
        for(int i=size;i<r;i++)
            elem[i]=elem[i-1];
        elem[r]=e;
        size++;
        return r;
    }

    @Override
    public int insert(T e) {
      this.insert(size,e);
      return size;
    }


    @Override
    public void sort(int lo, int hi) {

    }

    @Override
    public void sort() {

    }

    @Override
    public void unsort(int lo, int hi) {

    }

    @Override
    public void unsort() {

    }

    @Override
    public int deduplicate() {
        int oldSize = size;
        int i=1;
        while(i<size) {
            if (find((T) elem[i], 0, i) >= 0) {
                remove(i);
            } else {
                i++;
            }
        }
        return oldSize-size;
    }

    @Override
    public int uniquify() {
        int i=0,j=0;
        while(++j<size)
            if(elem[i]!=elem[j])
                elem[++i]=elem[j];
        size=++i;
        shrink();
        return j-i;
    }

    @Override
    public void traverse() {

    }


    public void traverse(Vector<T> v) {

    }
}
